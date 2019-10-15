package com.saumya.fitofyindia;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CounterActivity extends AppCompatActivity implements SensorEventListener {


    //init views
    TextView steps;

    SensorManager sensorManager;

    boolean run = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter);
        steps = findViewById(R.id.steps);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);


    }

    @Override
    protected void onResume() {
        super.onResume();
        run = true;
        Sensor count = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        if (count!=null){
            sensorManager.registerListener(this,count,SensorManager.SENSOR_DELAY_UI);

        }else
        {
            Toast.makeText(this, "Did not found any step sensor in your phone", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        run =false;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if (run){
            steps.setText(String.valueOf(sensorEvent.values[0]));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
