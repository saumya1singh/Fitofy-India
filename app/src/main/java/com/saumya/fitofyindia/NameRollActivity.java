package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameRollActivity extends AppCompatActivity {

    EditText editTextName, editTextRoll;
    Button buttonReady;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_roll);
        editTextName = findViewById(R.id.editTextName);
        editTextRoll = findViewById(R.id.editTextRoll);
        buttonReady = findViewById(R.id.buttonReady);


        buttonReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(getBaseContext(), OrganisationMainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}
