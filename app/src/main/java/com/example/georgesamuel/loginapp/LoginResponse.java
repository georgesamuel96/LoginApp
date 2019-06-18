package com.example.georgesamuel.loginapp;

public class LoginResponse {

    private Boolean success;
    private String message;
    private UserData data;

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public UserData getData() {
        return data;
    }
}
