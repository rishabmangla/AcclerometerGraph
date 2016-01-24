package com.rmlabs.rishabmangla.accelerometer.ui.activity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.rmlabs.rishabmangla.accelerometer.AccelerometerListener;
import com.rmlabs.rishabmangla.accelerometer.adapter.CoordAdapter;
import com.rmlabs.rishabmangla.accelerometer.R;

public class MainActivity extends AppCompatActivity {

    ViewPager mCoordPager;
    TabLayout mTabLayout;
    private CoordAdapter mCoordAdapter;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private AccelerometerListener mAccelerometerListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // Get an instance of the SensorManager
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mAccelerometerListener = new AccelerometerListener();

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mCoordAdapter = new CoordAdapter(getSupportFragmentManager(), mAccelerometerListener);
        mCoordPager = (ViewPager) findViewById(R.id.coord_pager);
        mCoordPager.setAdapter(mCoordAdapter);
        mCoordPager.setOffscreenPageLimit(3);
        mTabLayout = (TabLayout) findViewById(R.id.coord_tabs);
        mTabLayout.setupWithViewPager(mCoordPager);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Start the simulation
        mSensorManager.registerListener(mAccelerometerListener, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Stop the simulation
        // we should unregister the sensor's listener as per the best practices dev docs
        mSensorManager.unregisterListener(mAccelerometerListener);
    }

}
