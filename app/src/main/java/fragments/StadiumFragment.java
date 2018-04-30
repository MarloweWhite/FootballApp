package fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ListViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.c1733667.team10_football_app.R;
import com.example.c1733667.team10_football_app.classpack.LeagueSelector;
import com.example.c1733667.team10_football_app.classpack.ListViewClass;


/**
 * Created by c1722696 on 4/23/2018.
 */

public class StadiumFragment extends Fragment  implements AdapterView.OnItemClickListener {
    private Intent intent;
    private String[] leaugueArray;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stadium, container, false);

        SharedPreferences pref1 = getActivity().getSharedPreferences("High contrast", 0);
        /*ThemeSetting stadiumSetting = new ThemeSetting(pref1, (AppCompatActivity) getActivity());
        stadiumSetting.setHighContrast(R.layout.activity_stadium_outer);*/

        ArrayAdapter<String> adapter;
        leaugueArray = getResources().getStringArray(R.array.football_leagues);

        System.out.println(leaugueArray.length);

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, leaugueArray);

        ListViewCompat listViewCompat = v.findViewById(R.id.list_view);
//        lv.setAdapter(adapter);
        // TODO: 25/04/2018 make listview a seperate class
//        Map map = pref1.getAll();
//        if (map.get(String.valueOf(R.id.highContrast)) !=null
//                && map.get(String.valueOf(R.id.highContrast)).equals(true)) {
//            lv.setBackgroundColor(Color.BLUE);
//        }else {
//            lv.setBackgroundColor(Color.WHITE);
//        }
//
        ListViewClass.setListViewTheme(listViewCompat, pref1);

        listViewCompat.setAdapter(adapter);
        //ListViewClass lv = new ListViewClass(pref1,  (AppCompatActivity) getActivity());
        //lv.setListView(R.id.list_view, adapter);

        listViewCompat.setOnItemClickListener(this);


        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), String.format("Item clicked on = %d", position), Toast.LENGTH_SHORT).show();


        switch (position) {
            case 0:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new PremierLeagueFragment())
                        .addToBackStack("prem")
                        .commit();

                break;
            case 1:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new ChampionsLeagueFragment())
                        .addToBackStack("prem")
                        .commit();
                ;
                break;
            case 2:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new LeagueOneFragment())
                        .addToBackStack("prem")
                        .commit();
                ;
                break;
            case 3:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new LeagueTwoFragment())
                        .addToBackStack("prem")
                        .commit();
                break;
        }

        //LeagueSelector selector = new LeagueSelector(position);
        //selector.selectLeague(position, getContext());

            //TODO change fragment instead
        }

}
