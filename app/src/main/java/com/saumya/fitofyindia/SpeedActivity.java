package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SpeedActivity extends AppCompatActivity {

    MediaPlayer md;
    TextView textViewTimer;
    Button buttonStartTimer,buttonStopTimer;

    EditText editTextDistance;
    Long distance ;
    String distString;
    TextView textViewSpeed;
    SharedPreferences sharedPreferences;
    String organisation, className,secName,Name,Roll;
    Long speed;
    Long time ;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    final int MSG_START_TIMER = 0;
    final int MSG_STOP_TIMER = 1;
    final int MSG_UPDATE_TIMER = 2;

    Stopwatch timer = new Stopwatch();
    final int REFRESH_RATE = 100;

    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_START_TIMER:
                    timer.start(); //start timer
                    mHandler.sendEmptyMessage(MSG_UPDATE_TIMER);
                    break;

                case MSG_UPDATE_TIMER:
                    textViewTimer.setText(""+ timer.getElapsedTimeSecs());
                    mHandler.sendEmptyMessageDelayed(MSG_UPDATE_TIMER,REFRESH_RATE); //text view is updated every second,
                    break;                                  //though the timer is still running
                case MSG_STOP_TIMER:
                    mHandler.removeMessages(MSG_UPDATE_TIMER); // no more updates.
                    timer.stop();//stop timer
                    textViewTimer.setText(""+ timer.getElapsedTimeSecs());
                    break;

                default:
                    break;
            }
        }
    };


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

        firebaseDatabase = FirebaseDatabase.getInstance("https://fitofyindia.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference("Organisation/" + organisation);


        md = new MediaPlayer();
        textViewSpeed.setVisibility(View.GONE);
        buttonStartTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distString=editTextDistance.getText().toString();

                if(checkValid()){
                     md = MediaPlayer.create(SpeedActivity.this, R.raw.whistle);
                     md.start();

                    mHandler.sendEmptyMessage(MSG_START_TIMER);
                    buttonStartTimer.setVisibility(View.GONE);
                    buttonStopTimer.setVisibility(View.VISIBLE);

                }


            }
        });

        buttonStopTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Integer.parseInt(distString);

                distance = Long.parseLong(distString);


                md = MediaPlayer.create(SpeedActivity.this, R.raw.whistle);
                md.start();
                mHandler.sendEmptyMessage(MSG_STOP_TIMER);
                time=Long.parseLong(textViewTimer.getText().toString());
                speed=distance/time;

           databaseReference.child(className).child(secName).child(Roll).child("Speed").setValue(speed);
                textViewSpeed.setVisibility(View.VISIBLE);
              textViewSpeed.setText("Speed Of " + Name + " Is " + speed + " m/sec" );
                buttonStopTimer.setVisibility(View.GONE);
                buttonStartTimer.setVisibility(View.VISIBLE);
            }
        });

    }
    private boolean checkValid() {
        Boolean check =true;
        if(TextUtils.isEmpty(distString))
        {
            editTextDistance.setError("Required");
            check=false;
        }

        return check;
    }
}
