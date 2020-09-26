package com.example.webservices.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.webservices.APIs.Api;
import com.example.webservices.APIs.Conn;
import com.example.webservices.R;

public class MainActivity2 extends AppCompatActivity implements Login.OnLoginFormActivityListener,
        FragmentWelcome.OnLogoutListener {

    public static PrefConfig prefConfig;
    public static Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        prefConfig = new PrefConfig(this);
        api = Conn.getApiCon().create(Api.class);

        if(findViewById(R.id.fragment_container) != null) {
            if(savedInstanceState != null) {
                return;
            }

            if(prefConfig.readLoginStatus()) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new FragmentWelcome()).commit();
            }
            else {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new Login()).commit();
            }
        }
    }

    @Override
    public void performRegister() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new RegisterFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void performLogin(String username) {
        prefConfig.writeName(username);
        getSupportFragmentManager()
                .beginTransaction().replace(R.id.fragment_container, new FragmentWelcome())
                .commit();
    }

    @Override
    public void logoutPerformer() {
        prefConfig.writeLoginStatus(false);
        prefConfig.writeName("");
        getSupportFragmentManager()
                .beginTransaction().replace(R.id.fragment_container, new Login())
                .commit();
    }
}