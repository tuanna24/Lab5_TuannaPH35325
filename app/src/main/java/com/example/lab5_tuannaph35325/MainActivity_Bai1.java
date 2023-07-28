package com.example.lab5_tuannaph35325;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.lab5_tuannaph35325.fragment.BookmarkFragment;
import com.example.lab5_tuannaph35325.fragment.HomeFragment;
import com.example.lab5_tuannaph35325.fragment.SettingFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity_Bai1 extends AppCompatActivity {
    DrawerLayout drawerLayout;

    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai1);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                MainActivity_Bai1.this,
                drawerLayout,
                toolbar,
                R.string.nav_open,
                R.string.nav_close
        );
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.home) {
                    Fragment fragment = new HomeFragment();
                    toolbar.setTitle("Trang chủ");

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frameLayout, fragment)
                            .commit();
                    drawerLayout.close();
                    return true;
                } else if (item.getItemId() == R.id.bookmark) {
                    toolbar.setTitle("Dấu trang");
                    Fragment fragment = new BookmarkFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frameLayout, fragment)
                            .commit();
                    drawerLayout.close();
                    return true;
                } else if (item.getItemId() == R.id.setting) {
                    toolbar.setTitle("Cài đặt");
                    Fragment fragment = new SettingFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frameLayout, fragment)
                            .commit();
                    drawerLayout.close();
                    return true;
                }
                return false;
            }
        });
    }
}