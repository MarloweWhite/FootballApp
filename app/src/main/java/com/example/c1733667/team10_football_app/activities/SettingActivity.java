package com.example.c1733667.team10_football_app.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
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
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.c1733667.team10_football_app.R;
import com.example.c1733667.team10_football_app.classpack.Navigation;
import com.example.c1733667.team10_football_app.classpack.ThemeSetting;

import java.util.Map;

import fragments.HelpFragment;
import fragments.MainFragment;
import fragments.MapsFragment;
import fragments.ScoreFragment;
import fragments.SettingFragment;
import fragments.StadiumFragment;

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


        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        this.navDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, navDrawer, toolbar, R.string.open, R.string.close);
        navDrawer.addDrawerListener(toggle);
        toggle.syncState();
        this.navView = findViewById(R.id.nav_view);
        this.navView.setNavigationItemSelectedListener(this);



        NavigationView navigationView = navView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Navigation navigation = new Navigation(item, SettingActivity.this);
                navigation.activityNavigation(getApplicationContext());
                return false;
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.stad:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new StadiumFragment())
                        .commit();
                break;

            case R.id.scores:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new ScoreFragment())
                        .commit();
                break;


            case R.id.maps:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new MapsFragment())
                        .commit();
                break;


            case R.id.exit:
                finish();
                break;

            case R.id.home:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new MainFragment())
                        .commit();
                break;

            case R.id.achievements:
                //   getSupportFragmentManager().beginTransaction()
                //         .replace(R.id.main_container, new AchievementFragment())
                //       .commit();
                break;

            case R.id.settings:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new SettingFragment())
                        .commit();
                break;
            case R.id.help:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new HelpFragment())
                        .commit();
                break;

        }

        navDrawer.closeDrawer(GravityCompat.START);

        return true;
    }

    public void onCheckboxClicked(View view) {
    }
}


