package com.example.c1733667.team10_football_app.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.c1733667.team10_football_app.R;
import com.example.c1733667.team10_football_app.classpack.Navigation;
import com.example.c1733667.team10_football_app.classpack.ThemeSetting;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import fragments.AchievementFragment;
import fragments.HelpFragment;
import fragments.MainFragment;
import fragments.MapsFragment;
import fragments.ScoreFragment;
import fragments.SettingFragment;
import fragments.StadiumFragment;

public class MapsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {

    private GoogleMap mMap;
    private String[] championLeague;
    private String[] premierLeague;
    private String[] leagueOne;
    private String[] leagueTwo;
    private ArrayList<String> clubName;
    private ArrayList<LatLng> visitedClubs;
    private DrawerLayout navDrawer;
    private NavigationView navView;
    private SharedPreferences pref1;
    private SharedPreferences pref2;
    private SharedPreferences pref3;
    private SharedPreferences pref4;
    private Intent intent;

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
        setContentView(R.layout.activity_maps_outer);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


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
                Navigation navigation = new Navigation(item, MapsActivity.this);
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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng defaultMap = new LatLng(52.644031, -2.321991);
        Map map = pref1.getAll();
        Map map1 = pref2.getAll();
        Map map2 = pref3.getAll();
        Map map3 = pref4.getAll();
        Iterator iterator = map.keySet().iterator();
        Iterator iterator1 = map1.keySet().iterator();
        Iterator iterator2 = map2.keySet().iterator();
        Iterator iterator3 = map3.keySet().iterator();

        while (iterator.hasNext()) {
            String key = (String) iterator.next();
//            Log.d("iterator", String.valueOf(iterator.next()));
            mMap.addMarker(new MarkerOptions()
                    .position(visitedClubs.get(Integer.parseInt(key)))
                    .visible((Boolean) map.get(key))
                    .title(clubName.get(Integer.parseInt(key))));
        }
        while (iterator1.hasNext()) {
            String key = (String) iterator1.next();
            mMap.addMarker(new MarkerOptions()
                    .position(visitedClubs.get(championLeague.length
                            + Integer.parseInt(key)))
                    .visible((Boolean) map1.get(key))
                    .title(clubName.get(championLeague.length
                            + Integer.parseInt(key))));
        }
        while (iterator2.hasNext()) {
            String key = (String) iterator2.next();
            mMap.addMarker(new MarkerOptions()
                    .position(visitedClubs.get(championLeague.length
                            + premierLeague.length
                            + Integer.parseInt(key)))
                    .visible((Boolean) map2.get(key))
                    .title(clubName.get(championLeague.length
                            + premierLeague.length
                            + Integer.parseInt(key))));
        }
        while (iterator3.hasNext()) {
            String key = (String) iterator3.next();
            mMap.addMarker(new MarkerOptions()
                    .position(visitedClubs.get(championLeague.length
                            + premierLeague.length
                            + leagueOne.length - 1
                            + Integer.parseInt(key)))
                    .visible((Boolean) map3.get(key))
                    .title(clubName.get(championLeague.length
                            + premierLeague.length
                            + leagueOne.length - 1
                            + Integer.parseInt(key))));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultMap, 6));
    }
}
