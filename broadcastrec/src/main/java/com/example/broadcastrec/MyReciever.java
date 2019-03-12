package com.example.broadcastrec;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import javax.security.auth.login.LoginException;

public class MyReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show();

    }
}
