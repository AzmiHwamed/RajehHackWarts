package com.example.rajah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo=findViewById(R.id.logo);
        logo.animate().scaleXBy(0.8f).scaleYBy(0.8f).setDuration(2500).withEndAction(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
                if(sharedPreferences.getBoolean("first", true)){
                    sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("first", false);
                    editor.apply();
                    startActivity(new Intent(getApplicationContext(),Welcome.class));
                }
                else{
                    startActivity(new Intent(getApplicationContext(),Login.class));
                }
            }
        });

    }
}