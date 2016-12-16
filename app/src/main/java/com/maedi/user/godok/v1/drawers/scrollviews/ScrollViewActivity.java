package com.maedi.user.godok.v1.drawers.scrollviews;

import com.blunderer.materialdesignlibrary.handlers.ActionBarDefaultHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.maedi.user.godok.v1.R;

public class ScrollViewActivity
        extends com.blunderer.materialdesignlibrary.activities.ScrollViewActivity {

    @Override
    public int getContentView() {
        return R.layout.activity_scrollview;
    }

    @Override
    public boolean pullToRefreshEnabled() {
        return false;
    }

    @Override
    public int[] getPullToRefreshColorResources() {
        return new int[0];
    }

    @Override
    public void onRefresh() {
    }

    @Override
    protected boolean enableActionBarShadow() {
        return false;
    }

    @Override
    protected ActionBarHandler getActionBarHandler() {
        return new ActionBarDefaultHandler(this);
    }

}
