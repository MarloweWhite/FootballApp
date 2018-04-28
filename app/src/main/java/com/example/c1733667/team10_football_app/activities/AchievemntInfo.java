package com.example.c1733667.team10_football_app.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
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
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c1733667.team10_football_app.R;
import com.example.c1733667.team10_football_app.classpack.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import fragments.HelpFragment;
import fragments.MainFragment;
import fragments.MapsFragment;
import fragments.ScoreFragment;
import fragments.SettingFragment;
import fragments.StadiumFragment;

public class AchievemntInfo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private TextView achievementInfo;
    private DrawerLayout navDrawer;
    private NavigationView navView;
    private ProgressBar progressBar;
    private Button btnShare;
    private Intent shareIntent = new Intent(Intent.ACTION_SEND);
    Intent intent;
    private String[] premierLeague;
    private String[] championLeague;
    private String[] leagueOne;
    private String[] leagueTwo;
    private ArrayList<String> visitedClubs;
    private ArrayList<String> theWanderer;
    boolean unlocked = false;
    int total = 0;
    int champion = 0;
    int premier = 0;
    int leagueone = 0;
    int leaguetwo = 0;
    int wanderer = 0;
    int rover = 0;
    int cymru = 0;
    int NESW = 0;
    int masterApprentice = 0;
    int northern = 0;
    int littleNLarge = 0;
    int sitDown = 0;
    int cockney = 0;
    int claretNBlue = 0;
    int city = 0;
    int ranger = 0;
    int thechampions = 0;
    int lechampions = 0;
    int eleders = 0;
    int neighbour = 0;
    int longestAndShortest = 0;
    int albion = 0;
    int athlete = 0;
    int compass = 0;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toolbar = findViewById(R.id.my_toolbar);

        setSupportActionBar(toolbar);

        this.navDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, navDrawer, toolbar, R.string.open, R.string.close);
        navDrawer.addDrawerListener(toggle);
        toggle.syncState();
        this.navView = findViewById(R.id.nav_view);
        this.navView.setNavigationItemSelectedListener(this);
        NavigationView navigationView =navView;



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Navigation navigation = new Navigation(item,AchievemntInfo.this);
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
}
