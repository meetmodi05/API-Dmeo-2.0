package com.example.apidemo20;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIMethod {
    @GET("/comments")
    Call<ArrayList<CommentModel>> getRecord();

    @GET("posts/{id}/comments")
    Call<ArrayList<CommentModel>> getRecordByPath(@Path("id") int postId);

    @GET("posts")
    Call<ArrayList<CommentModel>> getRecordQuery(@Query("id") int userId);

    @POST("posts")
    Call<CommentModel> createPost(@Body CommentModel post);

    @Multipart
    @POST("auth/register")
    Call<List<SignupModel>> register(@PartMap Map<String,  RequestBody > map);
}