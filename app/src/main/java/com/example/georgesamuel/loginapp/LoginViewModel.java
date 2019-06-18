package com.example.georgesamuel.loginapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel {

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<UserData> getCurrentUser(String email, String password){

        final MutableLiveData<UserData> currentUser = new MutableLiveData<>();

        ApiManager.getInstance().login(email, password, new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.body().getSuccess()){
                    currentUser.setValue(response.body().getData());
                }
                else{

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.v("Error", t.getMessage());
            }
        });

        return currentUser;
    }
}
