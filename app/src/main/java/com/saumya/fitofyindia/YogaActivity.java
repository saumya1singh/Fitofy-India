package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class YogaActivity extends AppCompatActivity {

    TextView titlepage, subtitlepage, btnexercise;
    ImageView imgpage;
    Animation animimgpage, bttone, bttwo, btthree, ltr;
    View bgprogress, bgprogresstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);

        // load animation
        animimgpage = AnimationUtils.loadAnimation(this, R.anim.animimgpage2);
        bttone = AnimationUtils.loadAnimation(this, R.anim.bttone2);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo2);
        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree2);
        ltr = AnimationUtils.loadAnimation(this, R.anim.ltr2);


        // import font
       /* Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");*/


        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);
        btnexercise = findViewById(R.id.btnexercis);
        imgpage = findViewById(R.id.imgpage);
        bgprogress = findViewById(R.id.bgprogress);
        bgprogresstop = findViewById(R.id.bgprogresstop);

        // export animate
        imgpage.startAnimation(animimgpage);
        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttone);


        btnexercise.startAnimation(btthree);
        bgprogress.startAnimation(bttwo);
        bgprogresstop.startAnimation(ltr);

        // give an event to another page
        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(YogaActivity.this, YogaWorkOut.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

    }
}


