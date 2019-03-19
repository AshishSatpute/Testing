package com.example.pagination;

import android.app.Application;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AppController extends Application {

    private RequestQueue requestQueue;
    private static AppController myInstance;
    private static Context mCtx;

    public AppController() {

    }

    private AppController(Context context) {
        mCtx = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized AppController getInstance(Context context) {
        if (myInstance == null) {
            myInstance = new AppController(context);
        }
        return myInstance;
    }

    public <T> void addToRequest(Request<T> request) {
        requestQueue.add(request);
    }

}
