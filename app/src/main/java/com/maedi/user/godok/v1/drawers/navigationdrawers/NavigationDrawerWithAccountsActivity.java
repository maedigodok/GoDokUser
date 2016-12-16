package com.maedi.user.godok.v1.drawers.navigationdrawers;

import android.content.Intent;

import com.blunderer.materialdesignlibrary.handlers.ActionBarDefaultHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerAccountsHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerAccountsMenuHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerBottomHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerStyleHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerTopHandler;
import com.blunderer.materialdesignlibrary.models.Account;
import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.activity.ProfileActivity;
import com.maedi.user.godok.v1.drawers.listviews.ListViewFragment;
import com.maedi.user.godok.v1.drawers.viewpagers.ViewPagerFragment;

public class NavigationDrawerWithAccountsActivity
        extends com.blunderer.materialdesignlibrary.activities.NavigationDrawerActivity {

    Intent intent;

    @Override
    public NavigationDrawerStyleHandler getNavigationDrawerStyleHandler() {
        return null;
    }

    @Override
    public NavigationDrawerAccountsHandler getNavigationDrawerAccountsHandler() {
        return new NavigationDrawerAccountsHandler(this)
                //.enableSmallAccountsLayout()
                .addAccount("Maedi", "maedilaziman@gmail.com",R.drawable.logo_godok, R.drawable.backround_page_1);
                //.addAccount("Blunderer's cat", "cat@gmail.com",
                //        R.drawable.profile2, R.drawable.profile2_background)
                //.addAccount("Blunderer's dog", "dog@gmail.com",
                //        R.drawable.profile3, R.color.cyan)
                //.addAccount("Blunderer's monkey", "monkey@gmail.com",
                //        R.drawable.profile4, R.color.gray);
    }

    @Override
    public NavigationDrawerAccountsMenuHandler getNavigationDrawerAccountsMenuHandler() {
        return new NavigationDrawerAccountsMenuHandler(this);
                /*
                .addAddAccount(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                })
                .addManageAccounts(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
                */
    }

    @Override
    public void onNavigationDrawerAccountChange(Account account) {
    }

    @Override
    public NavigationDrawerTopHandler getNavigationDrawerTopHandler() {
        overridePendingTransition(R.anim.move_left_in_activity, R.anim.move_right_out_activity);
        intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("name", "Maedi");
        return new NavigationDrawerTopHandler(this)
                .addSection(R.string.daftarmenu)
                .addItem(R.string.profile, intent)
                .addItem(R.string.myquestion, new ListViewFragment())
                .addItem(R.string.favorit, new ListViewFragment())
                .addItem(R.string.poin, new ListViewFragment())
                .addItem(R.string.infokesehatan, new ListViewFragment())
                .addItem(R.string.share, new ListViewFragment())
                .addItem(R.string.share, new ListViewFragment());
                //.addItem(R.string.aboutmedical, ibac)
                //.addItem(R.string.daftarobat, new ListViewFragment())
                //.addItem(R.string.daftarobat, ExpandListFragment.newInstance())
                //.addItem(R.string.fragment_viewpager, new ViewPagerFragment())
                //.addItem(R.string.dokterjaga, new ViewPagerWithTabsFragment());
                //.addSection(R.string.activity);
               // .addItem(R.string.start_activity,new Intent(getApplicationContext(), ViewPagerActivity.class));
    }

    @Override
    public NavigationDrawerBottomHandler getNavigationDrawerBottomHandler() {
        return new NavigationDrawerBottomHandler(this)
                .addSettings(null)
                .addHelpAndFeedback(null);
    }

    @Override
    public boolean overlayActionBar() {
        return false;
    }

    @Override
    public boolean replaceActionBarTitleByNavigationDrawerItemTitle() {
        return true;
    }

    @Override
    public int defaultNavigationDrawerItemSelectedPosition() {
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
