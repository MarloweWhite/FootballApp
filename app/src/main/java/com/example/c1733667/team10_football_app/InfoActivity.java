package com.example.c1733667.team10_football_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
    private TextView clubName;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        clubName= findViewById(R.id.clubName);
        String clubFromOtherActivity = this.getIntent().getStringExtra("Club Name");
        if (clubFromOtherActivity != null){
            clubName.setText(clubFromOtherActivity);
        }
    }
}
