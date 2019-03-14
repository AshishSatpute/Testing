package com.example.new_sqlite;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etPass;
    private Button btn_show;
    private RecyclerView recyclerView;
    private Context context;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        init();

        listener();

    }

    private void listener() {
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTaskRunner runner = new AsyncTaskRunner();
                runner.execute();

                /*show list */
                showList();
            }
        });
    }

    private void clearText() {
        etName.setText("");
        etPass.setText("");
    }

    private void showList() {
        myAdapter = new MyAdapter(new AddToDataSource(context).showList(), context);
        recyclerView.setAdapter(myAdapter);
    }

    private void init() {
        etName = (EditText) findViewById(R.id.etName);
        etPass = (EditText) findViewById(R.id.etPass);
        btn_show = findViewById(R.id.btn_store);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            Module module = new Module();
            module.setName(etName.getText().toString());
            module.setPass(etPass.getText().toString());
            AddToDataSource addToDataSource = new AddToDataSource(context);
            addToDataSource.addData(module);

            clearText();

            return "Done";
        }

    }
}
