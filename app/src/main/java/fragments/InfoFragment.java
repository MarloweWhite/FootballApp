package fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.c1733667.team10_football_app.R;
import com.example.c1733667.team10_football_app.activities.InfoActivity;
import com.example.c1733667.team10_football_app.classpack.ThemeSetting;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

public class InfoFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
private TextView clubInfo;
private TextView clubName;
private TextView clubStadium;
private TextView clubLocation;
private Intent intent;
private Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info, container, false);

        SharedPreferences pref1 = getActivity().getSharedPreferences("High contrast", 0);
        ThemeSetting infoSetting = new ThemeSetting(pref1,InfoActivity.this);
        infoSetting.setHighContrast(R.layout.activity_info_outer);

        clubInfo = v.findViewById(R.id.clubName);
        clubLocation = v.findViewById(R.id.clubLocation);
        toolbar = v.findViewById(R.id.my_toolbar);
        String clubFromOtherActivity = this.getActivity().getIntent().getStringExtra("Club Name");
        if (clubFromOtherActivity != null) {
            toolbar.setTitle(clubFromOtherActivity);
            getClubInfo();
        }
        clubLocation.setOnClickListener(this);


        Map map = pref1.getAll();
        if (map.size() > 0) {
            for (Object key : map.keySet()) {
                if (map.get(String.valueOf(R.id.highContrast)) != null
                        && map.get(String.valueOf(R.id.highContrast)).equals(true)) {
                    clubInfo.setBackgroundColor(Color.BLUE);
                    clubLocation.setBackgroundColor(Color.BLUE);
                    clubName.setBackgroundColor(Color.BLUE);
                    clubStadium.setBackgroundColor(Color.BLUE);
                } else {
                    clubInfo.setBackgroundColor(Color.WHITE);
                    clubLocation.setBackgroundColor(Color.WHITE);
                    clubName.setBackgroundColor(Color.WHITE);
                    clubStadium.setBackgroundColor(Color.WHITE);
                }
            }
        }


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
        clubInfo = (TextView) findViewById(R.id.clubInfo);
        clubName = (TextView) findViewById(R.id.clubName);
        clubLocation = (TextView) findViewById(R.id.clubLocation);
        clubStadium = (TextView) findViewById(R.id.clubStadium);

        String clubFromOtherActivity = this.getActivity().getIntent().getStringExtra("Club Name");
        StringBuilder info = new StringBuilder();
        StringBuilder name = new StringBuilder();
        StringBuilder location = new StringBuilder();
        StringBuilder stadium = new StringBuilder();

        try {
            JSONObject root = new JSONObject(json);
            JSONObject clubInfo = root.getJSONObject(clubFromOtherActivity);

            info.append("Stadium capacity: ")
                    .append(clubInfo.getString("Stadium capacity"))
                    .append("\n")
                    .append("Manager: ")
                    .append(clubInfo.getString("Manager"))
                    .append("\n")
                    .append("History: ")
                    .append(clubInfo.getString("History"));
            name.append("Name: ")
                    .append(clubInfo.getString("club name"));
            location.append("Location: ")
                    .append(clubInfo.getString("Stadium Location"));
            stadium.append("Stadium: ")
                    .append(clubInfo.getString("Stadium "));


        } catch (JSONException e) {
            e.printStackTrace();
        }

        clubInfo.setText(info.toString());
        clubName.setText(name.toString());
        clubLocation.setText(location.toString());
        clubStadium.setText(stadium.toString());
    }


    @Override
    public void onClick(View v) {
        String str = clubName.getText().toString();
        String[] location = str.split(" ", 2);
        Uri gmmIntentUri = Uri.parse("geo:51.488762, -3.174134?q=" + location[1].toString() + " " + "Football Stadium");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}