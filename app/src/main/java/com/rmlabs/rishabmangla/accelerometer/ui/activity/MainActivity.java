package com.rmlabs.rishabmangla.accelerometer.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.rmlabs.rishabmangla.accelerometer.adapter.CoordAdapter;
import com.rmlabs.rishabmangla.accelerometer.R;

public class MainActivity extends AppCompatActivity {

    ViewPager mCoordPager;
    TabLayout mTabLayout;
    private CoordAdapter mCoordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mCoordAdapter = new CoordAdapter(getSupportFragmentManager());
        mCoordPager = (ViewPager) findViewById(R.id.coord_pager);
        mCoordPager.setAdapter(mCoordAdapter);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mCoordPager);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Start the simulation
        // handled the start and stop in the fragments onResume
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Stop the simulation
        // handled the start and stop in the fragments onPause
    }
}
