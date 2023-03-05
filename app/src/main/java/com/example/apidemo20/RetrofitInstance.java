package com.example.apidemo20;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static RetrofitInstance retrofit;
    String apiUrl = "https://jsonplaceholder.typicode.com";
    APIMethod apiMethod;

    RetrofitInstance() {
        Retrofit retrofitInstance = new Retrofit.Builder().baseUrl(apiUrl).addConverterFactory(GsonConverterFactory.create()).build();
        apiMethod = retrofitInstance.create(APIMethod.class);
    }

    public static RetrofitInstance getRetrofit() {
        if (retrofit == null) {
            retrofit = new RetrofitInstance();
        }
        return retrofit;
    }
}
