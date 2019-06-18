package com.example.georgesamuel.loginapp;

import android.app.Application;

public class MainApplication extends Application {

    public static ApiManager apiManager;

    @Override
    public void onCreate() {
        super.onCreate();

        apiManager = ApiManager.getInstance();
    }

}
