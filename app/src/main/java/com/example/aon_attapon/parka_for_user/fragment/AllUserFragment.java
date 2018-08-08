package com.example.aon_attapon.parka_for_user.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.aon_attapon.parka_for_user.R;
import com.example.aon_attapon.parka_for_user.dao.User;
import com.example.aon_attapon.parka_for_user.manager.HttpManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class AllUserFragment extends Fragment {

    TextView tvResult;

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
        tvResult = (TextView) rootView.findViewById(R.id.tvResult);
        Call<User> call = HttpManager.getInstance()
                .getService()
                .getAllUser();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("Method sendData","-------------------- pass this method 2 --------------------");
                if(response.isSuccessful()){
                    Log.d("Method sendData","-------------------- pass this method 2.2 --------------------");
                    showResponse(response.body().toString());
                    Log.i("TAG","post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("Method sendData","-------------------- pass this method 3 --------------------");
//                Log.d("Call","--------------", (Throwable) call);
                Log.d("Throwable","--------------",t);
                Log.e("TAG", "Unable to submit post to API.");

            }
        });
    }

    public void showResponse(String response) {
        if(tvResult.getVisibility() == View.GONE) {
            tvResult.setVisibility(View.VISIBLE);
        }
        tvResult.setText(response);
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
}
