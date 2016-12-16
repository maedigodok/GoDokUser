package com.blunderer.materialdesignlibrary.models;

import android.support.v4.app.Fragment;

public class NavigationDrawerListItemTopFragment extends ListItem {

    private Fragment mFragment;
    //private Intent intent;

    public Fragment getFragment() {
        return mFragment;
    }

    public void setFragment(Fragment fragment) {
        this.mFragment = fragment;
    }

    //public Intent getIntent() {
    //    return intent;
    //}

    //public void setIntent(Intent intent) {
    //    this.intent = intent;
    //}

}
