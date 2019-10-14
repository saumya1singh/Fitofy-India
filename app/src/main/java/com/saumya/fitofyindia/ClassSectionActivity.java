package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ClassSectionActivity extends AppCompatActivity {


    Button buttonNext;
    Spinner spinnerClass , spinnerSec;
    String className, secName;

    List<String> ClassList = new ArrayList<String>();
    List<String> SecList = new ArrayList<String>();
    SharedPreferences sharedPreferences;

    String organisation;
    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_section);
        buttonNext = findViewById(R.id.buttonNext);
        spinnerClass=findViewById(R.id.spinnerClass);
        spinnerSec=findViewById(R.id.spinnerSection);

        sharedPreferences = getSharedPreferences("Organisation", Context.MODE_PRIVATE);

        organisation = sharedPreferences.getString("OrgName", organisation);

        firebaseDatabase = FirebaseDatabase.getInstance("https://fitofyindia.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference("Organisation/" + organisation);


        ClassList.add("Select Class");
        ClassList.add("1");
        ClassList.add("2");
        ClassList.add("3");
        ClassList.add("4");
        ClassList.add("5");
        ClassList.add("6");
        ClassList.add("7");
        ClassList.add("8");
        ClassList.add("9");
        ClassList.add("10");
        ClassList.add("11");
        ClassList.add("12");
        SecList.add("A");
        SecList.add("B");
        SecList.add("C");
        SecList.add("D");


        SharedPreferences.Editor editor = sharedPreferences.edit();
        //editor.putString("OrgName", className);
        editor.putString("Class", className);
        editor.putString("Section", secName);
        editor.apply();

        ArrayAdapter<String> dataClassAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ClassList );
        ArrayAdapter<String> dataSecAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SecList);

        dataClassAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataSecAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSec.setAdapter(dataSecAdapter);
        spinnerClass.setAdapter(dataClassAdapter);

        spinnerSec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
         // selected item SecList.get(i);
            secName = SecList.get(i);
          }

          @Override
          public void onNothingSelected(AdapterView<?> adapterView) {

          }
      });

      spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              //selected item ClassList.get(i);
              className = ClassList.get(i);
          }

          @Override
          public void onNothingSelected(AdapterView<?> adapterView) {

          }
      });
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validation()) {
                    Intent i = new Intent(getBaseContext(), NameRollActivity.class);

                    i.putExtra("class", className);
                    i.putExtra("section", secName);
                    startActivity(i);

                    finish();
                }

            }
        });

        databaseReference.child(className);
        databaseReference.child(className).child(secName);

    }

    private boolean validation() {
        boolean check = true;

        if (TextUtils.isEmpty(className)) {
            TextView errorText = (TextView) spinnerClass.getSelectedView();
            errorText.setError("");
            errorText.setText("Required");//changes the selected item text to this

            check = false;
        }
        if (TextUtils.isEmpty(secName)) {

            TextView errorText = (TextView) spinnerClass.getSelectedView();
            errorText.setError("");
            errorText.setText("Required");//changes the selected item text to this

            check = false;
        }
        return check;
    }

}
