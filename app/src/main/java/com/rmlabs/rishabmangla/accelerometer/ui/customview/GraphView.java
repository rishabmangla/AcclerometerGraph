package com.rmlabs.rishabmangla.accelerometer.ui.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.rmlabs.rishabmangla.accelerometer.data.AccelerometerData;
import com.rmlabs.rishabmangla.accelerometer.AccelerometerListener;
import com.rmlabs.rishabmangla.accelerometer.tools.LimitedSizeArray;

/**
 * Created by rishabmangla on 24/01/16.
 */
public class GraphView extends View {
    private AccelerometerListener mAccelerometerListener;
    private Paint mPaint = new Paint();
    private LimitedSizeArray<AccelerometerData> mSensorData;

    private int mCoord;
    private float mXOrigin;
    private float mYOrigin;
    private float mZOrigin;
    private int centerY;
    private int widthX;

    public GraphView(Context context, AccelerometerListener accelerometerListener, int coord) {
        super(context);
        mAccelerometerListener = accelerometerListener;
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(6f);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mCoord = coord;
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        widthX = metrics.widthPixels - 50;
        centerY = metrics.heightPixels/2;
        mSensorData = new LimitedSizeArray<>(widthX);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float sensorX = mAccelerometerListener.getmSensorX();
        float sensorY = mAccelerometerListener.getmSensorY();
        float sensorZ = mAccelerometerListener.getmSensorZ();
        AccelerometerData data = new AccelerometerData(sensorX, sensorY, sensorZ);
        mSensorData.add(data);

        Log.i("GraphView : onDraw", " coord " + mCoord + " X " + sensorX + " Y " + sensorY + " Z " + sensorZ);
        for(int i = 0; i < mSensorData.size(); ++i){
            float yCoordGraph = mCoord;
            switch (mCoord){
                case 1:
                    yCoordGraph = (float) mSensorData.get(i).getX();
                    break;
                case 2:
                    yCoordGraph = (float) mSensorData.get(i).getY();
                    break;
                case 3:
                    yCoordGraph = (float) mSensorData.get(i).getZ();
                    break;
            }
            canvas.drawPoint(i, centerY + yCoordGraph, mPaint);
        }

        mXOrigin = sensorX;
        mYOrigin = sensorY;
        mZOrigin = sensorZ;
        // redraw
        invalidate();
    }
}
