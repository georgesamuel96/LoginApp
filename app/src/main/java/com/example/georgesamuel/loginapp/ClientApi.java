package com.example.georgesamuel.loginapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ClientApi {

    @FormUrlEncoded
    @POST("/api/login")
    Call<LoginResponse> login(@Field("email") String email, @Field("password") String password);
}
