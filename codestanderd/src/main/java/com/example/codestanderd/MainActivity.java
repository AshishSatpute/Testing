package com.example.codestanderd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tbn2 = findViewById(R.id.btn2);
        Button btn1 = findViewById(R.id.btn1);


        tbn2.setOnClickListener(new MyButtonClick(tbn2));

        btn1.setOnClickListener(new MyButtonClick(btn1));

    }


    private class MyButtonClick implements View.OnClickListener {
        MyButtonClick(Button button) {
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
        }
    }
}
