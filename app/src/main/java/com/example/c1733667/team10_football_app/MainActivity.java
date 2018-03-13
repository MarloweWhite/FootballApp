package com.example.c1733667.team10_football_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnStadium;
    private Button btnScore;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stadiumButtonListener();
//        scoreButtonListener();
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
//    public void scoreButtonListener(){
//        btnScore = findViewById(R.id.btnScore);
//        btnScore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent= new Intent(getApplicationContext(), Score.class);
//                startActivity(intent);
//            }
//        });
//    }
}
