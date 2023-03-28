package com.example.apidemo20;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static RetrofitInstance retrofit;
    String apiUrl = "https://jsonplaceholder.typicode.com";
    String apiUrl2 = "https://g2a.8e7.myftpupload.com/wp-json/";
    APIMethod apiMethod;

    RetrofitInstance() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofitInstance = new Retrofit.Builder().baseUrl(apiUrl2).addConverterFactory(GsonConverterFactory.create()).client(client).build();
        apiMethod = retrofitInstance.create(APIMethod.class);
    }

    public static RetrofitInstance getRetrofit() {
        if (retrofit == null) {
            retrofit = new RetrofitInstance();
        }
        return retrofit;
    }
}
