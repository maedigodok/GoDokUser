package com.maedi.user.godok.v1.fragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.activity.MainNavigationDrawer;
import com.maedi.user.godok.v1.adapter.ListDataEventAdapter;
import com.maedi.user.godok.v1.adapter.ListDataFavoriteAdapter;
import com.maedi.user.godok.v1.data.ListData;
import com.maedi.user.godok.v1.utils.DataReference;

/**
 * Created by user on 12/1/2016.
 */

public class EventFragment extends Fragment {

    private FragmentActivity f;
    private ImageView back;
    private TextView txtTitle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event, container, false);
        f = (FragmentActivity)view.getContext();

        back = (ImageView)view.findViewById(R.id.back);
        txtTitle = (TextView)view.findViewById(R.id.txtTitle);
        txtTitle.setText("Event");

        ListDataEventAdapter adapter = new ListDataEventAdapter(view.getContext(), R.layout.list_item_event,
                ListData.listEvent(), DataReference.TAG_LIST_INFO_EVENT);
        ListView listView = (ListView)view.findViewById(R.id.listmenu);
        listView.setItemsCanFocus(true);
        listView.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backHomePage();
            }
        });

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if( keyCode == KeyEvent.KEYCODE_BACK ) {
                    backHomePage();
                    return true;
                } else {
                    return false;
                }
            }
        });

        return view;
    }

    private void backHomePage(){
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = new MyNewsFragment();
                FragmentTransaction fragmentTransaction = f.getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                fragmentTransaction.replace(R.id.frame, fragment, "home");
                getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                fragmentTransaction.commitAllowingStateLoss();
                MainNavigationDrawer.selectHome();
            }
        };

        Handler mHandler = new Handler();
        mHandler.post(mPendingRunnable);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

