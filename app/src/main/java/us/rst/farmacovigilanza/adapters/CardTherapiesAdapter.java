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
import us.rst.farmacovigilanza.databinding.CardTherapyBinding;


public class CardTherapiesAdapter extends RecyclerView.Adapter<CardTherapiesAdapter.ViewHolder> {

    private ArrayList<FactorEntity> factors;

    public CardTherapiesAdapter(ArrayList<FactorEntity> factors) {
        this.factors = factors;
    }

    public CardTherapiesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardTherapyBinding binding =  DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.card_factory, parent, false);

        return new ViewHolder(binding.getRoot());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private EditText name_edit_text;
        private EditText unit_edit_text;
        private EditText frequency_edit_text;
        private EditText start_date_edit_text;
        private EditText end_date_edit_text;
        private Button modify_button;

        public ViewHolder(View itemView) {
            super(itemView);

            CardTherapyBinding binding = DataBindingUtil.bind(itemView);
            name_edit_text = binding.cardTherapyInputTherapyName;
            unit_edit_text = binding.cardTherapyInputTherapyUnit;
            frequency_edit_text = binding.cardTherapyInputTherapyFrequency;
            start_date_edit_text = binding.cardTherapyInputTherapyStartDate;
            end_date_edit_text = binding.cardTherapyInputTherapyEndDate;
            modify_button = binding.cardTherapyBtnModifyTherapy;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //final FactorEntity factor = factors.get(position);

        holder.name_edit_text.setText("");
        holder.unit_edit_text.setText("");
        holder.frequency_edit_text.setText("");
        holder.start_date_edit_text.setText("");
        holder.end_date_edit_text.setText("");
        holder.modify_button.setOnClickListener(v -> {
            // TODO: Start add/modify therapy
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