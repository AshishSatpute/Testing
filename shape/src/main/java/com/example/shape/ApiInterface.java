package com.example.shape;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/api/users?page=2")
    Call<Movie> getMovies(@Body() String apiKey);


}
