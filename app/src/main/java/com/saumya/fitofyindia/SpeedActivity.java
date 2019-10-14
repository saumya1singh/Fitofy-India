package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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


        buttonTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* on pressing the button whistle sound will start , timer will also start */


            }
        });

    }
}
