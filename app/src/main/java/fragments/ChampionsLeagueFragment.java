package fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.c1733667.team10_football_app.R;
import com.example.c1733667.team10_football_app.activities.ChampionshipLeague;
import com.example.c1733667.team10_football_app.activities.InfoActivity;
import com.example.c1733667.team10_football_app.classpack.ListViewClass;
import com.example.c1733667.team10_football_app.classpack.ThemeSetting;

import java.util.Map;

public class ChampionsLeagueFragment extends Fragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private String[] championLeague;
    private Intent intent;
    private SharedPreferences sharedPreferences;
    private ListViewCompat listViewCompat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_champions_league, container, false);

        SharedPreferences pref1 = getActivity().getSharedPreferences("High contrast", 0);
        //ThemeSetting championSetting =new ThemeSetting(pref1, (AppCompatActivity) getActivity());
        //championSetting.setHighContrast(R.layout.activity_championship_league_outer);

        sharedPreferences = getActivity().getSharedPreferences("ChampionPreference", Context.MODE_PRIVATE);

        ArrayAdapter<String> championAdapter;
        championLeague = getResources().getStringArray(R.array.EFLC);
        championAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_multiple_choice, championLeague);
        listViewCompat = v.findViewById(R.id.championList);
        listViewCompat.setChoiceMode(ListViewCompat.CHOICE_MODE_MULTIPLE);

        ListViewClass.setListViewTheme(listViewCompat, sharedPreferences);
        listViewCompat.setAdapter(championAdapter);

        //ListViewClass lv = new ListViewClass(pref1, (AppCompatActivity) getActivity());
        //lv.setListView(R.id.championList, championAdapter);
        listViewCompat.setOnItemClickListener(this);
        listViewCompat.setOnItemLongClickListener(this);

        Map map = sharedPreferences.getAll();
        for (Object key : map.keySet()) {
            listViewCompat.setItemChecked(Integer.valueOf((String) key), (Boolean) map.get((String) key));
        }



        return v;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), String.format("Item clicked on = %d", position), Toast.LENGTH_SHORT).show();
        SparseBooleanArray checkeditems = listViewCompat.getCheckedItemPositions();
        sharedPreferences.edit().putBoolean(String.valueOf(position), checkeditems.get(position)).commit();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        intent = new Intent(getActivity().getApplicationContext(), InfoActivity.class);
        intent.putExtra("Club Name", championLeague[position]);
        startActivity(intent);
        return true;
    }
}