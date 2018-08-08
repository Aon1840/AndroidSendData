package com.example.aon_attapon.parka_for_user.manager.http;

import com.example.aon_attapon.parka_for_user.dao.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("addNewUser/")
    Call<User> createUser(@Field("username") String username,
                          @Field("password") String password,
                          @Field("name") String name,
                          @Field("surname") String surname,
                          @Field("tel") String tel,
                          @Field("email") String email);

    @GET("users")
    Call<User> getAllUser();
}
