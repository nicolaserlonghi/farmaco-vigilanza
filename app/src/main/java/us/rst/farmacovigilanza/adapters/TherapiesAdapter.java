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
import us.rst.farmacovigilanza.databinding.ItemTherapiesBinding;

public class TherapiesAdapter extends RecyclerView.Adapter<TherapiesAdapter.ViewHolder> {

    private List<FactorEntity> factors;

    public TherapiesAdapter() {
        this.factors = new ArrayList<>();
    }

    public TherapiesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemTherapiesBinding binding =  DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_risk_factors, parent, false);

        return new ViewHolder(binding.getRoot());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView drug_text_view;
        private TextView frequency_text_view;
        private TextView start_date_text_view;
        private TextView end_date_text_view;
        private Button remove_button;

        public ViewHolder(View itemView) {
            super(itemView);

            ItemTherapiesBinding binding = DataBindingUtil.bind(itemView);
            drug_text_view = binding.itemTherapiesTextViewDrug;
            frequency_text_view = binding.itemTherapiesTextViewDailyFrequency;
            start_date_text_view = binding.itemTherapiesTextViewStartDate;
            end_date_text_view = binding.itemTherapiesTextViewEndDate;
            remove_button = binding.itemTherapiesButtonRemove;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final FactorEntity factor = factors.get(position);

        holder.drug_text_view.setText("");
        holder.frequency_text_view.setText("");
        holder.start_date_text_view.setText("");
        holder.end_date_text_view.setText("");
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