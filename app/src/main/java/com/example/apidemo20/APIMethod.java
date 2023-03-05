package com.example.apidemo20;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIMethod {
    @GET("/todos")
    Call<ArrayList<ModelClass>> getRecord();
}
