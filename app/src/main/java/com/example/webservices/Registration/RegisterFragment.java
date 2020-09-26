package com.example.webservices.Registration;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.webservices.R;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterFragment extends Fragment {

    private EditText name, number, email, password;
    private Button btnReg;
    public RegisterFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        name = view.findViewById(R.id.tv_username);
        number = view.findViewById(R.id.tv_usernum);
        email = view.findViewById(R.id.tv_useremail);
        password = view.findViewById(R.id.tv_userpass);


        btnReg = view.findViewById(R.id.btn_register);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().equals("")){
                    name.setError("Name required");
                } else if(number.getText().toString().equals("")){
                    number.setError("Contact required");
                } else if(email.getText().toString().equals("")){
                    email.setError("Password required");
                } else if(password.getText().toString().equals("")){
                    password.setError("Email required");
                }

                else {
                    performRegistration();
                }
            }
        });
        return view;
    }

    public void performRegistration() {
        String uName = name.getText().toString();
        String uNum = number.getText().toString();
        String uEmail = email.getText().toString();
        String uPass = password.getText().toString();

        Call<User> call = MainActivity2.api.performRegistration(uName,uNum,uEmail,uPass);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.body().getResponse().equals("okk")) {
                    MainActivity2.prefConfig.displayToast("Registration Successful.");
                }
                else if(response.body().getResponse().equals("exists")) {
                    MainActivity2.prefConfig.displayToast("User already existed by contact or emailID.");
                }
                else if(response.body().getResponse().equals("error")) {
                    MainActivity2.prefConfig.displayToast("Error.");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}