package com.example.c1733667.team10_football_app;

import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

/**
 * Created by c1733667 on 12/04/2018.
 */

public class AchievementClass {
    String name;
    Integer targetNumber;
    Integer actualNumber;
    ProgressBar progressBar;

    public AchievementClass(String name, Integer targetNumber, Integer actualNumber) {
        this.name = name;
        this.targetNumber = targetNumber;
        this.actualNumber = actualNumber;
    }

    private ProgressBar findViewById(int achievementProgressBar) {
        progressBar = findViewById(R.id.achievementProgressBar);
        return progressBar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(Integer targetNumber) {
        this.targetNumber = targetNumber;
    }

    public Integer getActualNumber() {
        return actualNumber;
    }

    public void setActualNumber(Integer actualNumber) {
        this.actualNumber = actualNumber;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }
    public void createProgessBar(){
        Log.d("actual number", String.valueOf(actualNumber));
        Log.d("target number", String.valueOf(targetNumber));
        ObjectAnimator anim =ObjectAnimator.ofInt(progressBar, "progress", 0, (actualNumber*100)/targetNumber);
        anim.setDuration(850);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.start();
    }
}
