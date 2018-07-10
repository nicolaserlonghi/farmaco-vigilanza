package us.rst.farmacovigilanza.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.pixplicity.easyprefs.library.Prefs;

import us.rst.farmacovigilanza.FarmacoVigilanzaApp;
import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.adapters.ReportsAdapter;
import us.rst.farmacovigilanza.databinding.ActivityReportsChronologyBinding;
import us.rst.farmacovigilanza.helpers.SimpleDividerItemDecoration;
import us.rst.farmacovigilanza.viewmodels.BaseViewModel;
import us.rst.farmacovigilanza.viewmodels.ReportViewModel;

public class ReportsChronologyActivity extends BaseActivity{
    private ActivityReportsChronologyBinding binding;
    private ReportViewModel viewModel;

    @Override protected int getLayoutId() {
        return R.layout.activity_reports_chronology;
    }

    @Override protected void setToolbar() {
        setSupportActionBar((Toolbar)binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override protected ReportViewModel getViewModel() {
        if (viewModel == null) {
            ReportViewModel.Factory factory = new ReportViewModel.Factory(getApplication(),
                    ((FarmacoVigilanzaApp)getApplication()).getDataRepository().getReportsRepository());
            viewModel = ViewModelProviders.of(this, factory).get(ReportViewModel.class);
        }

        return viewModel;
    }

    @Override protected void setBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding.recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this.getColor(R.color.divider), 3));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getViewModel().getReportsByDoctor(Prefs.getString("userId", "")).observe(this, reports -> {
            if (reports == null) {
                return;
            }

            binding.recyclerView.setAdapter(new ReportsAdapter(reports));
        });
    }
}
