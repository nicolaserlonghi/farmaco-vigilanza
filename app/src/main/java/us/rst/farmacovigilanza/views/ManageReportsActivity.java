package us.rst.farmacovigilanza.views;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import us.rst.farmacovigilanza.FarmacoVigilanzaApp;
import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.databinding.ActivityManageReportsBinding;
import us.rst.farmacovigilanza.helpers.KeyboardHelper;
import us.rst.farmacovigilanza.helpers.SnackBarHelper;
import us.rst.farmacovigilanza.models.FiscalCode;
import us.rst.farmacovigilanza.viewmodels.ManageReportViewModel;
import us.rst.farmacovigilanza.viewmodels.BaseViewModel;

// dovrebbe essere solo "ADD", non può modificare una segnalazione una volta effetuata e inviata al sistema di gestione delle segnalazini

public class ManageReportsActivity extends BaseActivity implements View.OnClickListener {

    private ActivityManageReportsBinding binding;
    private ManageReportViewModel viewModel;
    private PatientEntity patient;

    @Override protected int getLayoutId() {
        return R.layout.activity_manage_reports;
    }

    @Override protected void setToolbar() {
        setSupportActionBar((Toolbar)binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close_icon);
        // Title
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    @Override protected BaseViewModel getViewModel() {
        if (viewModel == null) {
            ManageReportViewModel.Factory factory = new ManageReportViewModel.Factory(getApplication(),
                    ((FarmacoVigilanzaApp)getApplication()).getDataRepository().getReportsRepository());
            viewModel = ViewModelProviders.of(this, factory).get(ManageReportViewModel.class);
        }

        return viewModel;
    }

    @Override protected void setBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    // Menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        binding.activityManageReportsBtnAddCf.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_manage_reports_btn_add_cf:
                // Hide keyboard and disable button
                binding.activityManageReportsBtnAddCf.setEnabled(false);
                KeyboardHelper.hideKeyboard(ManageReportsActivity.this);
                String cf = binding.activityManageReportsInputCf.getText().toString();
                if(cf.isEmpty()) {
                    SnackBarHelper.showShort(v, getResources().getString(R.string.error_empty_field));
                    binding.activityManageReportsBtnAddCf.setEnabled(false);
                    return;
                }
                viewModel.getPatient(new FiscalCode(cf)).observe(this, patient -> {
                    if(patient == null) {
                        return;
                    }

                    this.patient = patient;
                    // TODO: VIsualizzo ed aggiungo i dati nella seconda CardView
                });
                break;
        }
    }
}
