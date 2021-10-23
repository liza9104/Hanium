package com.cookandroid.hanium;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<RecommendData> arrayList;
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv1, tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.itemTitle);
            tv2 = itemView.findViewById(R.id.itemNickname);
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
        holder.tv1.setText(arrayList.get(position).getTitle());
        holder.tv2.setText(arrayList.get(position).getDesc());
        int i = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), RecommendDetail.class);
                intent.putExtra("id",arrayList.get(i).getId());
                ContextCompat.startActivity(holder.itemView.getContext(), intent, null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
