package com.example.c1733667.team10_football_app;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.google.android.gms.location.places.PlaceReport;
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
import java.util.Scanner;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String[] championLeague;
    private ArrayList<LatLng> visitedClubs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        visitedClubs = new ArrayList<>();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        championLeague = getResources().getStringArray(R.array.EFLC);
        getClubInfo();
    }

    public void getClubInfo() {
        Resources res = getResources();
        InputStream is = res.openRawResource(R.raw.championleague);
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
                double latitude = visitedChampionClub.getDouble("Latitude");
                double longitude = visitedChampionClub.getDouble("Longitude");
                LatLng location = new LatLng(latitude, longitude);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        LatLng BRISBANE = new LatLng(-27.47093, 153.0235);
        LatLng defaultMap = new LatLng(53.956086, -0.252686);
        for (int i = 0; i < visitedClubs.size(); i++) {
            mMap.addMarker(new MarkerOptions().position(visitedClubs.get(i)));
        }
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultMap, 5));
    }
}
