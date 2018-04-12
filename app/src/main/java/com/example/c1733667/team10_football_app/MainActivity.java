package com.example.c1733667.team10_football_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.design.widget.NavigationView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Map;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Button btnStadium;
    private Button btnScore;
    private Button btnMap;
    private Button btnAchievement;
    private Intent intent;
    private AdView mAdView;
    private DrawerLayout navDrawer;
    private NavigationView navView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
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
        setContentView(R.layout.activity_main_outer);
        stadiumButtonListener();
        scoreButtonListener();
        mapbuttonListener();
        achievementButtonListener();

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        this.navDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,navDrawer,toolbar,R.string.open,R.string.close);
        navDrawer.addDrawerListener(toggle);
        toggle.syncState();
        this.navView = findViewById(R.id.nav_view);
        this.navView.setNavigationItemSelectedListener(this);
        MobileAds.initialize(this, "ca-app-pub-2747796691426534~5751833757");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void stadiumButtonListener() {
        btnStadium = findViewById(R.id.btnStadium);
        btnStadium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), StadiumActivity.class);
                startActivity(intent);
            }
        });
    }

    public void scoreButtonListener() {
        btnScore = findViewById(R.id.btnScore);
        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), Score.class);
                startActivity(intent);
            }
        });
    }

    public void mapbuttonListener() {
        btnMap = findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });
    }

    public void achievementButtonListener(){
        btnAchievement = findViewById(R.id.btnAchievement);
        btnAchievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),Achievement.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d("Item", String.valueOf(item));
        int id = item.getItemId();
        Log.d("id", String.valueOf(id));
        navDrawer.closeDrawers();
        switch (id){
            case R.id.stadium_nav:
                intent = new Intent(getApplicationContext(),StadiumActivity.class);
                startActivity(intent);
                break;
            case R.id.score_nav:
                intent = new Intent(getApplicationContext(),Score.class);
                startActivity(intent);
                break;
            case R.id.map_nav:
                intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.exit_nav:
                System.exit(0);
                break;
        }
        return true;
    }
}
