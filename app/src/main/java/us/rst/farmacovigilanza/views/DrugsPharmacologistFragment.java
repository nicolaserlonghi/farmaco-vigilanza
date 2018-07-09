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
import us.rst.farmacovigilanza.adapters.DrugsAdapter;
import us.rst.farmacovigilanza.helpers.SimpleDividerItemDecoration;
import us.rst.farmacovigilanza.viewmodels.DrugsViewModel;
import us.rst.farmacovigilanza.databinding.FragmentDrugsPharmacologistBinding;


public class DrugsPharmacologistFragment extends Fragment {

    private DrugsViewModel drugsViewModel;
    private FragmentDrugsPharmacologistBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_drugs_pharmacologist, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DrugsViewModel.Factory factory = new DrugsViewModel.Factory(getActivity().getApplication(),
                ((FarmacoVigilanzaApp)getActivity().getApplication()).getDataRepository().getDrugsRepository());
        drugsViewModel = ViewModelProviders.of(this, factory).get(DrugsViewModel.class);

        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext().getResources().getColor(R.color.divider), 3));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        drugsViewModel.getDrugs().observe(this, drugs -> {
            if(drugs == null)
                return;

            recyclerView.setAdapter(new DrugsAdapter(drugs));
        });
    }
}