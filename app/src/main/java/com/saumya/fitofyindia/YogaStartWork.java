package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
// import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
// import android.widget.Toast;

// import java.util.Locale;

public class YogaStartWork extends AppCompatActivity {


    TextView intropage, subintropage, fitonetitle, fitonedesc, timerValue, btnexercise;
    View divpage, bgprogress;
    ImageView imgtimer;
    LinearLayout fitone;

    /* private static final long START_TIME_IN_MILLIS = 800000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS; */

    Animation btthree, bttfour, ttbone, ttbtwo, alphagogo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_start_work);


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


        intropage = findViewById(R.id.intropage);
        subintropage = findViewById(R.id.subintropage);
        btnexercise = findViewById(R.id.btnexercise);
        fitonetitle = findViewById(R.id.fitonetitle);
        fitonedesc = findViewById(R.id.fitonedesc);
        timerValue = findViewById(R.id.timerValue);
        btnexercise = findViewById(R.id.btnexercise);

        divpage = findViewById(R.id.divpage);
        bgprogress = findViewById(R.id.bgprogress);
        fitone = findViewById(R.id.fitone);
        imgtimer = findViewById(R.id.imgtimer);

        // change customize font
//        intropage.setTypeface(Vidaloka);
//        subintropage.setTypeface(MLight);
//        btnexercise.setTypeface(MMedium);
//        timerValue.setTypeface(MMedium);
//        fitonedesc.setTypeface(MLight);
//        fitonetitle.setTypeface(MMedium);
//
//        // assign animation
        btnexercise.startAnimation(bttfour);
        bgprogress.startAnimation(btthree);
        fitone.startAnimation(ttbone);
        intropage.startAnimation(ttbtwo);
        subintropage.startAnimation(ttbtwo);
        divpage.startAnimation(ttbtwo);
        timerValue.startAnimation(alphagogo);
        imgtimer.startAnimation(alphagogo);

        startTimer();

        // give an event to another page
        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(YogaStartWork.this, YogaWorkOut.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

    }

    private void startTimer(){
        /* countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
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
        mTimerRunning = true; */
    }

    /* private void updateCountDowntText(){
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeft = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timerValue.setText(timeLeft);
    } */
}
