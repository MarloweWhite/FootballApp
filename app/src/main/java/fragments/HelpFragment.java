package fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.c1733667.team10_football_app.R;
import com.example.c1733667.team10_football_app.activities.HelpActivity;
import com.example.c1733667.team10_football_app.classpack.ThemeSetting;

import java.util.Map;

public class HelpFragment extends Fragment implements AdapterView.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_help, container, false);

        SharedPreferences pref1 = getActivity().getSharedPreferences("High contrast", 0);
        /*ThemeSetting helpSetting = new ThemeSetting(pref1, (AppCompatActivity) getActivity());
        helpSetting.setHighContrast(R.layout.activity_help_outer);*/

        TextView aboutTheApp = (TextView) v.findViewById(R.id.aboutTheApp);
        TextView help = (TextView) v.findViewById(R.id.howToUse);
        aboutTheApp.setText("About the app:\n\nOur app is an app designed to help its users keep track of all the football stadiums that they have visited throughout the UK\n");
        help.setText("How To Use:\n\nAdding Stadiums:\nTo add stadiums that you've visited, simply press the \"Stadiums\" button from the home screen and then select the league that the satdium is associated with.\nThen simply tap the name of a stadium to tick it, or long press it to view more information\n");

        Map map = pref1.getAll();
        if (map.size() > 0) {
            for (Object key : map.keySet()) {
                if (map.get(String.valueOf(R.id.highContrast)) != null
                        && map.get(String.valueOf(R.id.highContrast)).equals(true)) {
                    aboutTheApp.setBackgroundColor(Color.BLUE);
                    help.setBackgroundColor(Color.BLUE);
                } else {
                    aboutTheApp.setBackgroundColor(Color.WHITE);
                    help.setBackgroundColor(Color.WHITE);
                }
            }
        }

        return v;
    }


    @Override
    public void onClick(View v) {

    }
}