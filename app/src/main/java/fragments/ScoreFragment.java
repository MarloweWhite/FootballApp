package fragments;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.c1733667.team10_football_app.R;
import com.example.c1733667.team10_football_app.activities.Score;
import com.example.c1733667.team10_football_app.classpack.ScoreSystem;
import com.example.c1733667.team10_football_app.classpack.ThemeSetting;

public class ScoreFragment extends Fragment {

    private Button btnShare;
    private int totalStadiumsVisited;
    private Intent shareIntent = new Intent(Intent.ACTION_SEND);
    ProgressBar mprogressBar;
    ProgressBar mprogressBar2;
    ProgressBar mprogressBar3;
    ProgressBar mprogressBar4;
    ProgressBar mprogressBar5;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_score, container, false);



        SharedPreferences championPreference = getActivity().getSharedPreferences("ChampionPreference", 0);
        SharedPreferences premierPreference = getActivity().getSharedPreferences("PremierPreference", 0);
        SharedPreferences leagueOnePreference = getActivity().getSharedPreferences("LeagueOnePreference", 0);
        SharedPreferences leagueTwoPreference = getActivity().getSharedPreferences("LeagueTwoPreference", 0);

        ScoreSystem scoreSystem = new ScoreSystem(championPreference, premierPreference, leagueOnePreference, leagueTwoPreference);

        int championsLeagueStadiumsVisited = scoreSystem.getChampionsLeagueStadiumsVisited();
        int premierLeagueStadiumsVisited = scoreSystem.getPremierLeagueStadiumsVisited();
        int leagueOneStadiumsVisited = scoreSystem.getLeagueOneStadiumsVisited();
        int leagueTwoStadiumsVisited = scoreSystem.getLeagueTwoStadiumsVisited();
        long totalPercentageOfStadiumsVisited = scoreSystem.getTotalPercentageOfStadiumsVisited();
        totalStadiumsVisited = scoreSystem.getTotalStadiumsVisited();


        TextView textView = (TextView) v.findViewById(R.id.textViewName);
        textView.setText("Your percentage of clubs you have been too :" + totalPercentageOfStadiumsVisited + "%");
        TextView textView2 = (TextView) v.findViewById(R.id.textViewName2);
        textView2.setText("Your Score is :" + totalStadiumsVisited);
        TextView textView3 = (TextView) v.findViewById(R.id.championsleagueperc);
        textView3.setText(championsLeagueStadiumsVisited + "/24");

        TextView textView4 = (TextView) v.findViewById(R.id.premierleagueperc);
        textView4.setText(premierLeagueStadiumsVisited + "/20");
        TextView textView5 = (TextView) v.findViewById(R.id.leagueoneperc);
        textView5.setText(leagueOneStadiumsVisited + "/24");
        TextView textView6 = (TextView) v.findViewById(R.id.leaguetwoperc);
        textView6.setText(leagueTwoStadiumsVisited + "/24");


        mprogressBar = (ProgressBar) v.findViewById(R.id.circular_progress_bar);
        ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "progress", 0, championsLeagueStadiumsVisited);
        anim.setDuration(850);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.start();

        mprogressBar2 = (ProgressBar) v.findViewById(R.id.circular_progress_bar2);
        ObjectAnimator anim2 = ObjectAnimator.ofInt(mprogressBar2, "progress", 0, premierLeagueStadiumsVisited);
        anim2.setDuration(850);
        anim2.setInterpolator(new DecelerateInterpolator());
        anim2.start();

        mprogressBar3 = (ProgressBar) v.findViewById(R.id.circular_progress_bar3);
        ObjectAnimator anim3 = ObjectAnimator.ofInt(mprogressBar3, "progress", 0, leagueOneStadiumsVisited);
        anim3.setDuration(850);
        anim3.setInterpolator(new DecelerateInterpolator());
        anim3.start();

        mprogressBar4 = (ProgressBar) v.findViewById(R.id.circular_progress_bar4);
        ObjectAnimator anim4 = ObjectAnimator.ofInt(mprogressBar4, "progress", 0, leagueTwoStadiumsVisited);
        anim4.setDuration(850);
        anim4.setInterpolator(new DecelerateInterpolator());
        anim4.start();

        mprogressBar5 = (ProgressBar) v.findViewById(R.id.progress_bar);
        ObjectAnimator anim5 = ObjectAnimator.ofInt(mprogressBar5, "progress", 0, totalStadiumsVisited);
        anim5.setDuration(850);
        anim5.setInterpolator(new DecelerateInterpolator());
        anim5.start();

        btnShare = v.findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareContent = ("I have visited " + totalStadiumsVisited + " out of the 92 football stadiums in the UK!\nHow many have you visited?");
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareContent);

                startActivity(Intent.createChooser(shareIntent, "Share via:"));
            }


        });

        return v;


    }


}

