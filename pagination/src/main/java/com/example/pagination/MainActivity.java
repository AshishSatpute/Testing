package com.example.pagination;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    public static final String URL = "https://picsum.photos/300/200/?random";
    ArrayList<Model> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getApplicationContext(), 2, LinearLayoutManager.HORIZONTAL, false);*/

        getAttendanceList();

    }

    private void getData() {
        for (int i = 0; i < 900; i++) {
            Log.i("i", "getData: " + i);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void getAttendanceList() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        JsonObjectRequest jsonRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        for (int i = 0; i < 500; i++) {
                            Model model = new Model(URL);
                            list.add(model);
                            Log.i("i", "onResponse: " + model.getFilename());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("error", "onErrorResponse: " + error);

            }
        }) {


            Map<String, String> createBasicAuthHeader(String username, String password) {
                Map<String, String> headerMap = new HashMap<String, String>();

                String credentials = username + ":" + password;
                String encodedCredentials = Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                headerMap.put("Authorization", "Basic " + encodedCredentials);
                headerMap.put("Content-Type", "application/x-www-form-urlencoded");
                /*  headerMap.put("x-api-key", "cw00ggcsw4co0g804gcggwo088g4kokgk88sso4s");*/
                return headerMap;
            }

        };
        AppController.getInstance(this).addToRequest(jsonRequest);
    }

}
