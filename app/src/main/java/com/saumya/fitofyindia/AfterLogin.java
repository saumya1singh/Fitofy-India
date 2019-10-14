package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AfterLogin extends AppCompatActivity {

    Button buttonView, buttonTest;
    TextView textViewOrganisation;
    SharedPreferences sharedPreferences;
    String organisation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        buttonView = findViewById(R.id.buttonView);
        buttonTest = findViewById(R.id.buttonTest);
        textViewOrganisation = findViewById(R.id.textViewOrganisation);
        sharedPreferences =  getSharedPreferences("Organisation", Context.MODE_PRIVATE);

        organisation = sharedPreferences.getString("OrgName", organisation);
        textViewOrganisation.setText(organisation);

        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getBaseContext(), ClassSectionActivity.class);
                startActivity(i);
                finish();

            }
        });


        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });





    }
}
