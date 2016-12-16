package com.maedi.user.godok.v1.drawers.listviews;

import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.maedi.user.godok.v1.R;

public class ListViewFragment
        extends com.blunderer.materialdesignlibrary.fragments.ListViewFragment {

    //private List<String> mObjects;
    //private ArrayAdapter<String> mAdapter;

    @Override
    public ListAdapter getListAdapter() {
        /*mObjects = new ArrayList<>(Arrays.asList(
                getString(R.string.title_item1),
                getString(R.string.title_item2),
                getString(R.string.title_item3)
        ));*/

        String[] values = new String[] {
                "Flu",
                "Sakit kepala",
                "Sakit perut",
                "Mual",
                "Demam"
        };
        //return (mAdapter = new ArrayAdapter<>(getActivity(), R.layout.listview_row, mObjects));
        return new ArrayAdapter<String>(getActivity(),
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
                //mObjects.add("Item " + (mObjects.size() + 1));
                //mAdapter.notifyDataSetChanged();
                //setRefreshing(false);
            }

        }, 2000);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
        return false;
    }

}
