package com.rmlabs.rishabmangla.accelerometer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rmlabs.rishabmangla.accelerometer.ui.fragment.GraphFragment;

/**
 * Created by rishabmangla on 24/01/16.
 */
public class CoordAdapter extends FragmentPagerAdapter {

    public CoordAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a GraphFragment (defined as a static inner class below).
        return GraphFragment.newInstance(position + 1);
    }

    //TODO remove hard code count
    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    //TODO remove hard code title
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "X_SENSOR";
            case 1:
                return "Y_SENSOR";
            case 2:
                return "Z_SENSOR";
        }
        return null;
    }
}
