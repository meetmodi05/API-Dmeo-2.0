package com.example.apidemo20;

import static androidx.constraintlayout.widget.Constraints.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.apidemo20.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<CommentModel> modelClassList;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvAPI.setHasFixedSize(false);
        binding.rvAPI.setLayoutManager(new LinearLayoutManager(this));

        binding.mBtn.setOnClickListener(view -> {
//            getCommentTest();
//            getComment();
//            getCommentByQuery();
//            createPost();
            post();
        });

    }

    public static RequestBody toRequestBody(String value) {
        RequestBody body = RequestBody.create(MediaType.parse("text/plain"), value);
        return body;
    }

    private void post() {

        String email = "demo08@xy.com";
        String pass = "demo08";
        String role = "student";
        String name = "miraj";
        String number = "12345678";


        HashMap<String, RequestBody> map = new HashMap<>();
        map.put("email_address", toRequestBody(email));
        map.put("password", toRequestBody(pass));
        map.put("role", toRequestBody(role));
        map.put("name", toRequestBody(name));
        map.put("contact_number", toRequestBody(number));

        Call<List<SignupModel>> response = RetrofitInstance.getRetrofit().apiMethod.register(map);
        response.enqueue(new Callback<List<SignupModel>>() {
            @Override
            public void onResponse(Call<List<SignupModel>> call, Response<List<SignupModel>> response) {

                Log.d("onResponse: ", String.valueOf(response.isSuccessful()));
                System.out.println("++++++++++++++" + response.code());
            }

            @Override
            public void onFailure(Call<List<SignupModel>> call, Throwable t) {
                Log.e("onFailure: ", t.getLocalizedMessage());
            }
        });
    }


    private void createPost() {
        CommentModel cm = new CommentModel(23, "New Text");
        RetrofitInstance.getRetrofit().apiMethod.createPost(cm).enqueue(new Callback<CommentModel>() {
            @Override
            public void onResponse(Call<CommentModel> call, Response<CommentModel> response) {
                CommentModel cm = response.body();
                if (response.isSuccessful()) {
                    assert cm != null;
                    binding.tvId.setText(cm.getText());
                }
            }

            @Override
            public void onFailure(Call<CommentModel> call, Throwable t) {
                Log.e("Error: ", "Something Wrong" + t.getLocalizedMessage());
            }
        });
    }

    private void getCommentByQuery() {
        RetrofitInstance.getRetrofit().apiMethod.getRecordQuery(50).enqueue(new Callback<ArrayList<CommentModel>>() {
            @Override
            public void onResponse(Call<ArrayList<CommentModel>> call, Response<ArrayList<CommentModel>> response) {
                modelClassList = response.body();
                assert modelClassList != null;
                for (CommentModel commentModel : modelClassList) {
                    System.out.println("========commentModel=======" + commentModel);
                    binding.rvAPI.setAdapter(new APIRVAdapter(MainActivity.this, modelClassList));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<CommentModel>> call, Throwable t) {

            }
        });
    }

    private void getCommentTest() {
        RetrofitInstance.getRetrofit().apiMethod.getRecord().enqueue(new Callback<ArrayList<CommentModel>>() {
            @Override
            public void onResponse(Call<ArrayList<CommentModel>> call, Response<ArrayList<CommentModel>> response) {
                modelClassList = response.body();
                assert modelClassList != null;
                for (CommentModel commentModel : modelClassList) {
                    System.out.println("========commentModel=======" + commentModel);
                    binding.rvAPI.setAdapter(new APIRVAdapter(MainActivity.this, modelClassList));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<CommentModel>> call, Throwable t) {

            }
        });
    }

    private void getComment() {
        RetrofitInstance.getRetrofit().apiMethod.getRecordByPath(15).enqueue(new Callback<ArrayList<CommentModel>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<CommentModel>> call, @NonNull Response<ArrayList<CommentModel>> response) {
                assert response.body() != null;
                Log.d("api", "onResponse====>>>>>" + response.body());
                modelClassList = response.body();
                System.out.println("+++++++onResponse++++++" + modelClassList);
                for (int i = 0; i < modelClassList.size(); i++) {
                    modelClassList.get(i).getName();
                    binding.rvAPI.setAdapter(new APIRVAdapter(MainActivity.this, modelClassList));
                }
                System.out.println("+++++++onResponse++++++" + modelClassList);

            }

            @Override
            public void onFailure(Call<ArrayList<CommentModel>> call, Throwable t) {
                Log.e("api", "onFailure" + t.getLocalizedMessage());
            }
        });
    }
}