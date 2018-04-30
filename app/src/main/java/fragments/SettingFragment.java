package fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.c1733667.team10_football_app.R;
import com.example.c1733667.team10_football_app.activities.SettingActivity;
import com.example.c1733667.team10_football_app.classpack.ThemeSetting;

import java.util.Map;

public class SettingFragment extends Fragment {

    private DrawerLayout navDrawer;
    private NavigationView navView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setting, container, false);


        SharedPreferences pref1 = getActivity().getSharedPreferences("High contrast", 0);
        /*if (pref1 != null) {
            ThemeSetting settingTheme = new ThemeSetting(pref1, (AppCompatActivity) getActivity());
            settingTheme.setHighContrast(R.layout.activity_setting_outer);
        }*/


        TextView highContrastTitle = v.findViewById(R.id.highContrastTitle);
        TextView textSize = v.findViewById(R.id.textSizeSetting);

        CheckBox HighContrastcheckBox = v.findViewById(R.id.highContrast);
        HighContrastcheckBox.setChecked(getActivity().getSharedPreferences("High contrast",
                Context.MODE_PRIVATE)
                .getBoolean(String.valueOf(R.id.highContrast),
                        false));

        CheckBox smallTextCheckBox = v.findViewById(R.id.smallcheckbox);
        smallTextCheckBox.setChecked(getActivity().getSharedPreferences("High contrast",
                Context.MODE_PRIVATE)
                .getBoolean(String.valueOf(R.id.smallcheckbox),
                        false));

        CheckBox mediumTextCheckBox = v.findViewById(R.id.mediumcheckbox);
        mediumTextCheckBox.setChecked(getActivity().getSharedPreferences("High contrast",
                Context.MODE_PRIVATE)
                .getBoolean(String.valueOf(R.id.mediumcheckbox),
                        false));

        CheckBox largeTextCheckBox = v.findViewById(R.id.largecheckbox);
        largeTextCheckBox.setChecked(getActivity().getSharedPreferences("High contrast",
                Context.MODE_PRIVATE)
                .getBoolean(String.valueOf(R.id.largecheckbox),
                        false));

        Map map = pref1.getAll();
        if (map.size() > 0) {
            for (Object key : map.keySet()) {
                if (map.get(String.valueOf(R.id.highContrast)) != null
                        && map.get(String.valueOf(R.id.highContrast)).equals(true)) {
                    highContrastTitle.setBackgroundColor(Color.BLUE);
                    textSize.setBackgroundColor(Color.BLUE);
                    HighContrastcheckBox.setBackgroundColor(Color.BLUE);
                    smallTextCheckBox.setBackgroundColor(Color.BLUE);
                    mediumTextCheckBox.setBackgroundColor(Color.BLUE);
                    largeTextCheckBox.setBackgroundColor(Color.BLUE);
                } else {
                    highContrastTitle.setBackgroundColor(Color.WHITE);
                    textSize.setBackgroundColor(Color.WHITE);
                    HighContrastcheckBox.setBackgroundColor(Color.WHITE);
                    smallTextCheckBox.setBackgroundColor(Color.WHITE);
                    mediumTextCheckBox.setBackgroundColor(Color.WHITE);
                    largeTextCheckBox.setBackgroundColor(Color.WHITE);
                }
            }
        }


        return v;
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        SharedPreferences sharedPreference = getActivity().getSharedPreferences("High contrast", Context.MODE_PRIVATE);
        switch (view.getId()) {
            case R.id.highContrast:
                sharedPreference.edit().putBoolean(String.valueOf(R.id.highContrast), checked).commit();
                Intent intent = new Intent(getActivity().getBaseContext(), SettingActivity.class);
                intent.putExtra("CHECK_BOX", checked);
                Log.d("CheckBox", String.valueOf(checked));
                getActivity().finish();
                startActivity(intent);
                break;
            case R.id.smallcheckbox:
                sharedPreference.edit().putBoolean(String.valueOf(R.id.smallcheckbox), checked).commit();
                Intent smallIntent = new Intent(getActivity().getBaseContext(), SettingActivity.class);
                smallIntent.putExtra("SMALL_CHECK", checked);
                getActivity().finish();
                startActivity(smallIntent);
                break;
            case R.id.mediumcheckbox:
                sharedPreference.edit().putBoolean(String.valueOf(R.id.mediumcheckbox), checked).commit();
                Intent mediumIntent = new Intent(getActivity().getBaseContext(), SettingActivity.class);
                mediumIntent.putExtra("MEDIUM_CHECK", checked);
                getActivity().finish();
                startActivity(mediumIntent);
                break;
            case R.id.largecheckbox:
                sharedPreference.edit().putBoolean(String.valueOf(R.id.largecheckbox), checked).commit();
                Intent largeIntent = new Intent(getActivity().getBaseContext(), SettingActivity.class);
                largeIntent.putExtra("LARGE_CHECK", checked);
                getActivity().finish();
                startActivity(largeIntent);
        }
    }

    


}
