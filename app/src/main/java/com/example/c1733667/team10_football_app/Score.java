package com.example.c1733667.team10_football_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Map;


public class Score extends AppCompatActivity implements AdapterView.OnClickListener{

    private int mainScore;
    ProgressBar mprogressBar;
    //private String[] stadiumsNum = {"1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoring_system);
        SharedPreferences pref1 = getSharedPreferences("ChampionPreference", 0);
        SharedPreferences pref2 = getSharedPreferences("PremierPreference", 0);
        SharedPreferences pref3 = getSharedPreferences("LeagueOnePreference", 0);
        SharedPreferences pref4 = getSharedPreferences("LeagueTwoPreference", 0);
//        int lenStadiums1 = pref1.getAll().size() ;

        Map map = pref1.getAll();
        int total = 0;

        for (Object key: map.keySet()){
            if( (Boolean) map.get((String) key).equals(true)){
               total=total +1;
            }
        }
        Map map2= pref2.getAll();
        for (Object key: map2.keySet()){
            if( (Boolean) map2.get((String) key).equals(true)){
                total=total +1;
            }
        }
        Map map3 = pref3.getAll();
        for (Object key: map3.keySet()){
            if( (Boolean) map3.get((String) key).equals(true)){
                total=total +1;
            }
        }
        Map map4= pref4.getAll();
        for (Object key: map4.keySet()){
            if( (Boolean) map4.get((String) key).equals(true)){
                total=total +1;
            }
        }
//        int lenStadiums2 = pref2.getAll().size() ;
//        int lenStadiums3 = pref3.getAll().size() ;
//        int lenStadiums4 = pref4.getAll().size() ;
//        int totalStadiums = lenStadiums1 + lenStadiums2 + lenStadiums3 + lenStadiums4;

        this.mainScore = total;

        long totalPerc = (long) Math.floor(100 * mainScore);
        long totalPerc1 = (long) Math.floor(totalPerc / 92 );
        //String yourScoreIs = getResources().getString(R.string.your_score);
        //String showScore = String.format(yourScoreIs, mainScore);
        TextView textView = (TextView) findViewById(R.id.textViewName);
        textView.setText("Your percentage of clubs you have been too :" + totalPerc1 + "%");
        TextView textView2 = (TextView) findViewById(R.id.textViewName2);
        textView2.setText("Your Score is :" + mainScore );

        mprogressBar = (ProgressBar) findViewById(R.id.circular_progress_bar);
        ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "progress", 0, mainScore);
        anim.setDuration(850);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.start();
    }




    @Override
    public void onClick(View v) {

    }
}
