package com.example.c1733667.team10_football_app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView clubInfo;
    private TextView clubName;
    private TextView clubStadium;
    private TextView clubLocation;
    private Intent intent;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        clubInfo = findViewById(R.id.clubName);
        clubLocation = findViewById(R.id.clubLocation);
        toolbar = findViewById(R.id.infoToolbar);
        String clubFromOtherActivity = this.getIntent().getStringExtra("Club Name");
        if (clubFromOtherActivity != null) {
            toolbar.setTitle(clubFromOtherActivity);
            getClubInfo();
        }
        clubLocation.setOnClickListener(this);
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
        clubInfo = (TextView) findViewById(R.id.clubInfo);
        clubName = (TextView) findViewById(R.id.clubName);
        clubLocation = (TextView) findViewById(R.id.clubLocation);
        clubStadium = (TextView) findViewById(R.id.clubStadium);

        String clubFromOtherActivity = this.getIntent().getStringExtra("Club Name");
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
        String[] location = str.split(" ",2);
            Uri gmmIntentUri = Uri.parse("geo:51.488762, -3.174134?q=" + location[1].toString()+" "+"Football Stadium");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}

