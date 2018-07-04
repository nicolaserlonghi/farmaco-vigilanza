package us.rst.farmacovigilanza.views;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.adapters.RiskFactorsAdapter;
import us.rst.farmacovigilanza.adapters.TherapiesAdapter;
import us.rst.farmacovigilanza.database.entity.FactorEntity;
import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.databinding.ActivityAddEditPatientBinding;
import us.rst.farmacovigilanza.models.FiscalCode;
import us.rst.farmacovigilanza.viewmodels.AddEditPatientViewModel;

public class AddEditPatientActivity extends BaseActivity implements View.OnClickListener{

    @Override protected int getLayoutId() {
        return R.layout.activity_add_edit_patient;
    }

    @Override protected void setToolbar() {
        setSupportActionBar((Toolbar)binding.toolbar);
    }

    @Override protected AddEditPatientViewModel getViewModel() {
        if (viewModel == null) {
            AddEditPatientViewModel.Factory factory = new AddEditPatientViewModel.Factory(getApplication());
            viewModel = ViewModelProviders.of(this, factory).get(AddEditPatientViewModel.class);
        }

        return viewModel;
    }

    @Override protected void setBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        adapter = new RiskFactorsAdapter();
        binding.activityAddEditPatientButtonSave.setOnClickListener(this);
        binding.activityAddEditPatientButtonAddRiskFactor.setOnClickListener(this);
        binding.activityAddEditPatientButtonAddTherapies.setOnClickListener(this);
        patientEntity = new PatientEntity();
        */
    }

    @Override
    public void onClick(View v) {
        /*
        patientEntity.setFiscalCode(FiscalCode.parse(binding.activityAddEditPatientEditTextCf.getText().toString()));
        patientEntity.setBirthDate(Integer.parseInt(binding.activityAddEditPatientEditTextBirthday.getText().toString()));
        patientEntity.setJob(binding.activityAddEditPatientEditTextJob.getText().toString());
        patientEntity.setProvince(binding.activityAddEditPatientEditTextProvince.getText().toString());
        getViewModel().add(patientEntity);

        getViewModel().getAllRiskFactors().observe(this, riskFactors ->{
            if(riskFactors == null){
                // TODO: aggiungere msg di errore
                return;
            }

            binding.activityAddEditPatientRecyclerViewFactors.setVisibility(View.VISIBLE);
            riskFactorsAdapter.update(riskFactors);

        });

        getViewModel().getAllTherapies().observe(this, therapies ->{
            if(therapies == null){
                // TODO: aggiungere msg di errore
                return;
            }

            binding.activityAddEditPatientRecyclerViewTherapies.setVisibility(View.VISIBLE);
            therapiesAdapter.update(therapies);
        });
        */
    }

    private ActivityAddEditPatientBinding binding;
    private AddEditPatientViewModel viewModel;
    private PatientEntity patientEntity;
    private List<FactorEntity> riskFactors;
    private RiskFactorsAdapter riskFactorsAdapter;
    // private List<TherapiesEntity> therapies;
    private TherapiesAdapter therapiesAdapter;

}

