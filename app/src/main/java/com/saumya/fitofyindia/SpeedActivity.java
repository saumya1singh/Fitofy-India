package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpeedActivity extends AppCompatActivity {

    MediaPlayer md;
    TextView textViewTimer;
    Button buttonStartTimer,buttonStopTimer;
    CountDownTimer cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);
        textViewTimer = findViewById(R.id.textViewTimer);
        buttonStartTimer = findViewById(R.id.buttonStartTimer);
        buttonStopTimer = findViewById(R.id.buttonStopTimer);
        buttonStopTimer.setVisibility(View.GONE);

        md = new MediaPlayer();


        buttonStartTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                md = MediaPlayer.create(SpeedActivity.this, R.raw.whistle);
                md.start();

                cd = new CountDownTimer(100000000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                        textViewTimer.setText(""+millisUntilFinished);
                    }

                    @Override
                    public void onFinish() {

                    }
                };

                cd.start();
                buttonStartTimer.setVisibility(View.GONE);


                /* on pressing the button whistle sound will start , timer will also start */


            }
        });
        buttonStopTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                md = MediaPlayer.create(SpeedActivity.this, R.raw.whistle);
                md.start();
                cd.cancel();
            }
        });

    }
}
