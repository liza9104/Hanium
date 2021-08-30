package com.cookandroid.hanium;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<RecommendData> arrayList;
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tv1, tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.title);
            tv2 = itemView.findViewById(R.id.desc);
        }
    }
    public RecyclerViewAdapter(ArrayList<RecommendData> arrayList){
        this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        RecyclerViewAdapter.ViewHolder viewHolder = new RecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.tv1.setText(arrayList.get(position).getId());
        holder.tv2.setText(arrayList.get(position).getSex());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
