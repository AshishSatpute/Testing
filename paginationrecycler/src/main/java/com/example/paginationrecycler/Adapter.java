package com.example.paginationrecycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    ArrayList<Model> models = new ArrayList<>();
    Context context;

    public Adapter(ArrayList<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.items, viewGroup);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        final Model model = models.get(i);
        holder.text1.setText(model.getName());
        holder.text2.setText(model.getPINCode());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView text1, text2;

        public Holder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
        }
    }
}
