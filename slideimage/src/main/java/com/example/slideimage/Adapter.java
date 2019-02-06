package com.example.slideimage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyAdapter> {
    Context context;
    ArrayList<Model> models = new ArrayList<>();
    MainActivity mainActivity;

    public Adapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new MyAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Adapter.MyAdapter myAdapter, int i) {
        final Model list = models.get(i);
        myAdapter.iv.setImageResource(list.getPic());
        myAdapter.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Chick", Toast.LENGTH_SHORT).show();
                mainActivity.setImage(list.getPic());
            }
        });

    }


    @Override
    public int getItemCount() {
        return models.size();
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        ImageView iv;

        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv1);
        }
    }
}
