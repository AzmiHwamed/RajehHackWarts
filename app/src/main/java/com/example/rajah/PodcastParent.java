package com.example.rajah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.os.Handler;
import android.widget.ProgressBar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class PodcastParent extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private MediaPlayer mediaPlayer;
    private ImageButton btn;
    private Handler handler;
    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podcast_parent);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.podcat);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.podcat:
                        return true;
                    case R.id.game:
                        startActivity(new Intent(getApplicationContext(),GamesListChild.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),ProfileParent.class));
                        overridePendingTransition(0,0);
                        return true;
                        // Handle other items as needed
                }
                return false;
            }
        });

        mediaPlayer = MediaPlayer.create(this, R.raw.audio);
        btn=findViewById(R.id.button_play);
        ProgressBar pb=findViewById(R.id.progress_bar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    // If audio is already playing, stop it
                    mediaPlayer.pause();
                    btn.setImageResource(R.drawable.ic_baseline_play_circle_24);
                } else {
                    // If audio is not playing, start playing
                    mediaPlayer.start();
                    btn.setImageResource(R.drawable.pause_24);
                }

            }
        });
        pb.setMax(mediaPlayer.getDuration()/1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        pb.setProgress(mediaPlayer.getCurrentPosition() / 1000);
                        wait(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        }).start();
        final ArrayList<NumbersView> arrayList = new ArrayList<NumbersView>();

        // add all the values from 1 to 15 to the arrayList
        // the items are of the type NumbersView
        for(int i=0;i<5;i++){
            arrayList.add(new NumbersView(R.drawable.child, "Kids And Sports" ,"الأطفال و رياضة "));
        }
        NumbersViewAdapter numbersArrayAdapter = new NumbersViewAdapter(this, arrayList);

        // create the instance of the ListView to set the numbersViewAdapter
        ListView numbersListView = findViewById(R.id.listrecomendation);

        // set the numbersViewAdapter for ListView
        numbersListView.setAdapter(numbersArrayAdapter);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),PodCastListParent.class));
        mediaPlayer.stop();
        mediaPlayer.reset();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onBackPressed();
        mediaPlayer.stop();
        mediaPlayer.reset();
    }

    @Override
    protected void onPause() {
        super.onPause();
        onBackPressed();
        mediaPlayer.stop();
        mediaPlayer.reset();
    }


}
