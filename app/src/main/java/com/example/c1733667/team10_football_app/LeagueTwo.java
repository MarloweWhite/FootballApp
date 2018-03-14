package com.example.c1733667.team10_football_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class LeagueTwo extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] leagueTwo;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_two);

        ArrayAdapter<String> leagueTwoAdapter;
        leagueTwo = getResources().getStringArray(R.array.EFL2);
        leagueTwoAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,leagueTwo);
        ListViewCompat lv = findViewById(R.id.leagueTwoList);
        lv.setAdapter(leagueTwoAdapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, String.format("Item clicked on = %d", position), Toast.LENGTH_SHORT).show();
        intent = new Intent(getApplicationContext(), InfoActivity.class);
        intent.putExtra("Club Name", leagueTwo[position]);
        startActivity(intent);
    }
}
