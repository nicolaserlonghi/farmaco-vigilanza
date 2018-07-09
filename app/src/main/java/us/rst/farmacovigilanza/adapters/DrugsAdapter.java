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

    public DrugsAdapter(List<String> drugs) {
        this.drugs = drugs;
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

        public void set(String medicine) {
            binding.itemDrugsName.setText(medicine);
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
}