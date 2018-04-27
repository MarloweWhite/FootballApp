package fragments;

import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;


import com.example.c1733667.team10_football_app.R;

public class ScoreFragment extends Fragment {

    ProgressBar mprogressBar;
    ProgressBar mprogressBar2;
    ProgressBar mprogressBar3;
    ProgressBar mprogressBar4;
    ProgressBar mprogressBar5;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_score, container, false);

        

        return v;
    }



}

