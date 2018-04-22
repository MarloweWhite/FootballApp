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

    public ThemeSetting(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void setHighContrast(int contentView) {
        Map map = sharedPreferences.getAll();
        for (Object key : map.keySet()) {
            if (map.get(String.valueOf(R.id.highContrast)).equals(true)) {
                setTheme(R.style.HighContrastTheme);
                setContentView(contentView);
            }else {
                setTheme(R.style.AppTheme);
                setContentView(contentView);
            }
            if (map.get(String.valueOf(R.id.smallcheckbox)).equals(true)){
                setTheme(R.style.smallText);
            }
            if (map.get(String.valueOf(R.id.mediumcheckbox)).equals(true)){
                setTheme(R.style.mediumText);
            }
            if (map.get(String.valueOf(R.id.largecheckbox)).equals(true)){
                setTheme(R.style.largeText);
            }
        }
    }
}
