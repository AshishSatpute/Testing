package com.example.broadcastrec;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intent = new IntentFilter();
        intent.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(new MyReciever(), intent);
    }
}
