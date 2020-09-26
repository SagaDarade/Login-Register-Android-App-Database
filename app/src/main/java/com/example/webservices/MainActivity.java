package com.example.webservices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.webservices.APIs.Api;
import com.example.webservices.APIs.Conn;
import com.example.webservices.APIs.PojoList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItem;
    private List<PojoList> pojoLists;

    Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        api = Conn.getApiCon().create(Api.class);

        recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        recyclerView2 = findViewById(R.id.recyclerView2);
//        recyclerView2.setHasFixedSize(true);
//        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
//
//        recyclerView3 = findViewById(R.id.recyclerView3);
//        recyclerView3.setHasFixedSize(true);
//        recyclerView3.setLayoutManager(new LinearLayoutManager(this, HORIZONTAL, false));

//        pojoLists = new ArrayList<>();

//        for(int i = 0; i< pojoLists.size(); i++){
//            PojoList iList = new PojoList((i+1),
//                    "Title "+(i+1),"Subtitle "+(i+1),"Subtitle "+(i+1)
//            );
//            pojoLists.add(iList);
//        }

        Call<List<PojoList>> call = api.getProjects();
        call.enqueue(new Callback<List<PojoList>>() {

            @Override
            public void onResponse(Call<List<PojoList>> call, Response<List<PojoList>> response) {
                pojoLists = response.body();
//                System.out.println("Response Body: " + response.body().toString());
                ListAdapter listAdapter = new ListAdapter(pojoLists, MainActivity.this);
                recyclerView.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<List<PojoList>> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        "Unable to fetch...!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        adapter = new ListAdapter(pojoLists, this);
        recyclerView.setAdapter(adapter);
//        recyclerView2.setAdapter(adapter);
//        recyclerView3.setAdapter(adapter);
    }
}