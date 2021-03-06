package com.example.sqlitedb;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText nameEditText, passwordEditText;
    private String TAG = MainActivity.class.getSimpleName();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        Log.i(TAG, "onCreate: ");
        init();
        listaner();
    }

    private void listaner() {
        Log.i(TAG, "listaner: ");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: ");
                addToDb();
            }
        });
    }

    private void addToDb() {
        Log.i(TAG, "addToDb: ");
        AddDataModel addDataModel = new AddDataModel();
        addDataModel.setName(nameEditText.getText().toString());
        addDataModel.setPassword(passwordEditText.getText().toString());

        AddToDataSource addToDataSource = new AddToDataSource(context);
        addToDataSource.addData(addDataModel);
    }

    private void init() {
        Log.i(TAG, "init: ");
        nameEditText = findViewById(R.id.txtView1);
        passwordEditText = findViewById(R.id.txtView2);
        button = findViewById(R.id.btn);
    }
}
