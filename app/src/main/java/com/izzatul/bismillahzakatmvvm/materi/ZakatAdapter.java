package com.izzatul.bismillahzakatmvvm.materi;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.izzatul.bismillahzakatmvvm.R;

import java.util.List;

/**
 * Created by Izzatul on 12/19/2017.
 */

public class ZakatAdapter extends RecyclerView.Adapter<ZakatAdapter.ZakatViewHolder> {

    List<Zakat> zakatList;

    public static class ZakatViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView nama_zakat;
        TextView detail;

        ZakatViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            nama_zakat = itemView.findViewById(R.id.nama_zakat);
            detail = itemView.findViewById(R.id.detail);
        }
   }

    ZakatAdapter(List<Zakat> zakats){
        this.zakatList = zakats;
    }

    @Override
    public int getItemCount() {
        return zakatList.size();
    }

    @Override
    public ZakatViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_zakat, viewGroup, false);
        ZakatViewHolder zvh = new ZakatViewHolder(v);
        return zvh;
    }

    // TODO tambahkan nama zakat sesuai recyclerview, contohnya ada di RVAdapter
    @Override
    public void onBindViewHolder(ZakatViewHolder holder, int position) {
        holder.nama_zakat.setText(zakatList.get(position).nama);
        holder.detail.setText(zakatList.get(position).detail);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
