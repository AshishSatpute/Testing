package com.example.new_sqlite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

    private ArrayList<Module> list = new ArrayList<>();
    private Context context;

    public MyAdapter(ArrayList<Module> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart, viewGroup, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.Holder holder, int i) {
        final Module module = list.get(i);
        holder.name.setText(module.getName());
        holder.pass.setText(module.getPass());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, module.getName() + " : " + module.getPass(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView name, pass;
        View view;

        public Holder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            name = view.findViewById(R.id.name);
            pass = view.findViewById(R.id.pass);
        }
    }
}
