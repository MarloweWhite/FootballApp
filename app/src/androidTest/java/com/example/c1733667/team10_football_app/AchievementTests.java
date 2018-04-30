package com.example.c1733667.team10_football_app;

import android.content.SharedPreferences;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;

import com.example.c1733667.team10_football_app.activities.AchievemntInfo;
import com.example.c1733667.team10_football_app.activities.InfoActivity;
import com.example.c1733667.team10_football_app.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;

/**
 * Created by c1733667 on 29/04/2018.
 */
@LargeTest
public class AchievementTests {
    @Rule
    ActivityTestRule<MainActivity> mainActivityActivityTestRule
            = new ActivityTestRule<MainActivity>(MainActivity.class);
    ActivityTestRule<AchievemntInfo> achievemntInfoActivityTestRule
            = new ActivityTestRule<AchievemntInfo>(AchievemntInfo.class);
}
