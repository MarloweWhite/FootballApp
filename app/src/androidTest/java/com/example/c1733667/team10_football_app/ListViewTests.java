package com.example.c1733667.team10_football_app;

import android.content.Intent;
import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.proto.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.c1733667.team10_football_app.activities.Achievement;
import com.example.c1733667.team10_football_app.activities.ChampionshipLeague;
import com.example.c1733667.team10_football_app.activities.HelpActivity;
import com.example.c1733667.team10_football_app.activities.InfoActivity;
import com.example.c1733667.team10_football_app.activities.LeagueOne;
import com.example.c1733667.team10_football_app.activities.LeagueTwo;
import com.example.c1733667.team10_football_app.activities.MainActivity;
import com.example.c1733667.team10_football_app.activities.MapsActivity;
import com.example.c1733667.team10_football_app.activities.PremierLeague;
import com.example.c1733667.team10_football_app.activities.Score;
import com.example.c1733667.team10_football_app.activities.StadiumActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by c1733667 on 30/04/2018.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ListViewTests {
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
    public void StadiumListviewPemierLeagueCheck() {
        Intents.init();
        onView(withId(R.id.btnStadium)).perform(click());

        DataInteraction a = onData(anything())
                .inAdapterView(withId(R.id.list_view))
                .atPosition(0);
        a.perform(click());

        intended(hasComponent(PremierLeague.class.getName()));
        Intents.release();
    }

    @Test
    public void StadiumListViewChampionLeagueCheck() {
        Intents.init();
        onView(withId(R.id.btnStadium)).perform(click());
        DataInteraction b = onData(anything())
                .inAdapterView(withId(R.id.list_view))
                .atPosition(1);
        b.perform(click());
        intended(hasComponent(ChampionshipLeague.class.getName()));
        Intents.release();
    }

    @Test
    public void StadiumListViewLeaugeOneCheck() {
        Intents.init();
        onView(withId(R.id.btnStadium)).perform(click());
        DataInteraction c = onData(anything())
                .inAdapterView(withId(R.id.list_view))
                .atPosition(2);
        c.perform(click());
        intended(hasComponent(LeagueOne.class.getName()));
        Intents.release();
    }

    @Test
    public void StadiumListViewLeagueTwo() {
        Intents.init();
        onView(withId(R.id.btnStadium)).perform(click());
        DataInteraction d = onData(anything())
                .inAdapterView(withId(R.id.list_view))
                .atPosition(3);
        d.perform(click());
        intended(hasComponent(LeagueTwo.class.getName()));
        Intents.release();
    }

    @Test
    public void ClubListViewLongClickTest() {
        Intents.init();
        onView(withId(R.id.btnStadium)).perform(click());
        DataInteraction a = onData(anything())
                .inAdapterView(withId(R.id.list_view))
                .atPosition(0);
        a.perform(click());
        DataInteraction b = onData(anything())
                .inAdapterView(withId(R.id.premierList))
                .atPosition(0);
        b.perform(longClick());
        intended(hasComponent(InfoActivity.class.getName()));
        Intents.release();
    }

//    @Test
//    public void ClubListViewClickTest() {
//        onView(withId(R.id.btnStadium)).perform(click());
//
//        DataInteraction a = onData(anything())
//                .inAdapterView(withId(R.id.list_view))
//                .atPosition(0);
//
//        a.perform(click());
//        DataInteraction b = onData(anything())
//                .inAdapterView(withId(R.id.premierList))
//                .atPosition(0);
//        Log.d("Test", String.valueOf(onData(anything())
//                .inAdapterView(withId(R.id.premierList)).getClass()));
//
//        b.perform(click());
//
//        b.check(matches(isChecked()));
//    }
}
