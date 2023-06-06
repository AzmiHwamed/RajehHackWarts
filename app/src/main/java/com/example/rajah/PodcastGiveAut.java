package com.example.rajah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PodcastGiveAut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podcast_give_aut);
        Button done=findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PodcastGiveAut.this, "Authorisation Given\nالموافقة منحت بنجاح  ", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),PodCastListParent.class));
            }
        });
    }
}