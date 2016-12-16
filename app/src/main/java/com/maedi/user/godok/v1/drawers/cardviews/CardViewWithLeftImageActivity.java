package com.maedi.user.godok.v1.drawers.cardviews;

import com.blunderer.materialdesignlibrary.handlers.ActionBarDefaultHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.maedi.user.godok.v1.R;

public class CardViewWithLeftImageActivity
        extends com.blunderer.materialdesignlibrary.activities.Activity {

    @Override
    protected int getContentView() {
        return R.layout.activity_cardview_with_left_image;
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
