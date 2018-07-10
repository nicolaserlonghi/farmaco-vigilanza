package us.rst.farmacovigilanza.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.databinding.ItemDrugsBinding;

public class DrugsAdapter extends RecyclerView.Adapter<DrugsAdapter.ViewHolder> {
    private List<String> drugs;
    private DrugActionHandler handler;

    public DrugsAdapter(List<String> drugs, DrugActionHandler handler) {
        this.drugs = drugs;
        this.handler = handler;
    }

    public DrugsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemDrugsBinding binding =  DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_drugs, parent, false);

        return new ViewHolder(binding.getRoot());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemDrugsBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);

            binding = DataBindingUtil.bind(itemView);
        }

        public void set(String drug) {
            binding.itemDrugsName.setText(drug);
            binding.itemDrugsEnableCheck.setOnClickListener(click -> handler.checkDrug(drug));
            binding.itemDrugsRemove.setOnClickListener(click -> handler.removeDrug(drug));
            binding.itemDrugsEnableMonitor.setOnClickListener(click -> handler.monitorDrug(drug));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.set(drugs.get(position));
    }

    @Override
    public int getItemCount() {
        return drugs.size();
    }

    public interface DrugActionHandler {
        void removeDrug(String drug);
        void checkDrug(String drug);
        void monitorDrug(String drug);
    }
}