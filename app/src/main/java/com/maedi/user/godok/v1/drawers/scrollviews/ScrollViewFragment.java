package com.maedi.user.godok.v1.drawers.scrollviews;

import android.os.Handler;

import com.maedi.user.godok.v1.R;


public class ScrollViewFragment
        extends com.blunderer.materialdesignlibrary.fragments.ScrollViewFragment {

    @Override
    public int getContentView() {
        return R.layout.fragment_scrollview;
    }

    @Override
    public boolean pullToRefreshEnabled() {
        return true;
    }

    @Override
    public int[] getPullToRefreshColorResources() {
        return new int[]{R.color.color_primary};
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                setRefreshing(false);
            }

        }, 2000);
    }

}
