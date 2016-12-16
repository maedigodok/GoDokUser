package com.maedi.user.godok.v1.drawers.viewpagers;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;
import com.maedi.user.godok.v1.MainFragment;
import com.maedi.user.godok.v1.R;

public class ViewPagerWithTabsFragment
        extends com.blunderer.materialdesignlibrary.fragments.ViewPagerWithTabsFragment {

    @Override
    public ViewPagerHandler getViewPagerHandler() {
        return new ViewPagerHandler(getActivity())
                .addPage("Telah Menjawab", MainFragment.newInstance("Dr. Michael"))
                .addPage("Belum Menjawab", MainFragment.newInstance("Dr. Rachel"));
    }

    @Override
    public boolean expandTabs() {
        return true;
    }

    @Override
    public int defaultViewPagerPageSelectedPosition() {
        return 0;
    }

    @Override
    public void selectPage(int page){}

    @Override
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener userOnPageChangeListener) {
        userOnPageChangeListener = new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            }
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                // Check if this is the page you want.
                //Toast.makeText(getContext(),"test on page listener",
                //        Toast.LENGTH_SHORT).show();
                Log.i("toast","test on page listener");
            }
        };
    }

}
