package us.rst.farmacovigilanza.views;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;
import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.adapters.FactorsAdapter;
import us.rst.farmacovigilanza.adapters.TherapiesAdapter;
import us.rst.farmacovigilanza.database.entity.FactorEntity;
import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.database.entity.TherapyEntity;
import us.rst.farmacovigilanza.databinding.ActivityAddEditPatientBinding;
import us.rst.farmacovigilanza.models.FiscalCode;
import us.rst.farmacovigilanza.viewmodels.PatientViewModel;

public class AddEditPatientActivity extends BaseActivity implements View.OnClickListener,
        FactorsAdapter.OnDeleteClick, TherapiesAdapter.OnDeleteClick {

    @Override protected int getLayoutId() {
        return R.layout.activity_add_edit_patient;
    }

    @Override protected void setToolbar() {
        setSupportActionBar((Toolbar)binding.toolbar);
    }

    @Override protected PatientViewModel getViewModel() {
        if (viewModel == null) {
            PatientViewModel.Factory factory = new PatientViewModel.Factory(getApplication());
            viewModel = ViewModelProviders.of(this, factory).get(PatientViewModel.class);
        }

        return viewModel;
    }

    @Override protected void setBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding.activityAddEditPatientButtonSave.setOnClickListener(this);
        binding.activityAddEditPatientButtonAddRiskFactor.setOnClickListener(this);
        binding.activityAddEditPatientButtonAddTherapies.setOnClickListener(this);
        binding.activityAddEditPatientButtonSaveRiskFactor.setOnClickListener(this);
        binding.activityAddEditPatientButtonSaveTherapy.setOnClickListener(this);

        patientEntity = new PatientEntity();

        getViewModel().getFactors().observe(this, factors -> {
            List<String> factorNames = new ArrayList<>();
            for (FactorEntity f: factors) {
                factorNames.add(f.getName());
            }

            // binding.activityAddEditPatientRiskFactorNames.setDrop(android.R.layout.simple_spinner_dropdown_item);
            binding.activityAddEditPatientRiskFactorNames.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, factorNames));
        });

        getViewModel().getPatientFactors().observe(this, factors -> {
            if (factors == null || factors.size() == 0) {
                binding.activityAddEditPatientNoFactorText.setVisibility(View.VISIBLE);
                binding.activityAddEditPatientRecyclerViewFactors.setVisibility(View.GONE);

                return;
            }

            binding.activityAddEditPatientNoFactorText.setVisibility(View.GONE);
            binding.activityAddEditPatientRecyclerViewFactors.setVisibility(View.VISIBLE);
            binding.activityAddEditPatientRecyclerViewFactors.setLayoutManager(new LinearLayoutManager(this));
            binding.activityAddEditPatientRecyclerViewFactors.setAdapter(new FactorsAdapter(factors, this));
        });

        getViewModel().getPatientTherapies().observe(this, therapies -> {
            if (therapies == null || therapies.size() == 0) {
                binding.activityAddEditPatientNoTherapiesText.setVisibility(View.VISIBLE);
                binding.activityAddEditPatientRecyclerViewTherapies.setVisibility(View.GONE);

                return;
            }

            binding.activityAddEditPatientNoTherapiesText.setVisibility(View.GONE);
            binding.activityAddEditPatientRecyclerViewTherapies.setVisibility(View.VISIBLE);
            binding.activityAddEditPatientRecyclerViewTherapies.setLayoutManager(new LinearLayoutManager(this));
            binding.activityAddEditPatientRecyclerViewTherapies.setAdapter(new TherapiesAdapter(therapies, this));
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_add_edit_patient_button_add_risk_factor:
                binding.activityAddEditPatientNewRiskFactorLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.activity_add_edit_patient_button_add_therapies:
                binding.activityAddEditPatientNewTherapyLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.activity_add_edit_patient_button_save:
                patientEntity.setFiscalCode(FiscalCode.parse(binding.activityAddEditPatientEditTextCf.getText().toString()));
                patientEntity.setBirthDate(Integer.parseInt(binding.activityAddEditPatientEditTextBirthday.getText().toString()));
                patientEntity.setJob(binding.activityAddEditPatientEditTextJob.getText().toString());
                patientEntity.setProvince(binding.activityAddEditPatientEditTextProvince.getText().toString());
                getViewModel().add(patientEntity);
                onBackPressed();
                break;
            case R.id.activity_add_edit_patient_button_save_risk_factor:
                String factorName = binding.activityAddEditPatientRiskFactorNames.getSelectedItem().toString();
                int levelOfRisk = Integer.parseInt(binding.activityAddEditPatientRiskFactorLevel.getText().toString());
                getViewModel().addFactor(factorName, levelOfRisk);

                binding.activityAddEditPatientRiskFactorLevel.setText("");
                break;
            case R.id.activity_add_edit_patient_button_save_therapy:
                String medicine = binding.activityAddEditPatientTherapyMedicine.getText().toString();
                int unit = Integer.parseInt(binding.activityAddEditPatientTherapyUnit.getText().toString());
                int frequency = Integer.parseInt(binding.activityAddEditPatientTherapyFrequency.getText().toString());

                TherapyEntity entity = new TherapyEntity();
                entity.setMedicine(medicine);
                entity.setFrequency(frequency);
                entity.setUnit(unit);

                getViewModel().addTherapy(entity);
                break;
        }
    }

    @Override public void onFactorDelete(String name) {
        getViewModel().deleteFactor(name);
    }

    @Override public void onTherapyDelete(String name) {
        getViewModel().deleteTherapy(name);
    }

    private ActivityAddEditPatientBinding binding;
    private PatientViewModel viewModel;
    private PatientEntity patientEntity;
}

