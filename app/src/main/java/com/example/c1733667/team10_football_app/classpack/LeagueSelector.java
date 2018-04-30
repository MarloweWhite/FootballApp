package com.example.c1733667.team10_football_app.classpack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.c1733667.team10_football_app.R;
import com.example.c1733667.team10_football_app.activities.ChampionshipLeague;
import com.example.c1733667.team10_football_app.activities.LeagueOne;
import com.example.c1733667.team10_football_app.activities.LeagueTwo;
import com.example.c1733667.team10_football_app.activities.PremierLeague;

import fragments.ChampionsLeagueFragment;
import fragments.LeagueOneFragment;
import fragments.LeagueTwoFragment;
import fragments.MapsFragment;
import fragments.PremierLeagueFragment;

/**
 * Created by c1733667 on 16/04/2018.
 */

public class LeagueSelector extends AppCompatActivity {

    private Intent intent;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

        public void selectLeague(int position, Context context) {



            Log.d("TESTING TAG", "IT WORKED");
            switch (position) {
                case 0:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.stadium_container, new PremierLeagueFragment())
                            .commit();

                    break;
                case 1:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.stadium_container, new ChampionsLeagueFragment())
                            .commit();
                    ;
                    break;
                case 2:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.stadium_container, new LeagueOneFragment())
                            .commit();
                    ;
                    break;
                case 3:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.stadium_container, new LeagueTwoFragment())
                            .commit();
                    break;
            }
        }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public LeagueSelector(int position) {
        this.position = position;
    }

    }

