package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SelectActivity extends AppCompatActivity {

    Button btnOrganisation, btnIndividual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        btnOrganisation = findViewById(R.id.btnOrganisation);
        btnIndividual = findViewById(R.id.btnIndividual);

        btnOrganisation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Intent i = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(i);
                finish();*/
                Toast.makeText(SelectActivity.this, "Organisation disabled", Toast.LENGTH_SHORT).show();
            }
        });
        btnIndividual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), LoginIndividual.class);
                startActivity(i);
                finish();
            }
        });



    }
}
