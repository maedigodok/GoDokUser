package com.maedi.user.godok.v1.drawers.viewpagers;

import com.blunderer.materialdesignlibrary.handlers.ActionBarDefaultHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;
import com.maedi.user.godok.v1.MainFragment;
import com.maedi.user.godok.v1.R;

public class ViewPagerWithTabsExpandedActivity
        extends com.blunderer.materialdesignlibrary.activities.ViewPagerWithTabsActivity {

    @Override
    public ViewPagerHandler getViewPagerHandler() {
        return new ViewPagerHandler(this)
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
    protected boolean enableActionBarShadow() {
        return false;
    }

    @Override
    protected ActionBarHandler getActionBarHandler() {
        return new ActionBarDefaultHandler(this);
    }

}
