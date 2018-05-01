package com.example.c1733667.team10_football_app;

import android.app.Fragment;
import android.view.View;
import android.widget.RelativeLayout;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Rule
    public ActivityTestRule<TestActivity> mActivityTestRule = new ActivityTestRule<TestActivity>(TestActivity.class);

    private TestActivity mActivity = null;


    @Before
    public void setUp() throws Exception{
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        RelativeLayout rlContainer = mActivity.findViewById(R.id.test_container);
        assertNotNull(rlContainer);

        FragmentToTest fragment = new FragmentToTest();

        mActivity.getFragmentManager().beginTransaction().add(rlContainer.getId(), new fragment).commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();



        View view = fragment.getView().findViewById(R.id.view_in.fragment);

        assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception{
        mActivity =  null;

        mActivity = null;
    }

}

*/