package com.example.c1733667.team10_football_app;

import android.content.Intent;
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

public class Achievement extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemClickListener {
    private ListView listView;
    private String [] achievements;
    private Integer [] imageID;
    private DrawerLayout navDrawer;
    private NavigationView navView;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement_outer);
        achievements = getResources().getStringArray(R.array.achievements);
        listView = (ListView) findViewById(R.id.achievementList);
        CustomAdapter customAdapter = new CustomAdapter(Achievement.this,achievements,imageID);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(this);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        this.navDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,navDrawer,toolbar,R.string.open,R.string.close);
        navDrawer.addDrawerListener(toggle);
        toggle.syncState();
        this.navView = findViewById(R.id.nav_view);
        this.navView.setNavigationItemSelectedListener(this);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        intent = new Intent(getApplicationContext(),AchievemntInfo.class);
        intent.putExtra("Achievement Name", achievements[position]);
        startActivity(intent);
    }
}
