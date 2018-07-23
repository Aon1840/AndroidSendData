package com.example.aon_attapon.parka_for_user.activity;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aon_attapon.parka_for_user.R;
import com.example.aon_attapon.parka_for_user.adapter.ViewPagerAdapter;
import com.example.aon_attapon.parka_for_user.fragment.AddNewUserFragment;
import com.example.aon_attapon.parka_for_user.fragment.AllUserFragment;
import com.example.aon_attapon.parka_for_user.fragment.DeleteUserFragment;
import com.example.aon_attapon.parka_for_user.fragment.EditUserFragment;
import com.example.aon_attapon.parka_for_user.fragment.UserDetailFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        // Add fragements
        adapter.AddFragment(new AllUserFragment(),"All User");
        adapter.AddFragment(new UserDetailFragment(),"User Detail");
        adapter.AddFragment(new AddNewUserFragment(),"Add User");
//        adapter.AddFragment(new EditUserFragment(), "Edit User");
        adapter.AddFragment(new DeleteUserFragment(), "Delete User");

        // Adapter setting
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
