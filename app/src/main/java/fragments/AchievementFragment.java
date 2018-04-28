package fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.c1733667.team10_football_app.R;
import com.example.c1733667.team10_football_app.activities.Achievement;
import com.example.c1733667.team10_football_app.activities.AchievemntInfo;
import com.example.c1733667.team10_football_app.adapterpack.AchievementCustomAdapter;
import com.example.c1733667.team10_football_app.classpack.ListViewClass;
import com.example.c1733667.team10_football_app.classpack.ThemeSetting;


/**
 * Created by c1722696 on 4/23/2018.
 */

public class AchievementFragment extends Fragment implements AdapterView.OnItemClickListener {
private ListView listView;
private String[] achievements;
private Integer[] imageID;
private DrawerLayout navDrawer;
private NavigationView navView;
private Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_achievement, container, false);

        SharedPreferences pref1 = getActivity().getSharedPreferences("High contrast", 0);
        ThemeSetting achievementSetting = new ThemeSetting(pref1, Achievement.this);
        achievementSetting.setHighContrast(R.layout.activity_achievement_outer);

        FragmentManager fragmentManager = this.getFragmentManager();

        /*FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.achievement_container, new AchievementFragment());
        fragmentTransaction.commit();*/


        achievements = getResources().getStringArray(R.array.achievements);
        listView = (ListView) v.findViewById(R.id.achievementList);
        AchievementCustomAdapter customAdapter = new AchievementCustomAdapter(getActivity(), achievements, imageID);
        ListViewClass listViewClass = new ListViewClass(pref1,Achievement.this);
        listViewClass.setListView(R.id.achievementList,customAdapter);
        listView.setOnItemClickListener(this);

        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        intent = new Intent(getActivity().getApplicationContext(), AchievemntInfo.class);
        intent.putExtra("AchievementLogic Name", achievements[position]);
        startActivity(intent);
    }

}
