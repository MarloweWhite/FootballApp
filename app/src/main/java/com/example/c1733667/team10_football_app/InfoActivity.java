package com.example.c1733667.team10_football_app;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
    private TextView clubName;
    private Intent intent;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        clubName= findViewById(R.id.clubName);
        toolbar = findViewById(R.id.infoToolbar);
        String clubFromOtherActivity = this.getIntent().getStringExtra("Club Name");
        if (clubFromOtherActivity != null){
            clubName.setText(clubFromOtherActivity);
            toolbar.setTitle(clubFromOtherActivity);

        }
    }
}
