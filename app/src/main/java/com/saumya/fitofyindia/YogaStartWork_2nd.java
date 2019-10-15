package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class YogaStartWork_2nd extends AppCompatActivity {

    TextView intropage2, subintropage2, fitonetitle2, fitonedesc2, timerValue2, btnexercise2;
    View divpage2, bgprogress2;
    ImageView imgtimer2;
    LinearLayout fitone2;


    private static final long START_TIME_IN_MILLIS = 800000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    Animation btthree, bttfour, ttbone, ttbtwo, alphagogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_start_work_2nd);


        // load animations
        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree2);
        bttfour = AnimationUtils.loadAnimation(this, R.anim.bttfour2);
        ttbone = AnimationUtils.loadAnimation(this, R.anim.ttbone2);
        ttbtwo = AnimationUtils.loadAnimation(this, R.anim.ttbtwo2);
        alphagogo = AnimationUtils.loadAnimation(this, R.anim.alphagogo2);


        // import font
//        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
//        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
//        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");


        intropage2 = (TextView) findViewById(R.id.intropage2);
        subintropage2 = (TextView) findViewById(R.id.subintropage2);
        btnexercise2 = (TextView) findViewById(R.id.btnexercise2);
        fitonetitle2 = (TextView) findViewById(R.id.fitonetitle2);
        fitonedesc2 = (TextView) findViewById(R.id.fitonedesc2);
        timerValue2 = (TextView) findViewById(R.id.timerValue2);
        btnexercise2 = (TextView) findViewById(R.id.btnexercise2);

        divpage2 = (View) findViewById(R.id.divpage2);
        bgprogress2 = (View) findViewById(R.id.bgprogress2);
        fitone2 = (LinearLayout) findViewById(R.id.fitone2);
        imgtimer2 = (ImageView) findViewById(R.id.imgtimer2);

        // change customize font
//        intropage.setTypeface(Vidaloka);
//        subintropage.setTypeface(MLight);
//        btnexercise.setTypeface(MMedium);
//        timerValue.setTypeface(MMedium);
//        fitonedesc.setTypeface(MLight);
//        fitonetitle.setTypeface(MMedium);
//
//        // assign animation
        btnexercise2.startAnimation(bttfour);
        bgprogress2.startAnimation(btthree);
        fitone2.startAnimation(ttbone);
        intropage2.startAnimation(ttbtwo);
        subintropage2.startAnimation(ttbtwo);
        divpage2.startAnimation(ttbtwo);
        timerValue2.startAnimation(alphagogo);
        imgtimer2.startAnimation(alphagogo);

        startTimer();

        // give an event to another page
        btnexercise2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(YogaStartWork_2nd.this,YogaWorkOut.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

    }

    private void startTimer(){
        countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDowntText();
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "Congratulations!", Toast.LENGTH_SHORT).show();
            }
        }.start();
        mTimerRunning = true;
    }

    private void updateCountDowntText(){
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeft = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timerValue2.setText(timeLeft);
    }
}
