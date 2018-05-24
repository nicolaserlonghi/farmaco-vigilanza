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
import us.rst.farmacovigilanza.models.Report;
import us.rst.farmacovigilanza.databinding.RowReportsPharmacologistAdapterBinding;


public class ReportsPharmacologistAdapter extends RecyclerView.Adapter<ReportsPharmacologistAdapter.ViewHolder> {

    private ArrayList<Report> reports;

    public ReportsPharmacologistAdapter(ArrayList<Report> reports) {
        this.reports = reports;
    }

    public ReportsPharmacologistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RowReportsPharmacologistAdapterBinding binding =  DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_reports_pharmacologist_adapter, parent, false);

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_reports_pharmacologist_adapter, parent, false);

        return new ViewHolder(binding.getRoot());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout report_layout;
        private TextView name_report_text_view;
        private TextView reaction_date_text_view;

        public ViewHolder(View itemView) {
            super(itemView);

            RowReportsPharmacologistAdapterBinding binding = DataBindingUtil.bind(itemView);
            report_layout = binding.report;
            name_report_text_view = binding.textViewNameReport;
            reaction_date_text_view = binding.textViewReactionDate;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Report report = reports.get(position);

        holder.name_report_text_view.setText(report.getDescription());
        holder.reaction_date_text_view.setText(report.getReactionDate().toString());
        holder.report_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Start reports detail activity
            }
        });
    }

    @Override
    public int getItemCount() {
        return reports.size();
    }

    public void updateList(ArrayList<Report> reports){
        this.reports = reports;
        notifyDataSetChanged();
    }
}
