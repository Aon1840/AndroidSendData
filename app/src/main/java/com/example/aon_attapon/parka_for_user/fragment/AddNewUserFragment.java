package com.example.aon_attapon.parka_for_user.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aon_attapon.parka_for_user.MainApplication;
import com.example.aon_attapon.parka_for_user.R;
import com.example.aon_attapon.parka_for_user.dao.User;
import com.example.aon_attapon.parka_for_user.manager.HttpManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class AddNewUserFragment extends Fragment {

    EditText edtUsername, edtPassword, edtName, edtSurname, edtTel, edtEmail;
    Button btnSend;
    TextView tvResult;
    ProgressBar progressBar;

    public AddNewUserFragment() {
        super();
    }

    public static AddNewUserFragment newInstance() {
        AddNewUserFragment fragment = new AddNewUserFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.add_user_fragment, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        edtUsername = (EditText) rootView.findViewById(R.id.edtUsername);
        edtPassword = (EditText) rootView.findViewById(R.id.edtPassword);
        edtName = (EditText) rootView.findViewById(R.id.edtName);
        edtSurname = (EditText) rootView.findViewById(R.id.edtSurname);
        edtTel = (EditText) rootView.findViewById(R.id.edtTel);
        edtEmail = (EditText) rootView.findViewById(R.id.edtEmail);
        btnSend = (Button) rootView.findViewById(R.id.btnSend);
        tvResult = (TextView) rootView.findViewById(R.id.tvResult);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progress_bar);

        progressBar.setVisibility(View.GONE);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                Call<User> call = HttpManager.getInstance()
                        .getService()
                        .createUser(edtUsername.getText().toString(),
                                edtPassword.getText().toString(),
                                edtName.getText().toString(),
                                edtSurname.getText().toString(),
                                edtTel.getText().toString(),
                                edtEmail.getText().toString());
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        progressBar.setVisibility(View.GONE);
                        User responseUser = response.body();
                        if (response.isSuccessful() && responseUser != null){
                            tvResult.setText("ID: "+responseUser.getUserId()+
                                    "\nUsername: "+responseUser.getUsername()+
                                    "\nPassword: "+responseUser.getPassword()+
                                    "\nName: "+responseUser.getName()+
                                    "\nSurname: "+responseUser.getSurname()+
                                    "\nTel: "+responseUser.getTel()+
                                    "\nEmail "+responseUser.getEmail()+
                                    "\nRegister Date: "+responseUser.getRegisterDate());
                        } else {
                            tvResult.setText("Response is "+String.valueOf(response.code()));
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        tvResult.setText("Error is "+t.getMessage());
                    }
                });
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
}
