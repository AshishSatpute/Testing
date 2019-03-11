package com.example.dth;

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

    EditText e1, e2;
    Button button;
    Context context;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        init();

        listener();


    }

    private void listener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AsyncTaskRunner runner = new AsyncTaskRunner();

                runner.execute();


            }
        });

    }

    private void showData() {
        // rv.setAdapter(new MyAdapter(new OperationSource(context).showList(), context));


    }

    private void init() {
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        button = findViewById(R.id.b1);
        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(manager);
    }


    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            Model model = new Model();
            model.setOne(e1.getText().toString());
            model.setTwo(e2.getText().toString());

            OperationSource operationSource = new OperationSource(context);
            operationSource.DoOperation(model);

            showData();
            return "Done";
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }


    }
}
