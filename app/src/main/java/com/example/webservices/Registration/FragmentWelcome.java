package com.example.webservices.Registration;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.webservices.R;


public class FragmentWelcome extends Fragment {
    private TextView tvName;
    private Button logout;

    OnLogoutListener logoutListener;

    public interface OnLogoutListener {
        public void logoutPerformer();
    }

    public FragmentWelcome() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
            tvName = view.findViewById(R.id.tv_user);
            tvName.setText(MainActivity2.prefConfig.readName());
            logout = view.findViewById(R.id.btn_logout);
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    logoutListener.logoutPerformer();
                }
            });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        logoutListener = (OnLogoutListener) activity;
    }
}