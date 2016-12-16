package com.maedi.user.godok.v1.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.adapter.ListDataMyQuestionAdapter;
import com.maedi.user.godok.v1.adapter.ListDataPointResultAdapter;
import com.maedi.user.godok.v1.data.ListData;
import com.maedi.user.godok.v1.utils.DataReference;

/**
 * Created by user on 11/29/2016.
 */

public class SlidePoinFragment extends Fragment {

    private static final String fragmentKey = "SLIDE-HOME";
    private int slideNumber;

    public static SlidePoinFragment newInstance(int _slideNumber) {
        SlidePoinFragment fragment = new SlidePoinFragment(_slideNumber);
        return fragment;
    }

    public static int getSlideCount() {
        return 2;
    }

    public static String[] titlePage() {
        return ListData.TabsPoinText();
    }

    public SlidePoinFragment() {
        super();
    }

    @SuppressLint("ValidFragment")
    private SlidePoinFragment(int slideNumber) {
        super();
        this.slideNumber = slideNumber;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null) && savedInstanceState.containsKey(fragmentKey)) {
            slideNumber = savedInstanceState.getInt(fragmentKey);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = null;
        Log.i("-view-", "SlideNumber: "+slideNumber);
        switch (slideNumber) {
            case 0:
                view = inflater.inflate(getActivity().getResources().getLayout(R.layout.poin_result), container, false);
                ListDataPointResultAdapter adapterC1 = new ListDataPointResultAdapter(view.getContext(), R.layout.list_item_point_result,
                        ListData.listPointResult(), DataReference.TAG_LIST_POINT_RESULT);
                ListView listViewC1 = (ListView)view.findViewById(R.id.listmenu);
                listViewC1.setItemsCanFocus(true);
                listViewC1.setAdapter(adapterC1);
                break;
            case 1:
                view = inflater.inflate(getActivity().getResources().getLayout(R.layout.poin_used), container, false);
                ListDataPointResultAdapter adapterC2 = new ListDataPointResultAdapter(view.getContext(), R.layout.list_item_point_used,
                        ListData.listPointUsed(), DataReference.TAG_LIST_POINT_USED);
                ListView listViewC2 = (ListView)view.findViewById(R.id.listmenu);
                listViewC2.setItemsCanFocus(true);
                listViewC2.setAdapter(adapterC2);
                break;
            default:
                break;
        }
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(fragmentKey, slideNumber);
    }
}
