package us.rst.farmacovigilanza.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.database.entity.FactorEntity;
import us.rst.farmacovigilanza.databinding.ItemRiskFactorsBinding;

public class RiskFactorsAdapter extends RecyclerView.Adapter<RiskFactorsAdapter.ViewHolder> {

    private List<FactorEntity> factors;

    public RiskFactorsAdapter() {
        factors = new ArrayList<>();
    }

    public RiskFactorsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRiskFactorsBinding binding =  DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_risk_factors, parent, false);

        return new ViewHolder(binding.getRoot());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name_text_view;
        private TextView description_text_view;
        private TextView risk_level_text_view;
        private Button remove_button;

        public ViewHolder(View itemView) {
            super(itemView);

            ItemRiskFactorsBinding binding = DataBindingUtil.bind(itemView);
            name_text_view = binding.itemRiskFactorsTextViewName;
            description_text_view = binding.itemRiskFactorsTextViewDescription;
            risk_level_text_view = binding.itemRiskFactorsTextViewRiskLevel;
            remove_button = binding.itemRiskFactorsButtonRemove;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final FactorEntity factor = factors.get(position);

        holder.name_text_view.setText("");
        holder.description_text_view.setText("");
        holder.risk_level_text_view.setText("");
        holder.remove_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return factors.size();
    }

    public void update(List<FactorEntity> factors){
        this.factors = factors;
        notifyDataSetChanged();
    }
}