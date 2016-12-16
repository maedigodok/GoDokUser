package com.maedi.user.godok.v1.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.maedi.user.godok.v1.fragment.SlidePoinFragment;

/**
 * Created by user on 11/29/2016.
 */

public class SlidePoinAdapter extends FragmentStatePagerAdapter {

    public SlidePoinAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        Log.i("-view-", "getItem Position: "+position);
        return SlidePoinFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return SlidePoinFragment.getSlideCount();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return SlidePoinFragment.titlePage()[position];
    }
}

