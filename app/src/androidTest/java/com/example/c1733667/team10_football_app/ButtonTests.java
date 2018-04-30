package com.example.c1733667.team10_football_app;

/**
 * Created by c1733667 on 27/04/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.example.c1733667.team10_football_app.activities.Achievement;
import com.example.c1733667.team10_football_app.activities.HelpActivity;
import com.example.c1733667.team10_football_app.activities.InfoActivity;
import com.example.c1733667.team10_football_app.activities.MainActivity;
import com.example.c1733667.team10_football_app.activities.MapsActivity;
import com.example.c1733667.team10_football_app.activities.PremierLeague;
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
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasCategories;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey;
import static android.support.test.espresso.matcher.ViewMatchers.hasImeAction;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static java.util.concurrent.CompletableFuture.allOf;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.EasyMock2Matchers.equalTo;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ButtonTests {
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

    public ActivityTestRule<PremierLeague> premierLeagueActivityTestRule
            = new ActivityTestRule<PremierLeague>(PremierLeague.class);
    private PremierLeague premierLeague = null;

    public ActivityTestRule<InfoActivity> infoActivityActivityTestRule
            = new ActivityTestRule<InfoActivity>(InfoActivity.class);
    private InfoActivity infoActivity = null;

    @Before
    public void setUp() {
        mainActivity = mainActivityActivityTestRule.getActivity();
        stadiumActivity = stadiumActivityActivityTestRule.getActivity();
        mapsActivity = mapsActivityActivityTestRule.getActivity();
        score = scoreActivityTestRule.getActivity();
        achievement = achievementActivityTestRule.getActivity();
        helpActivity = helpActivityActivityTestRule.getActivity();
        premierLeague = premierLeagueActivityTestRule.getActivity();
        infoActivity =infoActivityActivityTestRule.getActivity();
    }

    @Test
    public void StadiumButtonTest() {
        Intents.init();
        onView(withId(R.id.btnStadium)).perform(click());
        intended(hasComponent(StadiumActivity.class.getName()));
        Intents.release();
    }

    @Test
    public void ScoreButtonTest() {
        Intents.init();
        onView(withId(R.id.btnScore)).perform(click());
        intended(hasComponent(Score.class.getName()));
        Intents.release();
    }

    @Test
    public void MapButtonTest() {
        Intents.init();
        onView(withId(R.id.btnMap)).perform(click());
        intended(hasComponent(MapsActivity.class.getName()));
        Intents.release();
    }


    @Test
    public void AchievementButtonTest() {
        Intents.init();
        onView(withId(R.id.btnAchievement)).perform(click());
        intended(hasComponent(Achievement.class.getName()));
        Intents.release();
    }

    @Test
    public void HowToUseButtonTest() {
        Intents.init();
        onView(withId(R.id.btnHelp)).perform(click());
        intended(hasComponent(HelpActivity.class.getName()));
        Intents.release();

    }
    @Test
    public void ScoreShareButtonTest(){
        Intents.init();
        onView(withId(R.id.btnScore)).perform(click());
        onView(withId(R.id.btnShare)).perform(click());


        intended(
                hasAction(Intent.ACTION_CHOOSER)
        );
        Intents.release();
    }
}
