package com.example.georgesamuel.loginapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static ClientApi service;
    private static ApiManager apiManager;

    private ApiManager(){
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://yalladealz.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(ClientApi.class);
    }

    public static ApiManager getInstance(){
        if(apiManager == null){
            apiManager = new ApiManager();
        }
        return apiManager;
    }

    public void login(String email, String password, Callback<LoginResponse> callback){
        Call<LoginResponse> response = service.login(email, password);
        response.enqueue(callback);
    }
}
