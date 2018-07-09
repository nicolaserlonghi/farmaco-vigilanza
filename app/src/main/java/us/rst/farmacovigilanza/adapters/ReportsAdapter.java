package us.rst.farmacovigilanza.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import us.rst.farmacovigilanza.R;
import us.rst.farmacovigilanza.database.entity.ReportTherapyEntity;
import us.rst.farmacovigilanza.databinding.ItemReportsBinding;

public class ReportsAdapter extends RecyclerView.Adapter<ReportsAdapter.ViewHolder> {

    private List<ReportTherapyEntity> reports;

    public ReportsAdapter(List<ReportTherapyEntity> reports) {
        this.reports = reports;
    }

    public ReportsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemReportsBinding binding =  DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_reports, parent, false);

        return new ViewHolder(binding.getRoot());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemReportsBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);

            binding = DataBindingUtil.bind(itemView);
        }

        public void set(ReportTherapyEntity entity) {
            DateFormat format = new SimpleDateFormat("dd/mm/YYYY");

            binding.itemReportsTitle.setText(entity.getReport().getAdverseReactionName() + " con rischio " + entity.getReport().getLevelOfGravity());
            binding.itemReportsDate.setText("Data segnalazione: " + format.format(entity.getReport().getReactionDate()) + "\n" +
                    "Data reazione: " + format.format(entity.getReport().getReactionDate()));
            binding.itemReportsPatient.setText("Paziente: " + entity.getReport().getPatientFiscalCode());
            binding.itemReportsTherapy.setText("Farmaco: " + entity.getTherapyEntity().getMedicine());
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.set(reports.get(position));
    }

    @Override
    public int getItemCount() {
        return reports.size();
    }
}
