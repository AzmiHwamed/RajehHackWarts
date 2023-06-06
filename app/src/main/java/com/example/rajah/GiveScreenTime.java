package com.example.rajah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GiveScreenTime extends AppCompatActivity {
    int value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_screen_time);
        TextView valueTextView = findViewById(R.id.valueTextView);
        Button increaseButton = findViewById(R.id.increaseButton);
        Button decreaseButton = findViewById(R.id.decreaseButton);

        value = 0;

        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value++;
                valueTextView.setText(String.valueOf(value));
            }
        });

        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value>0)
                value--;
                valueTextView.setText(String.valueOf(value));
            }
        });
        Button done=findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GiveScreenTime.this, "Time Added successfully\nأضيف الوقت بنجاح   ", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),ProfileParent.class));
            }
        });
    }
}