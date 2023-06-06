package com.example.rajah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PodCastListParent extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pod_cast_list_parent);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.podcat);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.podcat:
                        return true;
                    case R.id.game:
                        startActivity(new Intent(getApplicationContext(),GamesListParent.class));
                        overridePendingTransition(0,0);
                        return true;
                        // Handle other items as needed
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),ProfileParent.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        Button btnu=findViewById(R.id.btnunlock);
        Button btnp=findViewById(R.id.btnplay);
        btnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PodcastGiveAut.class));
            }
        });
        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PodcastParent.class));
            }
        });

    }
}