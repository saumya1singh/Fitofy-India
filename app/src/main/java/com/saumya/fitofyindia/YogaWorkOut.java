package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class YogaWorkOut extends AppCompatActivity {

    TextView titlepage, subtitlepage, intropage, subintropage,
            btnexercise, fitonetitle, fitonedesc, fittwotitle, fittwodesc,
            fitthreetitle, fitthreedesc, fitfourtitle, fitfourdesc;

    Animation bttone, bttwo, bttfour, bttfive, bttsix, bttseven, btteight;

    View divpage, bgprogress;

    LinearLayout fitone, fittwo, fitthree, fitfour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_work_out);


        // load animations
        bttone = AnimationUtils.loadAnimation(this, R.anim.bttone2);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo2);
        bttfour = AnimationUtils.loadAnimation(this, R.anim.bttfour2);
        bttfive = AnimationUtils.loadAnimation(this, R.anim.bttfive2);
        bttsix = AnimationUtils.loadAnimation(this, R.anim.bttsix2);
        bttseven = AnimationUtils.loadAnimation(this, R.anim.bttseven2);
        btteight = AnimationUtils.loadAnimation(this, R.anim.btteight2);

        // import font
        // Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
//        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
//        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");

        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);
        intropage = findViewById(R.id.intropage);
        subintropage = findViewById(R.id.subintropage);
        btnexercise = findViewById(R.id.btnexercise);
        divpage = findViewById(R.id.divpage);
        bgprogress = findViewById(R.id.bgprogress);


        // give an event to another page
        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(YogaWorkOut.this,YogaStartWork.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        // item fit layout
        fitone = findViewById(R.id.fitone);
        fittwo = findViewById(R.id.fittwo);
        fitthree = findViewById(R.id.fitthree);
        fitfour = findViewById(R.id.fitfour);




        // item fit
        fitonetitle = findViewById(R.id.fitonetitle);
        fitonedesc = findViewById(R.id.fitonedesc);

        fittwotitle = findViewById(R.id.fittwotitle);
        fittwodesc = findViewById(R.id.fittwodesc);

        fitthreetitle = findViewById(R.id.fitthreetitle);
        fitthreedesc = findViewById(R.id.fitthreedesc);

        fitfourtitle = findViewById(R.id.fitfourtitle);
        fitfourdesc = findViewById(R.id.fitfourdesc);

        // customize font
//        titlepage.setTypeface(Vidaloka);
//        subtitlepage.setTypeface(MLight);
//        intropage.setTypeface(Vidaloka);
//        subintropage.setTypeface(MLight);
//        btnexercise.setTypeface(MMedium);

        // customize font item
//        fitonedesc.setTypeface(MLight);
//        fitonetitle.setTypeface(MMedium);
//
//        fittwodesc.setTypeface(MLight);
//        fittwotitle.setTypeface(MMedium);
//
//        fitthreedesc.setTypeface(MLight);
//        fitthreetitle.setTypeface(MMedium);
//
//        fitfourdesc.setTypeface(MLight);
//        fitfourtitle.setTypeface(MMedium);

        // assign the animations
        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttone);
        divpage.startAnimation(bttone);

        intropage.startAnimation(bttwo);
        subintropage.startAnimation(bttwo);

        fitone.startAnimation(bttwo);
        fittwo.startAnimation(bttfour);
        fitthree.startAnimation(bttfive);
        fitfour.startAnimation(bttsix);

        btnexercise.startAnimation(btteight);
        bgprogress.startAnimation(bttseven);





    }
}
