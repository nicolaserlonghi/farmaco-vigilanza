package us.rst.farmacovigilanza.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.database.entity.TherapyEntity;
import us.rst.farmacovigilanza.databinding.ItemRiskFactorsTherapiesBinding;

public class TherapiesAdapter extends RecyclerView.Adapter<TherapiesAdapter.ViewHolder> {
    private List<TherapyEntity> therapies;
    private OnDeleteClick listener;

    public TherapiesAdapter(List<TherapyEntity> therapies, OnDeleteClick listener) {
        this.therapies = therapies;
        this.listener = listener;
    }

    public TherapiesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRiskFactorsTherapiesBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_risk_factors_therapies, parent, false);

        return new ViewHolder(binding.getRoot());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemRiskFactorsTherapiesBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);

            binding = DataBindingUtil.bind(itemView);
        }

        public void set(TherapyEntity therapyEntity) {
            binding.itemRiskFactorsTextViewName.setText(therapyEntity.getMedicine());
            binding.itemRiskFactorsButtonRemove.setOnClickListener(v -> listener.onTherapyDelete(therapyEntity.getMedicine()));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.set(therapies.get(position));
    }

    @Override
    public int getItemCount() {
        return therapies.size();
    }

    public interface OnDeleteClick {
        void onTherapyDelete(String name);
    }
}
