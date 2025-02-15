package com.example.mobileshop.Utils;


import android.app.DownloadManager;

import com.example.mobileshop.Entity.Order;
import com.example.mobileshop.Entity.User;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {

   // @POST("/users")
    //Call<JsonObject> loginUser(@Body User user);
    @POST("/users")
    Call<JsonObject> registerUser(@Body User user);

    @GET("/mobiles")
    Call<JsonObject> getAllMobiles();

    @GET("/users/{id}")
    Call<JsonObject> getUserById(@Path("id") int id);

    @POST("/users/login")
    Call<JsonObject> loginUser(@Body User user);

    @GET("/orders/user/{id}")
    Call<JsonObject> getAllOrders(@Path("id") int uid);

    @POST("/orders")
    Call<JsonObject> placeOrder(@Body Order order);
}

