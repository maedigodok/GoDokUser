package com.maedi.user.godok.v1.drawers.listviews;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.blunderer.materialdesignlibrary.handlers.ActionBarDefaultHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;

public class ListViewActivity
        extends com.blunderer.materialdesignlibrary.activities.ListViewActivity {

    String[] values = new String[] { "Android List View",
            "Adapter implementation",
            "Simple List View In Android",
            "Create List View Android",
            "Android Example",
            "List View Source Code",
            "List View Array Adapter",
            "Android Example List View"
    };

    @Override
    public ListAdapter getListAdapter() {
        /*
        return new ArrayAdapter<>(
                this,
                R.layout.listview_row,
                new ArrayList<>(Arrays.asList(
                        getString(R.string.title_item1),
                        getString(R.string.title_item2),
                        getString(R.string.title_item3)
                ))
        );
        */
        return new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
    }

    @Override
    public boolean useCustomContentView() {
        return false;
    }

    @Override
    public int getCustomContentView() {
        return 0;
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
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
        return true;
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
