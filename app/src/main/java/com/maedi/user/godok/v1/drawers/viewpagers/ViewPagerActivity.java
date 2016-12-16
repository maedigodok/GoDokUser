package com.maedi.user.godok.v1.drawers.viewpagers;

import android.view.KeyEvent;

import com.blunderer.materialdesignlibrary.handlers.ActionBarDefaultHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;
import com.maedi.user.godok.v1.MainFragment;
import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.activity.EnterIn;

public class ViewPagerActivity
        extends com.blunderer.materialdesignlibrary.activities.ViewPagerActivity {

    @Override
    public ViewPagerHandler getViewPagerHandler() {
        //return new ViewPagerHandler(this)
       //         .addPage(R.string.title_section1,MainFragment.newInstance("Material Design ViewPager"))
        //        .addPage(R.string.title_section2,MainFragment.newInstance("Material Design ViewPager"));
        overridePendingTransition(R.anim.move_left_in_activity, R.anim.move_right_out_activity);
        return new ViewPagerHandler(this)
                .addPage("Welcome 1", MainFragment.newInstance("welcom1"))
                .addPage("Welcome 2", MainFragment.newInstance("welcome2"))
                .addPage("Welcome 3", EnterIn.newInstance());
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

    @Override
    protected boolean enableActionBarShadow() {
        return true;
    }

    @Override
    protected ActionBarHandler getActionBarHandler() {
        return new ActionBarDefaultHandler(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}
