package com.example.aon_attapon.parka_for_user;

import android.app.Application;

import com.example.aon_attapon.parka_for_user.manager.HttpManager;

public class MainApplication extends Application {

    public static HttpManager instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = HttpManager.getInstance();
    }
}
