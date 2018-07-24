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
public class AddNewUserFragment extends Fragment {

    EditText edtUsername, edtPassword, edtName, edtSurname, edtTel, edtEmail;
    Button btnSend;
    TextView tvResult;

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

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                String name = edtName.getText().toString().trim();
                String surname = edtSurname.getText().toString().trim();
                String tel = edtTel.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();

                Log.d("Method sendData","-------------------- pass this method --------------------");
                if(!TextUtils.isEmpty(username) 
                        && !TextUtils.isEmpty(password)
                        && !TextUtils.isEmpty(name)
                        && !TextUtils.isEmpty(surname)
                        && !TextUtils.isEmpty(tel)
                        && !TextUtils.isEmpty(email)){
                    Log.d("Method sendData","-------------------- pass before sendData --------------------");
                    sendData(username, password, name, surname, tel, email);
                    Log.d("Method sendData","-------------------- pass After sendData --------------------");
                }
            }
        });

    }

    private void sendData(String username, String password, String name, String surname, String tel, String email) {
        Log.d("Method sendData","-------------------- pass this method 1 --------------------");
        Call<User> call = HttpManager.getInstance()
                .getService()
                .addUser();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("Method sendData","-------------------- pass this method 2 --------------------");
                if(response.isSuccessful()){
                    showResponse(response.body().toString());
                    Log.i("TAG","post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("Method sendData","-------------------- pass this method 3 --------------------");
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
