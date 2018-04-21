package com.example.c1733667.team10_football_app.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.animation.ObjectAnimator;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.c1733667.team10_football_app.R;

import java.util.Map;


public class Score extends AppCompatActivity implements AdapterView.OnClickListener, NavigationView.OnNavigationItemSelectedListener{

    private Button btnShare;
    private int mainScore;
    private Intent shareIntent = new Intent(Intent.ACTION_SEND);
    ProgressBar mprogressBar;
    ProgressBar mprogressBar2;
    ProgressBar mprogressBar3;
    ProgressBar mprogressBar4;
    ProgressBar mprogressBar5;
    DrawerLayout navDrawer;
    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring_system_outer);
        shareButtonListener();
        SharedPreferences pref1 = getSharedPreferences("ChampionPreference", 0);
        SharedPreferences pref2 = getSharedPreferences("PremierPreference", 0);
        SharedPreferences pref3 = getSharedPreferences("LeagueOnePreference", 0);
        SharedPreferences pref4 = getSharedPreferences("LeagueTwoPreference", 0);

        Map map = pref1.getAll();
        int total = 0;

        for (Object key: map.keySet()){
            if( (Boolean) map.get((String) key).equals(true)){
                total=total +1;
            }
        }
        int total2 = 0;
        Map map2= pref2.getAll();
        for (Object key: map2.keySet()){
            if( (Boolean) map2.get((String) key).equals(true)){
                total2=total2 +1;
            }
        }
        int total3 = 0;
        Map map3 = pref3.getAll();
        for (Object key: map3.keySet()){
            if( (Boolean) map3.get((String) key).equals(true)){
                total3=total3 +1;
            }
        }
        int total4 = 0;
        Map map4= pref4.getAll();
        for (Object key: map4.keySet()){
            if( (Boolean) map4.get((String) key).equals(true)){
                total4=total4 +1;
            }
        }

        int grantotal = total + total2 + total3 + total4;
        this.mainScore = grantotal;

        long totalPerc = (long) Math.floor(100 * mainScore);
        long totalPerc1 = (long) Math.floor(totalPerc / 92 );
        //String yourScoreIs = getResources().getString(R.string.your_score);
        //String showScore = String.format(yourScoreIs, mainScore);
        TextView textView = (TextView) findViewById(R.id.textViewName);
        textView.setText("Your percentage of clubs you have been too :" + totalPerc1 + "%");
        TextView textView2 = (TextView) findViewById(R.id.textViewName2);
        textView2.setText("Your Score is :" + mainScore );
        TextView textView3 = (TextView) findViewById(R.id.championsleagueperc);
        textView3.setText(total+"/24");

        TextView textView4 = (TextView) findViewById(R.id.premierleagueperc);
        textView4.setText(total2 +"/20");
        TextView textView5 = (TextView) findViewById(R.id.leagueoneperc);
        textView5.setText(total3+"/24");
        TextView textView6 = (TextView) findViewById(R.id.leaguetwoperc);
        textView6.setText(total4+"/24");


        mprogressBar = (ProgressBar) findViewById(R.id.circular_progress_bar);
        ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "progress", 0, total);
        anim.setDuration(850);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.start();

        mprogressBar2 = (ProgressBar) findViewById(R.id.circular_progress_bar2);
        ObjectAnimator anim2 = ObjectAnimator.ofInt(mprogressBar2, "progress", 0, total2);
        anim2.setDuration(850);
        anim2.setInterpolator(new DecelerateInterpolator());
        anim2.start();

        mprogressBar3 = (ProgressBar) findViewById(R.id.circular_progress_bar3);
        ObjectAnimator anim3 = ObjectAnimator.ofInt(mprogressBar3, "progress", 0, total3);
        anim3.setDuration(850);
        anim3.setInterpolator(new DecelerateInterpolator());
        anim3.start();

        mprogressBar4 = (ProgressBar) findViewById(R.id.circular_progress_bar4);
        ObjectAnimator anim4 = ObjectAnimator.ofInt(mprogressBar4, "progress", 0, total4);
        anim4.setDuration(850);
        anim4.setInterpolator(new DecelerateInterpolator());
        anim4.start();

        mprogressBar5 = (ProgressBar) findViewById(R.id.progress_bar);
        ObjectAnimator anim5 = ObjectAnimator.ofInt(mprogressBar5, "progress", 0, mainScore);
        anim5.setDuration(850);
        anim5.setInterpolator(new DecelerateInterpolator());
        anim5.start();


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
                        Intent intent = new Intent(Score.this, StadiumActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.scores:
                        Intent intent1 = new Intent(Score.this, Score.class);
                        startActivity(intent1);
                        break;



                    case R.id.maps:
                        Intent intent2 = new Intent(Score.this, MapsActivity.class);
                        startActivity(intent2);
                        break;



                    case R.id.exit:
                        System.exit(0);


                    case R.id.home:
                        Intent intent3 = new Intent(Score.this, MainActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.achievements:
                        Intent intent4 = new Intent(Score.this, Achievement.class);
                        startActivity(intent4);
                        break;

                    case R.id.help:
                        Intent intent5 = new Intent(Score.this, HelpActivity.class);
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
    public void shareButtonListener() {
        btnShare = findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareContent = ("I have visited "+mainScore+" out of the 92 football stadiums in the UK!\nHow many have you visited?");
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareContent);

                startActivity(Intent.createChooser(shareIntent, "Share via:"));
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
