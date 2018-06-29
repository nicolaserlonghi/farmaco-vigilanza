package us.rst.farmacovigilanza.views;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.databinding.ActivityAddEditReportsBinding;
import us.rst.farmacovigilanza.viewmodels.AddEditReportViewModel;
import us.rst.farmacovigilanza.viewmodels.BaseViewModel;

// dovrebbe essere solo "ADD", non può modificare una segnalazione una volta effetuata e inviata al sistema di gestione delle segnalazini

public class AddEditReportsActivity extends BaseActivity {

    private ActivityAddEditReportsBinding binding;
    private AddEditReportViewModel viewModel;

    @Override protected int getLayoutId() {
        return R.layout.activity_add_edit_reports;
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
            AddEditReportViewModel.Factory factory = new AddEditReportViewModel.Factory(getApplication());
            viewModel = ViewModelProviders.of(this, factory).get(AddEditReportViewModel.class);
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
}
