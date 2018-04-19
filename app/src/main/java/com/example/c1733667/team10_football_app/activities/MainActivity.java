package com.example.c1733667.team10_football_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.support.design.widget.NavigationView;

import com.example.c1733667.team10_football_app.R;
import com.example.c1733667.team10_football_app.classpack.ButtonClass;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Button btnStadium;
    private Button btnScore;
    private Button btnMap;
    private Button btnAchievement;
    private Button btnHelp;
    private AdView mAdView;
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
        setContentView(R.layout.activity_main_outer);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        this.navDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, navDrawer, toolbar, R.string.open, R.string.close);
        navDrawer.addDrawerListener(toggle);
        toggle.syncState();
        this.navView = findViewById(R.id.nav_view);
        this.navView.setNavigationItemSelectedListener(this);
        MobileAds.initialize(this, "ca-app-pub-2747796691426534~5751833757");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        NavigationView navigationView = navView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.stad:
                        Intent intent = new Intent(MainActivity.this, StadiumActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.scores:
                        Intent intent1 = new Intent(MainActivity.this, Score.class);
                        startActivity(intent1);
                        break;


                    case R.id.maps:
                        Intent intent2 = new Intent(MainActivity.this, MapsActivity.class);
                        startActivity(intent2);
                        break;


                    case R.id.exit:
                        System.exit(0);


                    case R.id.home:
                        Intent intent3 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.achievements:
                        Intent intent4 = new Intent(MainActivity.this, Achievement.class);
                        startActivity(intent4);
                        break;

                    case R.id.help:
                        Intent intent5 = new Intent(MainActivity.this, HelpActivity.class);
                        startActivity(intent5);
                        break;
                }
                return false;
            }
        });
        ButtonClass stadiumButton = new ButtonClass("Stadium Button");
        stadiumButton.stadiumButtonListener( btnStadium = findViewById(R.id.btnStadium),this);

        ButtonClass helpButton = new ButtonClass("Help Button");
        helpButton.helpButtonListener(btnHelp =findViewById(R.id.btnHelp),this);

        ButtonClass scoreButton = new ButtonClass("Score Button");
        scoreButton.scoreButtonListener(btnScore = findViewById(R.id.btnScore),this);

        ButtonClass mapButton = new ButtonClass("Map Button");
        mapButton.mapbuttonListener(btnMap = findViewById(R.id.btnMap),this);

        ButtonClass achievementButton = new ButtonClass("AchievementLogic Button");
        achievementButton.achievementButtonListener(btnAchievement = findViewById(R.id.btnAchievement),this);
}


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

}
