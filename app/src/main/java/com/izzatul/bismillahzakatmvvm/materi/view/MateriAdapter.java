package com.izzatul.bismillahzakatmvvm.materi.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import com.izzatul.bismillahzakatmvvm.materi.model.Materi;

/**
 * Created by Izzatul on 1/16/2018.
 */

public class MateriAdapter extends RecyclerView.Adapter<MateriAdapter.MateriViewHolder>{

    public class MateriViewHolder extends RecyclerView.ViewHolder{
        public MateriViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public MateriViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MateriViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
