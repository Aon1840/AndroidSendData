package com.example.aon_attapon.parka_for_user.manager;

import android.content.Context;

import com.example.aon_attapon.parka_for_user.dao.User;
import com.example.aon_attapon.parka_for_user.manager.Contextor;
import com.example.aon_attapon.parka_for_user.manager.http.ApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class HttpManager {

    private static HttpManager instance;

    public static HttpManager getInstance() {
        if (instance == null)
            instance = new HttpManager();
        return instance;
    }

    private Context mContext;
    private static ApiService service;

    private HttpManager() {
        mContext = Contextor.getInstance().getContext();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://applicationserver.parka028.me/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(ApiService.class);
    }

    public ApiService getService() {
        return service;
    }

//    public void addUser(User user, Callback<User> callback){
//        Call<User> userCall = service.addUser(user);
//        userCall.enqueue(callback);
//    }
}
