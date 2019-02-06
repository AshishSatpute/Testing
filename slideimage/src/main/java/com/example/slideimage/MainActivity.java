package com.example.slideimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    static ImageView iv;
    Adapter adapter;
    ArrayList<Model> mModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.iv);
        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplication(), LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        adapter = new Adapter(this, getData());
        rv.setAdapter(adapter);

    }

    private ArrayList<Model> getData() {
        mModels.clear();
        Model model = new Model(R.drawable.ic_launcher_background);
        mModels.add(model);

        model = new Model(R.drawable.ic_android_black_24dp);
        mModels.add(model);


        model = new Model(R.drawable.ic_launcher_background);
        mModels.add(model);


        model = new Model(R.drawable.ic_android_black_24dp);
        mModels.add(model);

        model = new Model(R.drawable.ic_launcher_background);
        mModels.add(model);


        model = new Model(R.drawable.ic_android_black_24dp);
        mModels.add(model);

        return mModels;
    }

    public static void setImage(int imageView) {
        iv.setImageResource(imageView);
    }

}
