package com.example.c1733667.team10_football_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class PremierLeague extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] premierLeague;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premier_league);

        ArrayAdapter<String> premierAdapter;
        premierLeague = getResources().getStringArray(R.array.PremierLeagueTeams);
        premierAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,premierLeague);
        ListViewCompat lv = findViewById(R.id.premierList);
        lv.setAdapter(premierAdapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, String.format("Item clicked on = %d", position), Toast.LENGTH_SHORT).show();
        intent = new Intent(getApplicationContext(),ChampionshipLeague.class);
        intent.putExtra("Club Name", premierLeague[position]);

        startActivity(intent);
    }
}
