package com.example.c1733667.team10_football_app.activities;

import android.content.Context;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.example.c1733667.team10_football_app.R;
import com.example.c1733667.team10_football_app.classpack.ThemeSetting;

import java.util.Map;

public class SettingActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
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
        Map map = pref1.getAll();
        for (Object key : map.keySet()) {
            Log.d("preference", (String) key);
            Log.d("highcontrast", String.valueOf(R.id.highContrast));
            if (map.get(String.valueOf(R.id.highContrast)).equals(true)) {
                setTheme(R.style.HighContrastTheme);
                setContentView(R.layout.activity_setting_outer);
            } else {
                setTheme(R.style.AppTheme);
                setContentView(R.layout.activity_setting_outer);
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
//        ThemeSetting settingTheme = new ThemeSetting(pref1);
//        settingTheme.setHighContrast(R.layout.activity_setting_outer);


        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        this.navDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, navDrawer, toolbar, R.string.open, R.string.close);
        navDrawer.addDrawerListener(toggle);
        toggle.syncState();
        this.navView = findViewById(R.id.nav_view);
        this.navView.setNavigationItemSelectedListener(this);

        CheckBox HighContrastcheckBox = findViewById(R.id.highContrast);
        HighContrastcheckBox.setChecked(getSharedPreferences("High contrast",
                Context.MODE_PRIVATE)
                .getBoolean(String.valueOf(R.id.highContrast),
                        false));

        CheckBox smallTextCheckBox = findViewById(R.id.smallcheckbox);
        smallTextCheckBox.setChecked(getSharedPreferences("High contrast",
                Context.MODE_PRIVATE)
                .getBoolean(String.valueOf(R.id.smallcheckbox),
                        false));

        CheckBox mediumTextCheckBox =findViewById(R.id.mediumcheckbox);
        mediumTextCheckBox.setChecked(getSharedPreferences("High contrast",
                Context.MODE_PRIVATE)
                .getBoolean(String.valueOf(R.id.mediumcheckbox),
                        false));

        CheckBox largeTextCheckBox = findViewById(R.id.largecheckbox);
        largeTextCheckBox.setChecked(getSharedPreferences("High contrast",
                Context.MODE_PRIVATE)
                .getBoolean(String.valueOf(R.id.largecheckbox),
                        false));

        NavigationView navigationView = navView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.stad:
                        Intent intent = new Intent(getApplicationContext(), StadiumActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.scores:
                        Intent intent1 = new Intent(getApplicationContext(), Score.class);
                        startActivity(intent1);
                        break;


                    case R.id.maps:
                        Intent intent2 = new Intent(getApplicationContext(), MapsActivity.class);
                        startActivity(intent2);
                        break;


                    case R.id.exit:
                        System.exit(0);


                    case R.id.home:
                        Intent intent3 = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.achievements:
                        Intent intent4 = new Intent(getApplicationContext(), Achievement.class);
                        startActivity(intent4);
                        break;
                    case R.id.settings:
                        Intent intent5 = new Intent(getApplicationContext(), SettingActivity.class);
                        startActivity(intent5);
                        break;

                }
                return false;
            }
        });
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        SharedPreferences sharedPreference = getSharedPreferences("High contrast", Context.MODE_PRIVATE);
        switch (view.getId()) {
            case R.id.highContrast:
                sharedPreference.edit().putBoolean(String.valueOf(R.id.highContrast), checked).commit();
                Intent intent = new Intent(getBaseContext(), SettingActivity.class);
                intent.putExtra("CHECK_BOX", checked);
                Log.d("CheckBox", String.valueOf(checked));
                finish();
                startActivity(intent);
                break;
            case R.id.smallcheckbox:
                sharedPreference.edit().putBoolean(String.valueOf(R.id.smallcheckbox), checked).commit();
                Intent smallIntent = new Intent(getBaseContext(), SettingActivity.class);
                smallIntent.putExtra("SMALL_CHECK", checked);
                finish();
                startActivity(smallIntent);
                break;
            case R.id.mediumcheckbox:
                sharedPreference.edit().putBoolean(String.valueOf(R.id.mediumcheckbox), checked).commit();
                Intent mediumIntent = new Intent(getBaseContext(), SettingActivity.class);
                mediumIntent.putExtra("MEDIUM_CHECK", checked);
                finish();
                startActivity(mediumIntent);
                break;
            case R.id.largecheckbox:
                sharedPreference.edit().putBoolean(String.valueOf(R.id.largecheckbox), checked).commit();
                Intent largeIntent = new Intent(getBaseContext(), SettingActivity.class);
                largeIntent.putExtra("LARGE_CHECK", checked);
                finish();
                startActivity(largeIntent);
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}


