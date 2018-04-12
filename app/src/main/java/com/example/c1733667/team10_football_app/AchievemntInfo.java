package com.example.c1733667.team10_football_app;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
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
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class AchievemntInfo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private TextView achievementInfo;
    private DrawerLayout navDrawer;
    private NavigationView navView;
    private ProgressBar progressBar;
    Intent intent;
    private String[] premierLeague;
    private String[] championLeague;
    private String[] leagueOne;
    private String[] leagueTwo;
    private ArrayList<String> visitedClubs;
    private ArrayList<String> theWanderer;
    int total = 0;
    int champion = 0;
    int premier = 0;
    int leagueone = 0;
    int leaguetwo = 0;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement_info_outer);
        toolbar = findViewById(R.id.infoToolbar);
        setSupportActionBar(toolbar);
        premierLeague = getResources().getStringArray(R.array.PremierLeagueTeams);
        championLeague = getResources().getStringArray(R.array.EFLC);
        leagueOne = getResources().getStringArray(R.array.EFL1);
        leagueTwo = getResources().getStringArray(R.array.EFL2);
        String achievementName = this.getIntent().getStringExtra("Achievement Name");
        if (achievementName != null) {
            toolbar.setTitle(achievementName);
            getAchievementInfo();
        }
        this.navDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, navDrawer, toolbar, R.string.open, R.string.close);
        navDrawer.addDrawerListener(toggle);
        toggle.syncState();
        this.navView = findViewById(R.id.nav_view);
        this.navView.setNavigationItemSelectedListener(this);

        SharedPreferences pref1 = getSharedPreferences("ChampionPreference", 0);
        SharedPreferences pref2 = getSharedPreferences("PremierPreference", 0);
        SharedPreferences pref3 = getSharedPreferences("LeagueOnePreference", 0);
        SharedPreferences pref4 = getSharedPreferences("LeagueTwoPreference", 0);

        Map map = pref1.getAll();
        Iterator iterator = map.keySet().iterator();
        for (Object key : map.keySet()) {
            if ((Boolean) map.get((String) key).equals(true)) {
                total = total + 1;
                champion = champion + 1;

            }
        }
        Map map2 = pref2.getAll();
        Iterator iterator1 = map2.keySet().iterator();
        for (Object key : map2.keySet()) {
            if ((Boolean) map2.get((String) key).equals(true)) {
                total = total + 1;
                premier = premier + 1;
            }
        }
        Map map3 = pref3.getAll();
        Iterator iterator2 = map3.keySet().iterator();
        for (Object key : map3.keySet()) {
            if ((Boolean) map3.get((String) key).equals(true)) {
                total = total + 1;
                leagueone = leagueone + 1;
            }
        }
        Map map4 = pref4.getAll();
        Iterator iterator3 = map4.keySet().iterator();
        for (Object key : map4.keySet()) {
            if ((Boolean) map4.get((String) key).equals(true)) {
                total = total + 1;
                leaguetwo = leaguetwo + 1;
            }
        }

        Log.d("Visited clubs", String.valueOf(visitedClubs));
        if (achievementName.equals("Over 50%")) {
            AchievementClass overFifty = new AchievementClass("Over 50%",46, total);
            overFifty.createProgessBar();
        }
        if (achievementName.equals("Over 60%")) {
            Log.d("Total", String.valueOf(total));
            AchievementClass overSixty = new AchievementClass("Over 60%",55,total);
            overSixty.createProgessBar();
        }
        if (achievementName.equals("Over 70%")) {
            progressBar = findViewById(R.id.achievementProgressBar);
            ObjectAnimator anim = ObjectAnimator.ofInt(progressBar, "progress", 0, (total * 100) / 64);
            anim.setDuration(850);
            anim.setInterpolator(new DecelerateInterpolator());
            anim.start();
        }
        if (achievementName.equals("Over 80%")) {
            progressBar = findViewById(R.id.achievementProgressBar);
            ObjectAnimator anim = ObjectAnimator.ofInt(progressBar, "progress", 0, (total * 100) / 74);
            anim.setDuration(850);
            anim.setInterpolator(new DecelerateInterpolator());
            anim.start();
        }
        if (achievementName.equals("Over 90%")) {
            progressBar = findViewById(R.id.achievementProgressBar);
            ObjectAnimator anim = ObjectAnimator.ofInt(progressBar, "progress", 0, (total * 100) / 83);
            anim.setDuration(850);
            anim.setInterpolator(new DecelerateInterpolator());
            anim.start();
        }
        if (achievementName.equals("Done the lot!")) {
            progressBar = findViewById(R.id.achievementProgressBar);
            ObjectAnimator anim = ObjectAnimator.ofInt(progressBar, "progress", 0, (total * 100) / 92);
            anim.setDuration(850);
            anim.setInterpolator(new DecelerateInterpolator());
            anim.start();
        }
    }

    public void getAchievementInfo() {
        Resources res = getResources();
        InputStream is = res.openRawResource(R.raw.achievement);
        Scanner scanner = new Scanner(is);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }
        parseJson(builder.toString());
    }

    private void parseJson(String json) {
        achievementInfo = (TextView) findViewById(R.id.achievementInfo);
        String achievementName = this.getIntent().getStringExtra("Achievement Name");
        StringBuilder info = new StringBuilder();
        try {
            JSONObject root = new JSONObject(json);
            JSONObject achievementInfo = root.getJSONObject(achievementName);
            info.append("Description:")
                    .append(achievementInfo.getString("Description"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        achievementInfo.setText(info.toString());
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
