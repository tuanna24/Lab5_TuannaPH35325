package com.example.lab5_tuannaph35325;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.lab5_tuannaph35325.fragment.BookmarkFragment;
import com.example.lab5_tuannaph35325.fragment.HomeFragment;
import com.example.lab5_tuannaph35325.fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity_bai3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai3);
        BottomNavigationView navigationView = findViewById(R.id.BottonNav);
        navigationView.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            if (item.getItemId() == R.id.nav_home) {
                fragment = new HomeFragment();
            } else if (item.getItemId() == R.id.nav_map) {
                fragment = new BookmarkFragment();
            } else if (item.getItemId() == R.id.nav_setting) {
                fragment = new SettingFragment();
            }
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framelayoutbai3, fragment)
                    .commit();
            return true;
        });
    }
}