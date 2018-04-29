package fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
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
import com.example.c1733667.team10_football_app.activities.InfoActivity;
import com.example.c1733667.team10_football_app.activities.PremierLeague;
import com.example.c1733667.team10_football_app.classpack.ListViewClass;
import com.example.c1733667.team10_football_app.classpack.ThemeSetting;

import java.util.Map;

public class PremierLeagueFragment extends Fragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private String[] premierLeague;
    private SharedPreferences sharedPreferences;
    private ListViewCompat lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_score, container, false);

        SharedPreferences pref1 = getActivity().getSharedPreferences("High contrast", 0);
        ThemeSetting premiereSetting = new ThemeSetting(pref1,  getActivity());
        premiereSetting.setHighContrast(R.layout.activity_premier_league_outer);

        sharedPreferences = getActivity().getSharedPreferences("PremierPreference", Context.MODE_PRIVATE);

        ArrayAdapter<String> premierAdapter;
        premierLeague = getResources().getStringArray(R.array.PremierLeagueTeams);
        premierAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_multiple_choice, premierLeague);
        lv = v.findViewById(R.id.premierList);
        lv.setChoiceMode(ListViewCompat.CHOICE_MODE_MULTIPLE);

        ListViewClass listViewClass = new ListViewClass(pref1,  getActivity());
        listViewClass.setListView(R.id.premierList, premierAdapter);
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);

        Map map = sharedPreferences.getAll();
        for (Object key : map.keySet()) {
            lv.setItemChecked(Integer.valueOf((String) key), (Boolean) map.get((String) key));
        }


        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), String.format("Item clicked on = %d", position), Toast.LENGTH_SHORT).show();

        SparseBooleanArray checkeditems = lv.getCheckedItemPositions();
        sharedPreferences.edit().putBoolean(String.valueOf(position), checkeditems.get(position)).commit();

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity().getApplicationContext(), InfoActivity.class);
        intent.putExtra("Club Name", premierLeague[position]);
        startActivity(intent);
        return true;
    }



}