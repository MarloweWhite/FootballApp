package com.example.c1733667.team10_football_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.c1733667.team10_football_app.R;

/**
 * Created by c1741877 on 15/04/2018.
 */

public class HelpActivity extends AppCompatActivity implements AdapterView.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout navDrawer;
    private NavigationView navView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_outer);

        TextView aboutTheApp = (TextView) findViewById(R.id.aboutTheApp);
        TextView help = (TextView) findViewById(R.id.howToUse);
        aboutTheApp.setText("About the app:\n\nOur app is an app designed to help its users keep track of all the football stadiums that they have visited throughout the UK\n");
        help.setText("How To Use:\n\nAdding Stadiums:\nTo add stadiums that you've visited, simply press the \"Stadiums\" button from the home screen and then select the league that the satdium is associated with.\nThen simply tap the name of a stadium to tick it, or long press it to view more information\n");

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        this.navDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,navDrawer,toolbar,R.string.open,R.string.close);
        navDrawer.addDrawerListener(toggle);
        toggle.syncState();
        this.navView = findViewById(R.id.nav_view);
        this.navView.setNavigationItemSelectedListener(this);

        NavigationView navigationView = navView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.stad:
                        Intent intent = new Intent(HelpActivity.this, StadiumActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.scores:
                        Intent intent1 = new Intent(HelpActivity.this, Score.class);
                        startActivity(intent1);
                        break;



                    case R.id.maps:
                        Intent intent2 = new Intent(HelpActivity.this, MapsActivity.class);
                        startActivity(intent2);
                        break;



                    case R.id.exit:
                        System.exit(0);


                    case R.id.home:
                        Intent intent3 = new Intent(HelpActivity.this, MainActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.achievements:
                        Intent intent4 = new Intent(HelpActivity.this, Achievement.class);
                        startActivity(intent4);
                        break;

                    case R.id.help:
                        Intent intent5 = new Intent(HelpActivity.this, HelpActivity.class);
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
    public void onClick(View v) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
