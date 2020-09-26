package com.example.webservices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.webservices.APIs.PojoList;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<PojoList> list;
    private Context context;

    public ListAdapter(List<PojoList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PojoList listItem = list.get(position);
        holder.txv1.setText(listItem.getpName());
        holder.txv2.setText(listItem.getpDuration());
        holder.txv3.setText(listItem.getSubmit());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txv1, txv2, txv3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txv1 = itemView.findViewById(R.id.tv1);
            txv2 = itemView.findViewById(R.id.tv2);
            txv3 = itemView.findViewById(R.id.tv3);
        }
    }
}
