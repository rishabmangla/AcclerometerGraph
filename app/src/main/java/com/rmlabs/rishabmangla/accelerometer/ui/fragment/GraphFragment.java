package com.rmlabs.rishabmangla.accelerometer.ui.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rmlabs.rishabmangla.accelerometer.AccelerometerListener;
import com.rmlabs.rishabmangla.accelerometer.ui.customview.GraphView;


/**
 * Fragments used to create X,Y,Z graphs.
 * Use the {@link GraphFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GraphFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_COORDINATE_NUMBER = "section_number";
    private GraphView mGraphView;
    private static AccelerometerListener mAccelerometerListener;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static GraphFragment newInstance(int sectionNumber, AccelerometerListener accelerometerListener) {
        GraphFragment fragment = new GraphFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COORDINATE_NUMBER, sectionNumber);
        fragment.setArguments(args);
        mAccelerometerListener = accelerometerListener;
        return fragment;
    }

    public GraphFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mGraphView = new GraphView(getActivity(), mAccelerometerListener, getArguments().getInt(ARG_COORDINATE_NUMBER));
        return mGraphView;
    }

}
