package com.example.c1733667.team10_football_app.classpack;

import android.app.Activity;
import android.content.SharedPreferences;

import com.example.c1733667.team10_football_app.R;
import com.example.c1733667.team10_football_app.activities.MainActivity;

import java.util.Map;

/**
 * Created by c1733667 on 22/04/2018.
 */

public class ThemeSetting extends Activity {
    private SharedPreferences sharedPreferences;
    private Activity activity;

    public ThemeSetting(SharedPreferences sharedPreferences, Activity activity) {
        this.sharedPreferences = sharedPreferences;
        this.activity = activity;
    }

    public void setHighContrast(int contentView) {
        Map map = sharedPreferences.getAll();
        for (Object key : map.keySet()) {
            if (map.get(String.valueOf(R.id.highContrast)).equals(true)) {
                activity.setTheme(R.style.HighContrastTheme);
                activity.setContentView(contentView);
            }else {
                activity.setTheme(R.style.AppTheme);
                activity.setContentView(contentView);
            }
            if (map.get(String.valueOf(R.id.smallcheckbox)).equals(true)){
                setTheme(R.style.smallText);
            }
            if (map.get(String.valueOf(R.id.mediumcheckbox)).equals(true)){
                activity.setTheme(R.style.mediumText);
            }
            if (map.get(String.valueOf(R.id.largecheckbox)).equals(true)){
                activity.setTheme(R.style.largeText);
            }
        }
    }
}
