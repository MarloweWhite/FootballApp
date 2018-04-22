package com.example.c1733667.team10_football_app.activities;

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
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.c1733667.team10_football_app.R;
import com.example.c1733667.team10_football_app.adapterpack.AchievementCustomAdapter;

import java.util.Map;

public class Achievement extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemClickListener {
    private ListView listView;
    private String[] achievements;
    private Integer[] imageID;
    private DrawerLayout navDrawer;
    private NavigationView navView;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences pref1 = getSharedPreferences("High contrast", 0);
        Map map = pref1.getAll();
        for (Object key : map.keySet()) {
            Log.d("preference", (String) key);
            Log.d("highcontrast", String.valueOf(R.id.highContrast));
            if (map.get(String.valueOf(R.id.highContrast)).equals(true)) {
                setTheme(R.style.HighContrastTheme);
                setContentView(R.layout.activity_achievement_outer);
            } else {
                setTheme(R.style.AppTheme);
                setContentView(R.layout.activity_achievement_outer);
            }
            if (map.get(String.valueOf(R.id.smallcheckbox)).equals(true)){
                setTheme(R.style.smallText);
            }
            if (map.get(String.valueOf(R.id.mediumcheckbox)).equals(true)){
                setTheme(R.style.mediumText);
            }
            if (map.get(String.valueOf(R.id.largecheckbox)).equals(true)){
                setTheme(R.style.largeText);
            }
        }


        achievements = getResources().getStringArray(R.array.achievements);
        listView = (ListView) findViewById(R.id.achievementList);
        AchievementCustomAdapter customAdapter = new AchievementCustomAdapter(Achievement.this, achievements, imageID);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(this);

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
                switch (item.getItemId()) {
                    case R.id.stad:
                        Intent intent = new Intent(Achievement.this, StadiumActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.scores:
                        Intent intent1 = new Intent(Achievement.this, Score.class);
                        startActivity(intent1);
                        break;


                    case R.id.maps:
                        Intent intent2 = new Intent(Achievement.this, MapsActivity.class);
                        startActivity(intent2);
                        break;


                    case R.id.exit:
                        System.exit(0);


                    case R.id.home:
                        Intent intent3 = new Intent(Achievement.this, MainActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.achievements:
                        Intent intent4 = new Intent(Achievement.this, Achievement.class);
                        startActivity(intent4);
                        break;

                    case R.id.help:
                        Intent intent5 = new Intent(Achievement.this, HelpActivity.class);
                        startActivity(intent5);
                        break;
                    case R.id.settings:
                        Intent intent6 = new Intent(getApplicationContext(), SettingActivity.class);
                        startActivity(intent6);
                        break;

                }
                return false;
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        intent = new Intent(getApplicationContext(), AchievemntInfo.class);
        intent.putExtra("AchievementLogic Name", achievements[position]);
        startActivity(intent);
    }
}
