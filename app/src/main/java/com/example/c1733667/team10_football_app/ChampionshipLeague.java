package com.example.c1733667.team10_football_app;

import android.content.Intent;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class ChampionshipLeague extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] championLeague;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_championship_league);

        ArrayAdapter<String> championAdapter;
        championLeague = getResources().getStringArray(R.array.EFLC);
        championAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, championLeague);
        ListViewCompat lv = findViewById(R.id.championList);
        lv.setAdapter(championAdapter);
        lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, String.format("Item clicked on = %d", position), Toast.LENGTH_SHORT).show();
//        intent = new Intent(getApplicationContext(),InfoActivity.class);
//        intent.putExtra("Club Name", championLeague[position]);
    }
}
