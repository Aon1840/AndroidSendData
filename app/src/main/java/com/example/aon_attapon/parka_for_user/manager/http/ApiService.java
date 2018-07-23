package com.example.aon_attapon.parka_for_user.manager.http;

import com.example.aon_attapon.parka_for_user.dao.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface ApiService {

    @POST("addNewUser")
    Call<User> addUser();
}
