package com.saumya.fitofyindia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class YogaEditWork extends AppCompatActivity {

    TextView titlepage, subtitlepage, fitonetitle, fitonedesc,
            workvalue, fittwotitle, fittwodesc, btnexercise;

    Button btnlocked, btnadd, btnremove;

    View divpage, bgprogress;

    LinearLayout fitone, fittwo;

    Animation bttone, bttwo, bttfour, bttfive;

    int sumworkout = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_edit_work);



        // load animations
        bttone = AnimationUtils.loadAnimation(this, R.anim.bttone2);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo2);
        bttfour = AnimationUtils.loadAnimation(this, R.anim.bttfour2);
        bttfive = AnimationUtils.loadAnimation(this, R.anim.bttfive2);

        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);

        fitone = findViewById(R.id.fitone);
        fittwo = findViewById(R.id.fittwo);

        divpage = findViewById(R.id.divpage);
        bgprogress = findViewById(R.id.bgprogress);

        fitonetitle = findViewById(R.id.fitonetitle);
        fitonedesc = findViewById(R.id.fitonedesc);
        fittwotitle = findViewById(R.id.fittwotitle);
        fittwodesc = findViewById(R.id.fittwodesc);

        btnlocked = findViewById(R.id.btnlocked);
        btnadd = findViewById(R.id.btnadd);
        btnremove = findViewById(R.id.btnremove);

        workvalue = findViewById(R.id.workvalue);

        btnexercise = findViewById(R.id.btnexercise);

        // import font
//        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
//        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
//        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");

        // customize font
//        titlepage.setTypeface(Vidaloka);
//        subtitlepage.setTypeface(MLight);
//        btnexercise.setTypeface(MMedium);
//
//        fitonetitle.setTypeface(MMedium);
//        fitonedesc.setTypeface(MLight);
//        fittwotitle.setTypeface(MMedium);
//        fittwodesc.setTypeface(MLight);
//
//        workvalue.setTypeface(MMedium);
//
//        btnlocked.setTypeface(MMedium);
//        btnadd.setTypeface(MMedium);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumworkout+=1;
                workvalue.setText(String.valueOf(sumworkout));
            }
        });

        btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sumworkout <= 0){
                    Toast.makeText(getApplicationContext(), "Sorry!", Toast.LENGTH_SHORT).show();
                } else {
                    sumworkout-=1;
                    workvalue.setText(String.valueOf(sumworkout));
                }
            }
        });


        // assign the animations
        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttone);
        divpage.startAnimation(bttone);

        fitone.startAnimation(bttwo);
        fittwo.startAnimation(bttfour);

        btnexercise.startAnimation(bttfive);
        bgprogress.startAnimation(bttfive);

        // give an event to another page
        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(YogaEditWork.this,YogaStartWork_2nd.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });


    }
}


