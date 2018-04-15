package com.example.c1733667.team10_football_app;

import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
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
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.Map;

/**
 * Created by c1741877 on 15/04/2018.
 */

public class HelpActivity extends AppCompatActivity implements AdapterView.OnClickListener {
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
        setContentView(R.layout.activity_help);

        TextView aboutTheApp = (TextView) findViewById(R.id.aboutTheApp);
        TextView help = (TextView) findViewById(R.id.howToUse);
        aboutTheApp.setText("About the app:\n\nOur app is an app designed to help its users keep track of all the football stadiums that they have visited throughout the UKn\n");
        help.setText("How To Use:\n\nAdding Stadiums:\nTo add stadiums that you've visited, simply press the \"Stadiums\" button from the home screen and then select the league that the satdium is associated with.\nThen simply tap the name of a stadium to tick it, or long press it to view more information\n");


    }




    @Override
    public void onClick(View v) {

    }
}
