package com.cookandroid.hanium;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<ChatData> list;
    String myNickname;
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nickname, chatMessage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nickname = itemView.findViewById(R.id.chatNickname);
            chatMessage = itemView.findViewById(R.id.chatMessage);
        }
    }
    RecyclerAdapter(ArrayList<ChatData> list, String myNickname){
        this.list = list;
        this.myNickname =  myNickname;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        RecyclerAdapter.ViewHolder viewHolder = new RecyclerAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.nickname.setText(list.get(position).getNickname());
            viewHolder.chatMessage.setText(list.get(position).getMessage());
            if(list.get(position).getNickname().equals(myNickname)){
                viewHolder.nickname.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.weight = 1.0f;
                params.gravity = Gravity.RIGHT;
                viewHolder.chatMessage.setLayoutParams(params);
            }else{
                viewHolder.nickname.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                viewHolder.chatMessage.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
            }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void addChat(ChatData data){
        list.add(data);
        notifyItemInserted(list.size()-1);
    }

}
