package com.example.c1733667.team10_football_app.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.animation.ObjectAnimator;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.c1733667.team10_football_app.R;
import com.example.c1733667.team10_football_app.classpack.ScoreSystem;
import com.example.c1733667.team10_football_app.classpack.Navigation;
import com.example.c1733667.team10_football_app.classpack.ThemeSetting;

import java.util.Map;

import fragments.AchievementFragment;
import fragments.HelpFragment;
import fragments.MainFragment;
import fragments.MapsFragment;
import fragments.ScoreFragment;
import fragments.SettingFragment;
import fragments.StadiumFragment;


public class Score extends AppCompatActivity implements AdapterView.OnClickListener, NavigationView.OnNavigationItemSelectedListener{

    private Button btnShare;
    private int totalStadiumsVisited ;
    private Intent shareIntent = new Intent(Intent.ACTION_SEND);
    ProgressBar mprogressBar;
    ProgressBar mprogressBar2;
    ProgressBar mprogressBar3;
    ProgressBar mprogressBar4;
    ProgressBar mprogressBar5;
    DrawerLayout navDrawer;
    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        SharedPreferences setting = getSharedPreferences("High contrast", 0);
        ThemeSetting scoreSetting = new ThemeSetting(setting, Score.this);
        scoreSetting.setHighContrast(R.layout.activity_scoring_system_outer);


        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        this.navDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,navDrawer,toolbar,R.string.open,R.string.close);
        navDrawer.addDrawerListener(toggle);
        toggle.syncState();
        this.navView = findViewById(R.id.nav_view);
        this.navView.setNavigationItemSelectedListener(this);

        NavigationView navigationView = navView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Navigation navigation = new Navigation(item, Score.this);
                navigation.activityNavigation(getApplicationContext());
                return false;
            }
        });
    }




    @Override
    public void onClick(View v) {

    }
    public void shareButtonListener() {
        btnShare = findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareContent = ("I have visited "+ totalStadiumsVisited  +" out of the 92 football stadiums in the UK!\nHow many have you visited?");
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareContent);

                startActivity(Intent.createChooser(shareIntent, "Share via:"));
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
                   getSupportFragmentManager().beginTransaction()
                         .replace(R.id.main_container, new AchievementFragment())
                       .commit();
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
}
