package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AfterLogin extends AppCompatActivity {

    Button buttonView, buttonTest;
    TextView textViewOrganisation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        buttonView = findViewById(R.id.buttonView);
        buttonTest = findViewById(R.id.buttonTest);
        textViewOrganisation = findViewById(R.id.textViewOrganisation);


        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getBaseContext(), OrganisationMainActivity.class);
                startActivity(i);
            }
        });


        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });





    }
}
