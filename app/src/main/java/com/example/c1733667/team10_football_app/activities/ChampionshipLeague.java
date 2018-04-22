package com.example.c1733667.team10_football_app.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.support.design.widget.NavigationView;

import com.example.c1733667.team10_football_app.R;

import java.util.Map;

public class ChampionshipLeague extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, NavigationView.OnNavigationItemSelectedListener {
    private String[] championLeague;
    private Intent intent;
    private SharedPreferences sharedPreferences;
    private ListViewCompat lv;
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

        SharedPreferences pref1 = getSharedPreferences("High contrast", 0);
        Map setting = pref1.getAll();
        for (Object key : setting.keySet()) {
            Log.d("preference", (String) key);
            Log.d("highcontrast", String.valueOf(R.id.highContrast));
            if (setting.get(String.valueOf(R.id.highContrast)).equals(true)) {
                setTheme(R.style.HighContrastTheme);
                setContentView(R.layout.activity_championship_league_outer);
            } else {
                setTheme(R.style.AppTheme);
                setContentView(R.layout.activity_championship_league_outer);
            }
            if (setting.get(String.valueOf(R.id.smallcheckbox)).equals(true)){
                setTheme(R.style.smallText);
            }
            if (setting.get(String.valueOf(R.id.mediumcheckbox)).equals(true)){
                setTheme(R.style.mediumText);
            }
            if (setting.get(String.valueOf(R.id.largecheckbox)).equals(true)){
                setTheme(R.style.largeText);
            }
        }

        sharedPreferences = getSharedPreferences("ChampionPreference", Context.MODE_PRIVATE);

        ArrayAdapter<String> championAdapter;
        championLeague = getResources().getStringArray(R.array.EFLC);
        championAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, championLeague);
        lv = findViewById(R.id.championList);
        lv.setChoiceMode(ListViewCompat.CHOICE_MODE_MULTIPLE);
        lv.setAdapter(championAdapter);
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        this.navDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, navDrawer, toolbar, R.string.open, R.string.close);
        navDrawer.addDrawerListener(toggle);
        toggle.syncState();
        this.navView = findViewById(R.id.nav_view);
        this.navView.setNavigationItemSelectedListener(this);

        Map map = sharedPreferences.getAll();
        for (Object key : map.keySet()) {
            lv.setItemChecked(Integer.valueOf((String) key), (Boolean) map.get((String) key));
        }

        NavigationView navigationView = navView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.stad:
                        Intent intent = new Intent(ChampionshipLeague.this, StadiumActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.scores:
                        Intent intent1 = new Intent(ChampionshipLeague.this, Score.class);
                        startActivity(intent1);
                        break;


                    case R.id.maps:
                        Intent intent2 = new Intent(ChampionshipLeague.this, MapsActivity.class);
                        startActivity(intent2);
                        break;


                    case R.id.exit:
                        System.exit(0);


                    case R.id.home:
                        Intent intent3 = new Intent(ChampionshipLeague.this, MainActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.achievements:
                        Intent intent4 = new Intent(ChampionshipLeague.this, Achievement.class);
                        startActivity(intent4);
                        break;

                    case R.id.help:
                        Intent intent5 = new Intent(ChampionshipLeague.this, HelpActivity.class);
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, String.format("Item clicked on = %d", position), Toast.LENGTH_SHORT).show();

        SparseBooleanArray checkeditems = lv.getCheckedItemPositions();
        sharedPreferences.edit().putBoolean(String.valueOf(position), checkeditems.get(position)).commit();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        intent = new Intent(getApplicationContext(), InfoActivity.class);
        intent.putExtra("Club Name", championLeague[position]);
        startActivity(intent);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
