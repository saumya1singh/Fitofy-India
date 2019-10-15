package com.saumya.fitofyindia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Healthactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthactivity);
    }

    public void health_tips(View view) {
        Intent i= new Intent(getApplicationContext(),Healthtip.class);
        startActivity(i);

    }
    public void  weight_loss(View view){
        Intent i= new Intent(getApplicationContext(),Weight_loss.class);
        startActivity(i);

    }
    public void excercise(View view){
        Intent i= new Intent(getApplicationContext(),Excercise.class);
        startActivity(i);

    }
    public void  beauty_tip(View view){
        Intent i= new Intent(getApplicationContext(),Beauty_tip.class);
        startActivity(i);

    }
    public  void general(View view){
        Intent i= new Intent(getApplicationContext(),General.class);
        startActivity(i);

    }
}
