package com.rmlabs.rishabmangla.accelerometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

/**
 * Created by rishabmangla on 24/01/16.
 */
public class AccelerometerListener implements SensorEventListener {
    private float mSensorX;
    private float mSensorY;
    private float mSensorZ;

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER)
            return;
        mSensorX = event.values[0];
        mSensorY = event.values[1];
        mSensorZ = event.values[2];
        Log.i("AccelerometerListener:", "onSensorChanged " + " X " + mSensorX + " Y " + mSensorY + " Z " + mSensorZ);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public float getmSensorX() {
        return mSensorX;
    }

    public float getmSensorY() {
        return mSensorY;
    }

    public float getmSensorZ() {
        return mSensorZ;
    }
}
