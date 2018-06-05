package us.rst.farmacovigilanza.adapters;


import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.databinding.RowDrugsPharmacologistAdapterBinding;
import us.rst.farmacovigilanza.models.Drug;

public class DrugsPharmacologistAdapter extends RecyclerView.Adapter<DrugsPharmacologistAdapter.ViewHolder> {

    private ArrayList<Drug> drugs;

    public DrugsPharmacologistAdapter(ArrayList<Drug> drugs) {
        this.drugs = drugs;
    }

    public DrugsPharmacologistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RowDrugsPharmacologistAdapterBinding binding =  DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_drugs_pharmacologist_adapter, parent, false);

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_drugs_pharmacologist_adapter, parent, false);

        return new ViewHolder(binding.getRoot());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout drug_layout;
        private TextView name_drug_text_view;

        public ViewHolder(View itemView) {
            super(itemView);

            RowDrugsPharmacologistAdapterBinding binding = DataBindingUtil.bind(itemView);
            drug_layout = binding.drug;
            name_drug_text_view = binding.textViewNameDrug;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Drug drug = drugs.get(position);

        holder.name_drug_text_view.setText(drug.getName());
        holder.drug_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Start drug detail activity
            }
        });
    }

    @Override
    public int getItemCount() {
        return drugs.size();
    }

    public void update(ArrayList<Drug> drugs){
        this.drugs = drugs;
        notifyDataSetChanged();
    }
}