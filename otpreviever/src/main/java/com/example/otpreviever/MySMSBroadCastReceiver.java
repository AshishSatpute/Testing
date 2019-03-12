package com.example.otpreviever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MySMSBroadCastReceiver extends BroadcastReceiver {


    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private static final String TAG = "SMSBroadcastReceiver";


    @Override
    public void onReceive(Context context, Intent intent) {
        // Get Bundle object contained in the SMS intent passed in
        Bundle bundle = intent.getExtras();
        SmsMessage[] smsm = null;
        String sms_str = "";

        if (bundle != null) {
            // Get the SMS message
            Object[] pdus = (Object[]) bundle.get("pdus");
            smsm = new SmsMessage[pdus.length];
            for (int i = 0; i < smsm.length; i++) {
                smsm[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);

                sms_str += "\r\nMessage: ";
                sms_str += smsm[i].getMessageBody().toString();
                sms_str += "\r\n";

                String Sender = smsm[i].getOriginatingAddress();
                //Check here sender is yours
                Intent smsIntent = new Intent("otp");
                smsIntent.putExtra("message", sms_str);

                LocalBroadcastManager.getInstance(context).sendBroadcast(smsIntent);

                Log.i("", "onReceive: " + sms_str);

            }


        }




        /*second*/


      /*  if (intent.getAction() == SMS_RECEIVED) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdus = (Object[])bundle.get("pdus");
                final SmsMessage[] messages = new SmsMessage[pdus.length];
                for (int i = 0; i < pdus.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                }
                if (messages.length > -1) {
                    Log.i(TAG, "Message recieved: " + messages[0].getMessageBody());
                }
            }
        }*/
    }
}
