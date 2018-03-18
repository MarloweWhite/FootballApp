package com.example.c1733667.team10_football_app;

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

public class Score extends AppCompatActivity implements AdapterView.OnClickListener{

    private int mainScore;
    ProgressBar mprogressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoring_system);
        this.mainScore = 10;
        //String yourScoreIs = getResources().getString(R.string.your_score);
        //String showScore = String.format(yourScoreIs, mainScore);
        TextView textView = (TextView) findViewById(R.id.textViewName);
        textView.setText("Your Score is :" + mainScore + "%");


        mprogressBar = (ProgressBar) findViewById(R.id.circular_progress_bar);
        ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "progress", 0, mainScore);
        anim.setDuration(15000);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.start();
    }




    @Override
    public void onClick(View v) {

    }
}
