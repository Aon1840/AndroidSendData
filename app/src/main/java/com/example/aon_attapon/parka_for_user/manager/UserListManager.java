package com.example.aon_attapon.parka_for_user.manager;

import android.content.Context;

import com.example.aon_attapon.parka_for_user.dao.UserCollection;

public class UserListManager {

    private Context mContext;
    private UserCollection dao;

    public UserListManager(){
        mContext = Contextor.getInstance().getContext();
    }

    public UserCollection getDao() {
        return dao;
    }

    public void setDao(UserCollection dao) {
        this.dao = dao;
    }
}
