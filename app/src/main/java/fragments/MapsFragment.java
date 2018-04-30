package fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c1733667.team10_football_app.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MapsFragment extends Fragment {


    private GoogleMap mMap;
    private String[] championLeague;
    private String[] premierLeague;
    private String[] leagueOne;
    private String[] leagueTwo;
    private ArrayList<String> clubName;
    private ArrayList<LatLng> visitedClubs;
    private DrawerLayout navDrawer;
    private NavigationView navView;
    private SharedPreferences pref1;
    private SharedPreferences pref2;
    private SharedPreferences pref3;
    private SharedPreferences pref4;
    private Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_maps, container, false);

        SharedPreferences pref = getActivity().getSharedPreferences("High contrast", 0);

        visitedClubs = new ArrayList<>();
        clubName = new ArrayList<>();

        pref1 = getActivity().getSharedPreferences("ChampionPreference", 0);
        pref2 = getActivity().getSharedPreferences("PremierPreference", 0);
        pref3 = getActivity().getSharedPreferences("LeagueOnePreference", 0);
        pref4 = getActivity().getSharedPreferences("LeagueTwoPreference", 0);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        premierLeague = getResources().getStringArray(R.array.PremierLeagueTeams);
        championLeague = getResources().getStringArray(R.array.EFLC);
        leagueOne = getResources().getStringArray(R.array.EFL1);
        leagueTwo = getResources().getStringArray(R.array.EFL2);
        getClubInfo();

        return v;
    }


    public void getClubInfo() {
        Resources res = getResources();
        InputStream is = res.openRawResource(R.raw.clubs);
        Scanner scanner = new Scanner(is);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }
        parseJson(builder.toString());
    }

    private void parseJson(String json) {
        for (int i = 0; i < championLeague.length; i++) {
            try {
                JSONObject root = new JSONObject(json);
                JSONObject visitedChampionClub = root.getJSONObject(championLeague[i]);
                String name = visitedChampionClub.getString("club name");
                double latitude = visitedChampionClub.getDouble("Latitude");
                double longitude = visitedChampionClub.getDouble("Longitude");
                LatLng location = new LatLng(latitude, longitude);
                clubName.add(name);
                visitedClubs.add(location);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < premierLeague.length; i++) {
            try {
                JSONObject root = new JSONObject(json);
                JSONObject visitedChampionClub = root.getJSONObject(premierLeague[i]);
                String name = visitedChampionClub.getString("club name");
                double latitude = visitedChampionClub.getDouble("Latitude");
                double longitude = visitedChampionClub.getDouble("Longitude");
                LatLng location = new LatLng(latitude, longitude);
                clubName.add(name);
                visitedClubs.add(location);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < leagueOne.length; i++) {
            try {
                JSONObject root = new JSONObject(json);
                JSONObject visitedChampionClub = root.getJSONObject(leagueOne[i]);
                String name = visitedChampionClub.getString("club name");
                double latitude = visitedChampionClub.getDouble("Latitude");
                double longitude = visitedChampionClub.getDouble("Longitude");
                LatLng location = new LatLng(latitude, longitude);
                clubName.add(name);
                visitedClubs.add(location);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < leagueTwo.length; i++) {
            try {
                JSONObject root = new JSONObject(json);
                JSONObject visitedChampionClub = root.getJSONObject(leagueTwo[i]);
                String name = visitedChampionClub.getString("club name");
                double latitude = visitedChampionClub.getDouble("Latitude");
                double longitude = visitedChampionClub.getDouble("Longitude");
                LatLng location = new LatLng(latitude, longitude);
                clubName.add(name);
                visitedClubs.add(location);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


}
