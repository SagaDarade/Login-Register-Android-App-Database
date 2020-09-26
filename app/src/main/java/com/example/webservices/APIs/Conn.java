package com.example.webservices.APIs;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Conn {
    //public static final String BASE_URL="http://192.168.43.245/revise2020/";
    public static final String BASE_URL="http://192.168.42.66/revise2020/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiCon(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        System.out.println("Retrofit returns: "+retrofit);
        return retrofit;
    }
}
