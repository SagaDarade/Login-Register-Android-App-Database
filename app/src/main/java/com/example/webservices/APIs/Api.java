package com.example.webservices.APIs;

import com.example.webservices.Registration.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("register.php")
    Call<User> performRegistration(@Query("uname") String Name, @Query("unumber") String Number, @Query("useremail") String Email, @Query("userpass") String Password);

    @GET("user_login.php")
    Call<User>  performLogin(@Query("useremail") String Email, @Query("userpass") String Password);

    @GET("api.php")
    Call<List<PojoList>> getProjects();
}
