package us.rst.farmacovigilanza.views;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import us.rst.farmacovigilanza.FarmacoVigilanzaApp;
import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.adapters.ReportsAdapter;
import us.rst.farmacovigilanza.databinding.FragmentReportsPharmacologistBinding;
import us.rst.farmacovigilanza.helpers.SimpleDividerItemDecoration;
import us.rst.farmacovigilanza.viewmodels.ReportViewModel;

public class ReportsPharmacologistFragment extends Fragment {
    private ReportViewModel reportViewModel;
    private FragmentReportsPharmacologistBinding binding;
    private boolean isFiltered = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reports_pharmacologist, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ReportViewModel.Factory factory = new ReportViewModel.Factory(getActivity().getApplication(),
                ((FarmacoVigilanzaApp)getActivity().getApplication()).getDataRepository().getReportsRepository());
        reportViewModel = ViewModelProviders.of(this, factory).get(ReportViewModel.class);

        binding.recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext().getResources().getColor(R.color.divider), 3));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        reportViewModel.getReports().observe(this, reports -> {
            if(reports == null)
                return;

            binding.recyclerView.setAdapter(new ReportsAdapter(reports));
        });
    }

    public void filterByGravity() {
        if (isFiltered) {
            ((ReportsAdapter)binding.recyclerView.getAdapter()).resetFilters();
        }
        else {
            ((ReportsAdapter)binding.recyclerView.getAdapter()).filterByGravity();
        }
        isFiltered = !isFiltered;
    }
}
