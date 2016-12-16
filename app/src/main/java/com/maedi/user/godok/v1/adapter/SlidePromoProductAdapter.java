package com.maedi.user.godok.v1.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.maedi.user.godok.v1.fragment.SlidePromoProductFragment;
import com.maedi.user.godok.v1.viewpagerindicator.imbryk.LoopViewPager;

/**
 * Created by user on 11/11/2016.
 */

public class SlidePromoProductAdapter extends FragmentStatePagerAdapter {

    public SlidePromoProductAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        position = LoopViewPager.toRealPosition(position, getCount());
        return SlidePromoProductFragment.newInstance(position%SlidePromoProductFragment.getSlideCount());
    }

    @Override
    public int getCount() {
        return SlidePromoProductFragment.getSlideCount();
    }
}
