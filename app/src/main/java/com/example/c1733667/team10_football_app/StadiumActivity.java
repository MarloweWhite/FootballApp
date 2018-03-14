package com.example.c1733667.team10_football_app;

import android.content.Intent;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StadiumActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] leaugueArray;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadium);

        ArrayAdapter<String> adapter;
        leaugueArray = getResources().getStringArray(R.array.football_leagues);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, leaugueArray);

        ListViewCompat lv = findViewById(R.id.list_view);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, String.format("Item clicked on = %d", position), Toast.LENGTH_SHORT).show();
        if (position==0){
            intent=new Intent(getApplicationContext(),PremierLeague.class);
            startActivity(intent);
        }
        if(position==1){
            intent = new Intent(getApplicationContext(),ChampionshipLeague.class);
            startActivity(intent);
        }
    }
}

