package com.example.webservices.Registration;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.webservices.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends Fragment {

    private TextView regUser;
    private EditText userName, userPass;
    private Button btn_login;

    OnLoginFormActivityListener loginFormActivityListener;

    public interface OnLoginFormActivityListener {
        public void performRegister();
        public void performLogin(String username);
    }

    public Login() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        userName = view.findViewById((R.id.ed_username));
        userPass = view.findViewById((R.id.ed_userpass));
        btn_login = view.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("checkLogin", "Login Button Clicked");
                performLogin();
            }
        });

        regUser = view.findViewById(R.id.tv_newUser);
        regUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginFormActivityListener.performRegister();
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;
        loginFormActivityListener = (OnLoginFormActivityListener) activity;
    }

    private void performLogin() {
        Log.i("Check","inside PerformLogin()");
        String UserName = userName.getText().toString();
        String UserPass = userPass.getText().toString();
//        Log.i("username",UserName);
//        Log.i("password",UserPass);
        System.out.println("username -> "+UserName+" && password -> "+UserPass);

        Call<User> call = MainActivity2.api.performLogin(UserName,UserPass);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
//                assert response.body() != null;
                if(response.body().getResponse().equals("ok")) {
                    MainActivity2.prefConfig.writeLoginStatus(true);
                    loginFormActivityListener.performLogin(response.body().getName());
                }
                else if (response.body().getResponse().equals("failed")) {
                    MainActivity2.prefConfig.displayToast("You are not authorised user !");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        Log.i("Check","exiting PerformLogin()");
    }
}