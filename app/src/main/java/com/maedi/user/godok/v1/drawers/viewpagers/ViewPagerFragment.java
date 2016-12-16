package com.maedi.user.godok.v1.drawers.viewpagers;

import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;
import com.maedi.user.godok.v1.MainFragment;
import com.maedi.user.godok.v1.R;

public class ViewPagerFragment
        extends com.blunderer.materialdesignlibrary.fragments.ViewPagerFragment {

    @Override
    public ViewPagerHandler getViewPagerHandler() {
        return new ViewPagerHandler(getActivity())
                .addPage(R.string.title_item1, MainFragment.newInstance("Material Design Fragment ViewPager"))
                .addPage(R.string.title_item2, MainFragment.newInstance("Material Design Fragment ViewPager"));
    }

    @Override
    public int defaultViewPagerPageSelectedPosition() {
        return 0;
    }

    @Override
    public boolean showViewPagerIndicator() {
        return true;
    }

    @Override
    public boolean replaceActionBarTitleByViewPagerPageTitle() {
        return true;
    }

}
