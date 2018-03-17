package com.example.c1733667.team10_football_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {
    private Button btnStadium;
    private Button btnScore;
    private Intent intent;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stadiumButtonListener();
        scoreButtonListener();

        MobileAds.initialize(this, "ca-app-pub-2747796691426534~5751833757");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void stadiumButtonListener() {
        btnStadium = findViewById(R.id.btnStadium);
        btnStadium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), StadiumActivity.class);
                startActivity(intent);
            }
        });
    }
    public void scoreButtonListener(){
        btnScore = findViewById(R.id.btnScore);
        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent= new Intent(getApplicationContext(), Score.class);
                startActivity(intent);
            }
        });
    }
}
