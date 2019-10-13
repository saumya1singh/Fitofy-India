package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SpeedActivity extends AppCompatActivity {


    TextView textViewTimer;
    Button buttonTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);
        textViewTimer = findViewById(R.id.textViewTimer);
        buttonTimer = findViewById(R.id.buttonTimer);

    }
}
