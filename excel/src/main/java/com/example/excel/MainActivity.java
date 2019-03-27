package com.example.excel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (char item: vowels) {
            Log.i("TAG", "onCreate: "+item);
        }


    }
}
