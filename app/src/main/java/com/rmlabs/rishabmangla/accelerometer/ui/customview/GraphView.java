package com.rmlabs.rishabmangla.accelerometer.ui.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.View;

/**
 * Created by rishabmangla on 24/01/16.
 */
public class GraphView extends View implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private Paint mPaint = new Paint();

    private int mCoord;
    private float mXOrigin;
    private float mYOrigin;
    private float mZOrigin;
    private float mSensorX;
    private float mSensorY;
    private float mSensorZ;

    public GraphView(Context context, int coord) {
        super(context);
        // Get an instance of the SensorManager
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mPaint.setColor(Color.BLUE);
        mCoord = coord;
    }

    public void startSimulation() {
            /*
             * It is not necessary to get accelerometer events at a very high
             * rate, by using a slower rate (SENSOR_DELAY_UI), we get an
             * automatic low-pass filter, which "extracts" the gravity component
             * of the acceleration. As an added benefit, we use less power and
             * CPU resources.
             * AS MENTIONED IN ANDROID DEVELOPERS DOCS
             */
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }

    public void stopSimulation() {
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER)
            return;
        mSensorX = event.values[0];
        mSensorY = event.values[1];
        mSensorZ = event.values[2];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.i("GraphView : onDraw", " X " + mSensorX + " Y " + mSensorY + " Z " + mSensorZ);
//        canvas.drawPoint(mSensorX,mSensorY,mPaint);
        canvas.drawLine(mXOrigin, mYOrigin, mSensorX, mSensorY, mPaint);
        mXOrigin = mSensorX;
        mYOrigin = mSensorY;
        // redraw
        invalidate();
    }
}
