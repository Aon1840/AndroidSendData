package com.example.aon_attapon.parka_for_user.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aon_attapon.parka_for_user.R;
import com.example.aon_attapon.parka_for_user.activity.MainActivity;
import com.example.aon_attapon.parka_for_user.adapter.UserListAdapter;
import com.example.aon_attapon.parka_for_user.dao.User;
import com.example.aon_attapon.parka_for_user.dao.UserCollection;
import com.example.aon_attapon.parka_for_user.manager.Contextor;
import com.example.aon_attapon.parka_for_user.manager.HttpManager;
import com.example.aon_attapon.parka_for_user.manager.UserListManager;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class AllUserFragment extends Fragment {

    ListView listViewUserList;
    List<User> users;
    ProgressBar progressBar;

    public AllUserFragment() {
        super();
    }

    public static AllUserFragment newInstance() {
        AllUserFragment fragment = new AllUserFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.all_user_fragement, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
//        btnTest = rootView.findViewById(R.id.btnTest);
//        btnTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new FancyAlertDialog.Builder(getActivity())
//                        .setTitle("Rate us if you like the app")
//                        .setBackgroundColor(Color.parseColor("#303F9F"))  //Don't pass R.color.colorvalue
//                        .setMessage("Do you really want to Exit ?")
//                        .setNegativeBtnText("Cancel")
//                        .setPositiveBtnBackground(Color.parseColor("#FF4081"))  //Don't pass R.color.colorvalue
//                        .setPositiveBtnText("Rate")
//                        .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  //Don't pass R.color.colorvalue
//                        .setAnimation(Animation.POP)
//                        .isCancellable(true)
//                        .setIcon(R.drawable.ic_star_border_black_24dp, Icon.Visible)
//                        .OnPositiveClicked(new FancyAlertDialogListener() {
//                            @Override
//                            public void OnClick() {
//                                Toast.makeText(getContext(),"Rate",Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .OnNegativeClicked(new FancyAlertDialogListener() {
//                            @Override
//                            public void OnClick() {
//                                Toast.makeText(getContext(),"Cancel",Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .build();
//            }
//        });

//        ^^^^^^^^^^^^^^^^^^^^^^ NOT Use now

        progressBar = rootView.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        listViewUserList = (ListView) rootView.findViewById(R.id.listView);

        Call<List<User>> call = HttpManager.getInstance()
                .getService()
                .getAllUser();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                progressBar.setVisibility(View.GONE);
                users = response.body();

                Collections.reverse(users);
                listViewUserList.setAdapter(new UserListAdapter(getContext(), users));
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }

    private void sortAscending(){
        List<List<User>> userList = Arrays.asList(users);
        Collections.reverse(userList);
    }
}
