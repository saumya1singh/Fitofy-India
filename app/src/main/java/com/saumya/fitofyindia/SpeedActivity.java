package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SpeedActivity extends AppCompatActivity {

    MediaPlayer md;
    TextView textViewTimer;
    Button buttonStartTimer,buttonStopTimer;
    CountDownTimer cd;

    EditText editTextDistance;
    int distance ;
    TextView textViewSpeed;
    SharedPreferences sharedPreferences;
    String organisation, className,secName,Name,Roll;
    int speed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);

        textViewTimer = findViewById(R.id.textViewTimer);
        buttonStartTimer = findViewById(R.id.buttonStartTimer);
        buttonStopTimer = findViewById(R.id.buttonStopTimer);
        editTextDistance = findViewById(R.id.editTextDistance);
        textViewSpeed = findViewById(R.id.textViewSpeed);
        buttonStopTimer.setVisibility(View.GONE);


        sharedPreferences = getSharedPreferences("Organisation", Context.MODE_PRIVATE);

        organisation = sharedPreferences.getString("OrgName", organisation);
        className = sharedPreferences.getString("Class",className);
        secName = sharedPreferences.getString("Section",secName);
        Name = sharedPreferences.getString("Name",Name);
        Roll = sharedPreferences.getString("Roll", Roll);

        md = new MediaPlayer();


        speed = distance/60;

        textViewSpeed.setText("Speed Of " + Name + " is " + speed + " m/sec" );


        buttonStartTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                md = MediaPlayer.create(SpeedActivity.this, R.raw.whistle);
                md.start();

                cd = new CountDownTimer(60000, 1000) {

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

            }
        });

        buttonStopTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                distance = Integer.parseInt(editTextDistance.getText().toString());

                md = MediaPlayer.create(SpeedActivity.this, R.raw.whistle);
                md.start();
                cd.cancel();
            }
        });

    }
}
