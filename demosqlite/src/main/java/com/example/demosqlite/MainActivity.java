package com.example.demosqlite;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText nameEditText, passwordEditText;
    private String TAG = MainActivity.class.getCanonicalName();
    private Context context;

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
                addToDb();
            }
        });
    }

    private void addToDb() {
        AddDataModel addDataModel = new AddDataModel();
        addDataModel.setName(nameEditText.getText().toString());
        addDataModel.setPassword(passwordEditText.getText().toString());

        AddToDataSource addToDataSource = new AddToDataSource(context);
        addToDataSource.addData(addDataModel);

        show();

    }

    private void show() {
        AddToDataSource addToDataSource = new AddToDataSource(context);
        Log.i(TAG, "show: " + addToDataSource.getAllNotes());
    }

    private void init() {
        nameEditText = findViewById(R.id.txtView1);
        passwordEditText = findViewById(R.id.txtView2);
        button = findViewById(R.id.btn);
    }

}
