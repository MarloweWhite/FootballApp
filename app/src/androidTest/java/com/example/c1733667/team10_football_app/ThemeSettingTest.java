package com.example.c1733667.team10_football_app;

import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.CheckBox;

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

import static android.provider.Settings.System.getString;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.actionWithAssertions;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by c1733667 on 30/04/2018.
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class ThemeSettingTest {
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
        infoActivity = infoActivityActivityTestRule.getActivity();
    }

    @Test
    public void ContrastCheckboxTest() {
        onView(withContentDescription(R.string.open)).perform(click());
        onView(withText("Settings")).perform(click());
        ViewInteraction contrast = onView(withId(R.id.highContrast));
        contrast.check(matches(isClickable()));
    }
}
