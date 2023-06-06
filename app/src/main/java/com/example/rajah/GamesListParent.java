package com.example.rajah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GamesListParent extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_list_parent);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.game);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.podcat:
                        startActivity(new Intent(getApplicationContext(),PodCastListParent.class));
                        overridePendingTransition(0,0);
                    case R.id.game:
                        // Handle item 2 selection
                        return true;
                    // Handle other items as needed
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),ProfileParent.class));
                        overridePendingTransition(0,0);
                }
                return false;
            }
        });

    }
}