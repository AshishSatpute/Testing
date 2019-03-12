package com.example.jobscheduler;

import android.content.ComponentName;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        scheduleJob();

    }


    public void scheduleJob() {
        ComponentName name = new ComponentName(getApplicationContext(), "");
    }
}
