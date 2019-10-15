package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class OrganisationMainActivity extends AppCompatActivity {


     ImageView imgSpeed, imageViewAgility, imageViewBalance, imgStrength;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_organisation_main);
        imgSpeed = findViewById(R.id.imgSpeed);
        imageViewAgility = findViewById(R.id.imageViewAgility);
        imageViewBalance = findViewById(R.id.imageViewBalance);
        imgStrength = findViewById(R.id.imgStrength);


        imgSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(getBaseContext(), SpeedActivity.class);
                startActivity(i);
                finish();
            }
        });


        imageViewAgility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(getBaseContext(), AgilityActivity.class);
                startActivity(i);
                finish();
            }
        });

        imageViewBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(getBaseContext(), BalanceActivity.class);
                startActivity(i);
                finish();
            }
        });


        imgStrength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(getBaseContext(), StrenghtActivity.class);
                startActivity(i);
                finish();
            }
        });





    }
}
