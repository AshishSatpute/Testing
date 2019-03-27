package com.example.paginationrecycler;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Adapter adapter;
    ArrayList<Model> list = new ArrayList<>();
    int page = 1;
    private RequestQueue requestQueue;
    public static final String URL = "http://postalpincode.in/api/postoffice/goa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        adapter = new Adapter(list, getApplicationContext());
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                getData();
            }
        });

    }

    private void getData() {

        //add to requestQueue
        requestQueue.add(getDataFromServer(page));

        //increment page number
        page++;

        //remove any loading progress here
    }

    private JsonArrayRequest getDataFromServer(final int page) {
        //good practice to put a loading progress here

        //Json request begins
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL + String.valueOf(page),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //this is called when a response is gotten from the server


                        //after getting the data, I need to parse it the view
                        //  parseData(response);
                        Log.i("URL", URL + String.valueOf(page));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    //TODO
                    Toast.makeText(MainActivity.this, "time out", Toast.LENGTH_SHORT).show();
                } else if (error instanceof AuthFailureError) {
                    //TODO
                } else if (error instanceof ServerError) {
                    //TODO
                    Toast.makeText(MainActivity.this, "server error", Toast.LENGTH_SHORT).show();
                } else if (error instanceof NetworkError) {
                    //TODO
                    Toast.makeText(MainActivity.this, "network error", Toast.LENGTH_SHORT).show();
                } else if (error instanceof ParseError) {
                    //TODO
                    Toast.makeText(MainActivity.this, "parse error", Toast.LENGTH_SHORT).show();
                }
                /* progressBar.setVisibility(View.GONE); */
                //If an error occurs that means end of the list has reached

                Toast.makeText(MainActivity.this, "No More Result Available", Toast.LENGTH_SHORT).show();
            }
        });

        //some retrypoilicy for bad network
        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(10000, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        //return array
        return jsonArrayRequest;
    }


}
