package com.example.bank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AD extends RecyclerView.Adapter<AD.ADViewHolder> {

    Context context;
    ArrayList<Integer> list;

    public AD(Context context, ArrayList<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ADViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ADViewHolder(LayoutInflater.from(context).inflate(R.layout.singel_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ADViewHolder holder, int position) {
        holder.tv.setText("Ending Balance Of Year " + (position + 1) + " : " + list.get(position) + "");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ADViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public ADViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
