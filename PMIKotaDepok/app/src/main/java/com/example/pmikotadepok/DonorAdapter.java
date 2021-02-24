package com.example.pmikotadepok;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmidepok.R;

import java.util.List;

public class DonorAdapter extends RecyclerView.Adapter<DonorAdapter.DonorViewHolder> {

    private List<Donors> donorsList;

    public DonorAdapter(HalamanUser halamanUser, List<Donors> donorsList) {
        this.donorsList = donorsList;
    }
    @Override
    public DonorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.donor, null);
        return new DonorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DonorViewHolder holder, int position) {
        Donors donor8 = donorsList.get(position);

        holder.texttanggaldonor.setText("Tanggal : " + donor8.getTgldonor());
        holder.texttempatdonor.setText("Tempat : " + donor8.getTempatdonor());

    }

    @Override
    public int getItemCount() {
        return donorsList.size();
    }

    class DonorViewHolder extends RecyclerView.ViewHolder {

        TextView texttanggaldonor, texttempatdonor;

        public DonorViewHolder(View itemView) {
            super(itemView);

            texttanggaldonor = itemView.findViewById(R.id.tanggaldonor);
            texttempatdonor = itemView.findViewById(R.id.tempatdonor);
        }
    }
}