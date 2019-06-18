package com.example.georgesamuel.loginapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.email)
    EditText emailText;
    @BindView(R.id.password)
    EditText passwordText;
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

    }

    private Boolean isEmailValid(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @OnClick(R.id.login)
    public void loginClick(View view) {
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if(isEmailValid(email)){

            viewModel.getCurrentUser(email, password).observe(LoginActivity.this, new Observer<UserData>() {
                @Override
                public void onChanged(@Nullable UserData userData) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("firstName", userData.getFirst_name());
                    intent.putExtra("lastName", userData.getLast_name());
                    startActivity(intent);
                    finish();
                }
            });

        }
        else{
            emailText.setError("invalid email");
        }
    }
}
