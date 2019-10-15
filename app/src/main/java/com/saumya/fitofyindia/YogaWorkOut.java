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

        titlepage = (TextView) findViewById(R.id.titlepage);
        subtitlepage = (TextView) findViewById(R.id.subtitlepage);
        intropage = (TextView) findViewById(R.id.intropage);
        subintropage = (TextView) findViewById(R.id.subintropage);
        btnexercise = (TextView) findViewById(R.id.btnexercise);
        divpage = (View) findViewById(R.id.divpage);
        bgprogress = (View) findViewById(R.id.bgprogress);


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
        fitone = (LinearLayout) findViewById(R.id.fitone);
        fittwo = (LinearLayout) findViewById(R.id.fittwo);
        fitthree = (LinearLayout) findViewById(R.id.fitthree);
        fitfour = (LinearLayout) findViewById(R.id.fitfour);




        // item fit
        fitonetitle = (TextView) findViewById(R.id.fitonetitle);
        fitonedesc = (TextView) findViewById(R.id.fitonedesc);

        fittwotitle = (TextView) findViewById(R.id.fittwotitle);
        fittwodesc = (TextView) findViewById(R.id.fittwodesc);

        fitthreetitle = (TextView) findViewById(R.id.fitthreetitle);
        fitthreedesc = (TextView) findViewById(R.id.fitthreedesc);

        fitfourtitle = (TextView) findViewById(R.id.fitfourtitle);
        fitfourdesc = (TextView) findViewById(R.id.fitfourdesc);

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
