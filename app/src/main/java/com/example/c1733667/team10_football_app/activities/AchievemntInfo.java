package com.example.c1733667.team10_football_app.activities;

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
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.c1733667.team10_football_app.R;
import com.example.c1733667.team10_football_app.classpack.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class AchievemntInfo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Button btnShare;
    private Toolbar toolbar;
    private TextView achievementInfo;
    private DrawerLayout navDrawer;
    private NavigationView navView;
    private ProgressBar progressBar;
    Intent intent;
    private Intent shareIntent = new Intent(Intent.ACTION_SEND);
    private String[] premierLeague;
    private String[] championLeague;
    private String[] leagueOne;
    private String[] leagueTwo;
    private int total = 0;
    private int champion = 0;
    private int premier = 0;
    private  int leagueone = 0;
    private int leaguetwo = 0;
    private String name;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences pref = getSharedPreferences("High contrast", 0);
        ThemeSetting achievementInfoSetting =new ThemeSetting(pref,AchievemntInfo.this);
        achievementInfoSetting.setHighContrast(R.layout.activity_achievement_info_outer);
        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        shareButtonListener();
        premierLeague = getResources().getStringArray(R.array.PremierLeagueTeams);
        championLeague = getResources().getStringArray(R.array.EFLC);
        leagueOne = getResources().getStringArray(R.array.EFL1);
        leagueTwo = getResources().getStringArray(R.array.EFL2);
        String achievementName = this.getIntent().getStringExtra("Achievement Name");
        this.name = achievementName;
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
        NavigationView navigationView =navView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Navigation navigation = new Navigation(item,AchievemntInfo.this);
                navigation.activityNavigation(getApplicationContext());
                return false;
            }
        });

        SharedPreferences pref1 = getSharedPreferences("ChampionPreference", 0);
        SharedPreferences pref2 = getSharedPreferences("PremierPreference", 0);
        SharedPreferences pref3 = getSharedPreferences("LeagueOnePreference", 0);
        SharedPreferences pref4 = getSharedPreferences("LeagueTwoPreference", 0);

        Map map1 = pref1.getAll();
        for (Object key : map1.keySet()) {
            if (map1.get(key).equals(true)) {
                total = total + 1;
//                champion = champion + 1;
            }

        }
        Map map2 = pref2.getAll();
        for (Object key : map2.keySet()) {
            Log.d("Team", premierLeague[Integer.parseInt(String.valueOf(key))]);
            if (map2.get(key).equals(true)) {
                total = total + 1;
                premier = premier + 1;
            }
        }
        Map map3 = pref3.getAll();
        for (Object key : map3.keySet()) {
            if (map3.get(key).equals(true)) {
                total = total + 1;
                leagueone = leagueone + 1;
            }
        }
        Map map4 = pref4.getAll();
        for (Object key : map4.keySet()) {
            if (map4.get(key).equals(true)) {
                total = total + 1;
                leaguetwo = leaguetwo + 1;
            }
        }
        String[] requirementsList = null;
        int amount = 0;
        int completed = 0;
        String requirements = getRequirements(achievementName);
        if (requirements.substring(0,1).equals("%")){
            amount = stringToInt(requirements.substring(1)) * 92/100;
            completed += total;

        }else if(requirements.substring(0,1).equals("<")){
            if (requirements.equals("<Prem>")){
                completed += premier;
            }else if (requirements.equals("<Champ>")){
                completed += champion;
            }else if (requirements.equals("<One>")){
                completed += leagueone;
            }else if (requirements.equals("<Two>")){
                completed += leaguetwo;
            }else{

            }
        }else{
            requirementsList = requirements.split(", ");
            amount = requirementsList.length;
            for (int i = 0; i < requirementsList.length; i++){
                for (Object key : map1.keySet()) {
                    if (map1.get(key) != null && map1.get(key).equals(true)
                            && championLeague[Integer.parseInt(String.valueOf(key))].equals(requirementsList[i])) {
                        completed += 1;
                    }
                }
                for (Object key : map2.keySet()) {
                    if (map2.get(key) != null && map2.get(key).equals(true)
                            && premierLeague[Integer.parseInt(String.valueOf(key))].equals(requirementsList[i])) {
                        completed += 1;
                    }
                }
                for (Object key : map3.keySet()) {
                    if (map3.get(key) != null && map3.get(key).equals(true)
                            && leagueOne[Integer.parseInt(String.valueOf(key))].equals(requirementsList[i])) {
                        completed += 1;
                    }
                }
                for (Object key : map4.keySet()) {
                    if (map4.get(key) != null && map4.get(key).equals(true)
                            && leagueTwo[Integer.parseInt(String.valueOf(key))].equals(requirementsList[i])) {
                        completed += 1;
                    }
                }
            }

        }

        AchievementClass achievement = new AchievementClass(achievementName, amount, completed);
        achievement.createProgessBar(progressBar = findViewById(R.id.achievementProgressBar));


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
        String achievementName = this.getIntent().getStringExtra("AchievementLogic Name");
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

    public String getRequirements(String name){
        Resources res = getResources();
        InputStream is = res.openRawResource(R.raw.achievement);
        Scanner scanner = new Scanner(is);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }
        String json = builder.toString();
        String requirements = null;
        try{
            JSONObject root = new JSONObject(json);
            JSONObject clubInfo = root.getJSONObject(name);
            requirements = clubInfo.getString("Requirement");


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return requirements;


    }
    public String getChievementText(String name){
        Resources res = getResources();
        InputStream is = res.openRawResource(R.raw.achievement);
        Scanner scanner = new Scanner(is);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }
        String json = builder.toString();
        String shares = null;
        try{
            JSONObject root = new JSONObject(json);
            JSONObject clubInfo = root.getJSONObject(name);
            shares = clubInfo.getString("Share");


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return shares;


    }
    public int stringToInt(String input){
        int r = 0;
        for (int i = 0; i < input.length(); i++){
            switch (input.charAt(i)){
                case '0': r = (r*10)+0;
                    break;
                case '1': r = (r*10)+1;
                    break;
                case '2': r = (r*10)+2;
                    break;
                case '3': r = (r*10)+3;
                    break;
                case '4': r = (r*10)+4;
                    break;
                case '5': r = (r*10)+5;
                    break;
                case '6': r = (r*10)+6;
                    break;
                case '7': r = (r*10)+7;
                    break;
                case '8': r = (r*10)+8;
                    break;
                case '9': r = (r*10)+9;
                    break;
                default: return r;
            }
        }
        return r;
    }
    public String getName(){
        return this.name;
    }
    public void shareButtonListener() {
        btnShare = findViewById(R.id.btnShareAch);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareContent = (getChievementText(getName()));
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareContent);

                startActivity(Intent.createChooser(shareIntent, "Share via:"));
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }
}
