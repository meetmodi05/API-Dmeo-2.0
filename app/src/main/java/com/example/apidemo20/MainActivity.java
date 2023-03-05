package com.example.apidemo20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.apidemo20.databinding.ActivityMainBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<ModelClass> modelClassList;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvAPI.setHasFixedSize(false);
        binding.rvAPI.setLayoutManager(new LinearLayoutManager(this));

        binding.mBtn.setOnClickListener(view -> {
            RetrofitInstance.getRetrofit().apiMethod.getRecord().enqueue(new Callback<ArrayList<ModelClass>>() {
                @Override
                public void onResponse(Call<ArrayList<ModelClass>> call, Response<ArrayList<ModelClass>> response) {
                    Log.d("api", "onResponse====>>>>>" + response.body().toString());
                    modelClassList = response.body();
                    System.out.println("+++++++onResponse++++++" + modelClassList);
                    for (int i = 0; i < modelClassList.size(); i++) {
//                    modelClassList.get(i).getTitle();
                        binding.rvAPI.setAdapter(new APIRVAdapter(MainActivity.this, modelClassList));
                    }
                    System.out.println("+++++++onResponse++++++" + modelClassList);

                }

                @Override
                public void onFailure(Call<ArrayList<ModelClass>> call, Throwable t) {
                    Log.e("api", "onFailure" + t.getLocalizedMessage());
                }
            });
        });

    }
}