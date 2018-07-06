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
import java.util.ArrayList;
import us.rst.farmacovigilanza.FarmacoVigilanzaApp;
import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.adapters.ReportsPharmacologistAdapter;
import us.rst.farmacovigilanza.databinding.FragmentReportsPharmacologistBinding;
import us.rst.farmacovigilanza.helpers.SimpleDividerItemDecoration;
import us.rst.farmacovigilanza.viewmodels.ReportViewModel;

public class ReportsPharmacologistFragment extends Fragment {

    private ReportViewModel reportViewModel;
    private FragmentReportsPharmacologistBinding binding;

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


        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext().getResources().getColor(R.color.divider), 3));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ReportsPharmacologistAdapter(new ArrayList<>()));

        /*reportViewModel.getReports().observe(this, reports -> {
            if(reports == null)
                return;

            ((ReportsPharmacologistAdapter)recyclerView.getAdapter()).update(new ArrayList<>(reports));
        });*/
    }
}
