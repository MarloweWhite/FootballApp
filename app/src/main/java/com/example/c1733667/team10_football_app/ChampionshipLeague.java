package com.example.c1733667.team10_football_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.Map;

public class ChampionshipLeague extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private String[] championLeague;
    private Intent intent;
    private SharedPreferences sharedPreferences;
    private ListViewCompat lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_championship_league);

        sharedPreferences = getSharedPreferences("ChampionPreference", Context.MODE_PRIVATE);

        ArrayAdapter<String> championAdapter;
        championLeague = getResources().getStringArray(R.array.EFLC);
        championAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, championLeague);
        lv = findViewById(R.id.championList);
        lv.setChoiceMode(ListViewCompat.CHOICE_MODE_MULTIPLE);
        lv.setAdapter(championAdapter);
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);

        Map map = sharedPreferences.getAll();
        for(Object key : map.keySet()){
            lv.setItemChecked(Integer.valueOf((String) key), (Boolean) map.get((String) key));
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, String.format("Item clicked on = %d", position), Toast.LENGTH_SHORT).show();

        SparseBooleanArray checkeditems = lv.getCheckedItemPositions();
        sharedPreferences.edit().putBoolean(String.valueOf(position), checkeditems.get(position)).commit();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        intent = new Intent(getApplicationContext(),InfoActivity.class);
        intent.putExtra("Club Name", championLeague[position]);
        startActivity(intent);
        return true;
    }
}
