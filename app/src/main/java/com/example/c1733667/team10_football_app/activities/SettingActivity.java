package com.example.c1733667.team10_football_app.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import com.example.c1733667.team10_football_app.R;

import java.util.Map;

public class SettingActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout navDrawer;
    private NavigationView navView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //event handling thing majig
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences pref1 = getSharedPreferences("High contrast", 0);
        Map map = pref1.getAll();
        for (Object key:map.keySet()){
            Log.d("preference", (String) key);
            if (map.containsValue(true)){
                setTheme(R.style.HighContrastTheme);
                setContentView(R.layout.activity_setting_outer);
            }else{
                setTheme(R.style.AppTheme);
                setContentView(R.layout.activity_setting_outer);
            }
        }
//        String changeTheme = getIntent().getStringExtra("CHECK_BOX");
//        if (changeTheme != null){
//            setTheme(R.style.HighContrastTheme);
//            setContentView(R.layout.activity_setting_outer);
//        }else
//        {
//            setTheme(R.style.AppTheme);
//            setContentView(R.layout.activity_setting_outer);
//        }
//        super.onCreate(savedInstanceState);
//        if (changeTheme.equals(true)){
//            setTheme(R.style.HighContrastTheme);
//        }
//            setTheme(R.style.AppTheme);
//        }


        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        this.navDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, navDrawer, toolbar, R.string.open, R.string.close);
        navDrawer.addDrawerListener(toggle);
        toggle.syncState();
        this.navView = findViewById(R.id.nav_view);
        this.navView.setNavigationItemSelectedListener(this);
        CheckBox checkBox = findViewById(R.id.highContrast);
        checkBox.setChecked(getSharedPreferences("High contrast", Context.MODE_PRIVATE).getBoolean(String.valueOf(R.id.highContrast), false));
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.highContrast:
                SharedPreferences sharedPreference = getSharedPreferences("High contrast", Context.MODE_PRIVATE);
                sharedPreference.edit().putBoolean(String.valueOf(R.id.highContrast), checked).commit();
//                if (checked) {
                    Intent intent = new Intent(getBaseContext(), SettingActivity.class);
                    intent.putExtra("CHECK_BOX", checked);
                    Log.d("CheckBox", String.valueOf(checked));
                    finish();
                    startActivity(intent);
//                }

        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
