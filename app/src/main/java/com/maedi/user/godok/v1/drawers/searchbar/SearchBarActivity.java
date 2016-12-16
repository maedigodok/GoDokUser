package com.maedi.user.godok.v1.drawers.searchbar;

import android.widget.Toast;

import com.blunderer.materialdesignlibrary.activities.Activity;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarSearchHandler;
import com.blunderer.materialdesignlibrary.listeners.OnSearchListener;
import com.maedi.user.godok.v1.R;

public class SearchBarActivity extends Activity {

    @Override
    protected int getContentView() {
        return R.layout.activity_searchbar;
    }

    @Override
    protected boolean enableActionBarShadow() {
        return false;
    }

    @Override
    protected ActionBarHandler getActionBarHandler() {
        return new ActionBarSearchHandler(this, new OnSearchListener() {

            @Override
            public void onSearched(String text) {
                Toast.makeText(getApplicationContext(),
                        "Searching \"" + text + "\"", Toast.LENGTH_SHORT).show();
            }

        });
    }

}
