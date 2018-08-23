package com.example.aon_attapon.parka_for_user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.aon_attapon.parka_for_user.R;
import com.example.aon_attapon.parka_for_user.dao.User;
import com.example.aon_attapon.parka_for_user.dao.UserCollection;
import com.example.aon_attapon.parka_for_user.view.UserListItem;

import java.util.List;

public class UserListAdapter extends BaseAdapter {

    private Context context;
    private List<User> users;

    public UserListAdapter(Context context, List<User> users){
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        UserListItem userListItem;
//
//        User user = (User) users.get(position);
//
//        if (convertView != null)
//            userListItem = (UserListItem) convertView;
//        else
//            userListItem = new UserListItem(parent.getContext());

//        userListItem.setTvName(user.getName());
//        userListItem.setTvSurname(user.getSurname());
//        userListItem.setTvEmail(user.getEmail());
//        userListItem.setTvTel(user.getTel());


//        return userListItem;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.list_item_user, parent, false);


        User user = users.get(position);

        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        tvName.setText(user.getName());

        TextView tvSurname = (TextView) convertView.findViewById(R.id.tvSurname);
        tvSurname.setText(user.getSurname());

        TextView tvEmail = (TextView) convertView.findViewById(R.id.tvEmail);
        tvEmail.setText(user.getEmail());

        TextView tvTel = (TextView) convertView.findViewById(R.id.tvTel);
        tvTel.setText(user.getTel());

        return convertView;
    }
}
    /// Not Use

//    public void setDao(UserCollection dao) {
//        this.dao = dao;
//    }
//
//    @Override
//    public int getCount() {
//        if (dao == null)
//            return 1;
//
//        return dao.getUser().size() + 1;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return dao.getUser().get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (position == getCount() - 1){
//            ProgressBar item;
//            if (convertView != null)
//                item = (ProgressBar) convertView;
//            else
//                item = new ProgressBar(parent.getContext());
//
//            return item;
//        }
//
//        UserListItem item;
//        if (convertView != null)
//            item = (UserListItem) convertView;
//        else
//            item = new UserListItem(parent.getContext());
//
//        User dao = (User) getItem(position);
//        item.setTvName(dao.getName());
//        item.setTvSurname(dao.getSurname());
//        item.setTvEmail(dao.getEmail());
//        item.setTvTel(dao.getTel());
//
//        return item;
//    }

