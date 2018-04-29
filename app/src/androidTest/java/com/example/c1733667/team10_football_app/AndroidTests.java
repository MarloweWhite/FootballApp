package com.example.c1733667.team10_football_app;

/**
 * Created by c1733667 on 27/04/2018.
 */

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.example.c1733667.team10_football_app.activities.Achievement;
import com.example.c1733667.team10_football_app.activities.HelpActivity;
import com.example.c1733667.team10_football_app.activities.MainActivity;
import com.example.c1733667.team10_football_app.activities.MapsActivity;
import com.example.c1733667.team10_football_app.activities.Score;
import com.example.c1733667.team10_football_app.activities.StadiumActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.matcher.ViewMatchers.hasImeAction;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static java.util.concurrent.CompletableFuture.allOf;
import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AndroidTests {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule
            = new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mainActivity = null;

    public ActivityTestRule<StadiumActivity> stadiumActivityActivityTestRule
            = new ActivityTestRule<StadiumActivity>(StadiumActivity.class);
    private StadiumActivity stadiumActivity = null;

    public ActivityTestRule<Score> scoreActivityTestRule
            = new ActivityTestRule<Score>(Score.class);
    private Score score = null;

    public ActivityTestRule<MapsActivity> mapsActivityActivityTestRule
            = new ActivityTestRule<MapsActivity>(MapsActivity.class);
    private MapsActivity mapsActivity = null;

    public ActivityTestRule<Achievement> achievementActivityTestRule
            = new ActivityTestRule<Achievement>(Achievement.class);
    private Achievement achievement = null;

    public ActivityTestRule<HelpActivity> helpActivityActivityTestRule
            = new ActivityTestRule<HelpActivity>(HelpActivity.class);
    private HelpActivity helpActivity = null;

    @Before
    public void setUp() {
        mainActivity = mainActivityActivityTestRule.getActivity();
        stadiumActivity = stadiumActivityActivityTestRule.getActivity();
        mapsActivity = mapsActivityActivityTestRule.getActivity();
        score = scoreActivityTestRule.getActivity();
        achievement = achievementActivityTestRule.getActivity();
        helpActivity = helpActivityActivityTestRule.getActivity();
    }

    @Test
    public void StadiumButtonTest() {
        onView(withId(R.id.btnStadium)).perform(click());
        Context appContext = InstrumentationRegistry.getContext();
        assertEquals("com.example.c1733667.team10_football_app.activities.StadiumActivity",
                StadiumActivity.class.getCanonicalName());
    }

    @Test
    public void ScoreButtonTest() {
        onView(withId(R.id.btnScore)).perform(click());
        assertEquals("com.example.c1733667.team10_football_app.activities.Score"
                , Score.class.getCanonicalName());
    }

    @Test
    public void MapButtonTest() {
        onView(withId(R.id.btnMap)).perform(click());
        assertEquals("com.example.c1733667.team10_football_app.activities.MapsActivity"
                , MapsActivity.class.getCanonicalName());
    }

    @Test
    public void AchievementButtonTest() {
        onView(withId(R.id.btnAchievement)).perform(click());
        assertEquals("com.example.c1733667.team10_football_app.activities.Achievement"
                , Achievement.class.getCanonicalName());
    }

    @Test
    public void HowToUseButtonTest() {
        onView(withId(R.id.btnHelp)).perform(click());
        assertEquals("com.example.c1733667.team10_football_app.activities.HelpActivity"
                , HelpActivity.class.getCanonicalName());
    }
}
