package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class IndividualMain extends AppCompatActivity {
 LinearLayout llyog , llgym,llhealth, llpedo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_main);
        llyog=findViewById(R.id.yoga);
        llgym=findViewById(R.id.llgym);
        llhealth=findViewById(R.id.llheath);
        llpedo=findViewById(R.id.llpedo);
        llyog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        llpedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        llhealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent= new Intent(getBaseContext(),Healthactivity.class);
                startActivity(intent);

            }
        });
        llpedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
