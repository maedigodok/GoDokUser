package com.maedi.user.godok.v1.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.viewpagerindicator.PageIndicator;
import com.maedi.user.godok.v1.viewpagerindicator.TabPageIndicator;
import com.maedi.user.godok.v1.adapter.SlideHomeAdapter;

/**
 * Created by user on 11/16/2016.
 */

public class Tab1Fragment extends Fragment {

    public static ViewPager viewPager;
    //private PageIndicator mIndicator;
    private PagerSlidingTabStrip mIndicator;
    public static View viewFragment;
    private static FragmentActivity fragmentActivity;
    private SlideHomeAdapter mAdapter;

    private Tab1Fragment.OnFragmentInteractionListener mListener;

    public Tab1Fragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Tab1Fragment newInstance() {
        Tab1Fragment fragment = new Tab1Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("-view-", "call Adapter");
        mAdapter = new SlideHomeAdapter(getFragmentManager());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_home_tab1, container, false);
        Log.i("-view-", "onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        viewPager = (ViewPager)view.findViewById(R.id.slide_pager);
        viewPager.setAdapter(mAdapter);

        Log.i("-view-", "onViewCreated");

        //mIndicator = (TabPageIndicator)view.findViewById(R.id.slide_indicator);
        mIndicator  = (PagerSlidingTabStrip) view.findViewById(R.id.slide_indicator);
        mIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                Log.i("page selected",""+position);
            }
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        mIndicator.setViewPager(viewPager);
    }

    // This method is called after the parent Activity's onCreate() method has completed.
    // Accessing the view hierarchy of the parent activity must be done in the onActivityCreated.
    // At this point, it is safe to search for activity View objects by their ID, for example.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    */

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

