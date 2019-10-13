package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        




    }
}
