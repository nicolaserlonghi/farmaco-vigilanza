package us.rst.farmacovigilanza.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.database.entity.FactorEntity;
import us.rst.farmacovigilanza.databinding.CardFactoryBinding;


public class CardFactorsAdapter extends RecyclerView.Adapter<CardFactorsAdapter.ViewHolder> {

    private ArrayList<FactorEntity> factors;

    public CardFactorsAdapter(ArrayList<FactorEntity> factors) {
        this.factors = factors;
    }

    public CardFactorsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardFactoryBinding binding =  DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.card_factory, parent, false);

        return new ViewHolder(binding.getRoot());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private EditText name_edit_text;
        private EditText description_edit_text;
        private Button modify_button;

        public ViewHolder(View itemView) {
            super(itemView);

            CardFactoryBinding binding = DataBindingUtil.bind(itemView);
            name_edit_text = binding.cardFactoryInputFactorName;
            description_edit_text = binding.cardFactoryInputFactorDescription;
            modify_button = binding.cardFactoryBtnModifyFactor;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final FactorEntity factor = factors.get(position);

        holder.name_edit_text.setText(factor.getName());
        holder.description_edit_text.setText(factor.getDescription());
        holder.modify_button.setOnClickListener(v -> {
            // TODO: Start add/modify factor
        });
    }

    @Override
    public int getItemCount() {
        return factors.size();
    }

    public void update(ArrayList<FactorEntity> factors){
        this.factors = factors;
        notifyDataSetChanged();
    }
}