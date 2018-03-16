package com.example.c1733667.team10_football_app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import java.util.Scanner;

public class InfoActivity extends AppCompatActivity {
    private TextView clubInfo;
    private Intent intent;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        clubInfo = findViewById(R.id.clubName);
        toolbar = findViewById(R.id.infoToolbar);
        String clubFromOtherActivity = this.getIntent().getStringExtra("Club Name");
        if (clubFromOtherActivity != null) {
//            clubInfo.setText(clubFromOtherActivity);
            toolbar.setTitle(clubFromOtherActivity);
            getClubInfo();

        }
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
        clubInfo = (TextView) findViewById(R.id.clubName);
        String clubFromOtherActivity = this.getIntent().getStringExtra("Club Name");
        StringBuilder builder = new StringBuilder();
        try {
            JSONObject root = new JSONObject(json);
            JSONObject clubInfo = root.getJSONObject(clubFromOtherActivity);

            builder.append("Name: ")
                    .append(clubInfo.getString("club name"))
                    .append("\n")
                    .append("Stadium: ")
                    .append(clubInfo.getString("Stadium "))
                    .append("\n")
                    .append("Stadium Location: ")
                    .append(clubInfo.getString("Stadium Location"))
                    .append("\n")
                    .append("Stadium capacity: ")
                    .append(clubInfo.getString("Stadium capacity"))
                    .append("\n")
                    .append("Manager: ")
                    .append(clubInfo.getString("Manager"))
                    .append("\n")
                    .append("History: ")
                    .append(clubInfo.getString("History"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        clubInfo.setText(builder.toString());
    }

}
