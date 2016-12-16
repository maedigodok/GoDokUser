package com.maedi.user.godok.v1.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.maedi.user.godok.v1.fragment.SlideHomeFragment;

/**
 * Created by user on 11/16/2016.
 */

public class SlideHomeAdapter extends FragmentStatePagerAdapter {

    public SlideHomeAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        Log.i("-view-", "getItem Position: "+position);
        return SlideHomeFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return SlideHomeFragment.getSlideCount();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return SlideHomeFragment.titlePage()[position];
    }
}
