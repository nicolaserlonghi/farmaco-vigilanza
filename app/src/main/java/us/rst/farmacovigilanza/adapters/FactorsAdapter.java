package us.rst.farmacovigilanza.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.database.entity.PatientFactorEntity;
import us.rst.farmacovigilanza.databinding.ItemRiskFactorsTherapiesBinding;

public class FactorsAdapter extends RecyclerView.Adapter<FactorsAdapter.ViewHolder> {
    private List<PatientFactorEntity> factors;
    private OnDeleteClick listener;

    public FactorsAdapter(List<PatientFactorEntity> factors, OnDeleteClick listener) {
        this.factors = factors;
        this.listener = listener;
    }

    public FactorsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRiskFactorsTherapiesBinding binding =  DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_risk_factors_therapies, parent, false);

        return new ViewHolder(binding.getRoot());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemRiskFactorsTherapiesBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);

            binding = DataBindingUtil.bind(itemView);
        }

        public void set(PatientFactorEntity patientFactorEntity) {
            binding.itemRiskFactorsTextViewName.setText(patientFactorEntity.getFactorName() + " - " + patientFactorEntity.getLevelOfRisk());
            binding.itemRiskFactorsButtonRemove.setOnClickListener(v -> listener.onFactorDelete(patientFactorEntity.getFactorName()));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.set(factors.get(position));
    }

    @Override
    public int getItemCount() {
        return factors.size();
    }

    public interface OnDeleteClick {
        void onFactorDelete(String name);
    }
}