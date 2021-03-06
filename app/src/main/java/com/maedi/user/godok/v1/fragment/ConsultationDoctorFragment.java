package com.maedi.user.godok.v1.fragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.activity.MainNavigationDrawer;
import com.maedi.user.godok.v1.adapter.FormSpinnerAdapter;
import com.maedi.user.godok.v1.adapter.ListDataArticleRecyclerAdapter;
import com.maedi.user.godok.v1.data.ListData;
import com.maedi.user.godok.v1.utils.HidingScrollListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12/1/2016.
 */

public class ConsultationDoctorFragment extends Fragment {

    private FragmentActivity f;
    private ImageView back;
    private TextView txtTitle;
    Spinner spin_sector;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.consultation_doctor, container, false);
        f = (FragmentActivity)view.getContext();

        back = (ImageView)view.findViewById(R.id.back);
        txtTitle = (TextView)view.findViewById(R.id.txtTitle);
        txtTitle.setText("Konsultasi Dokter");

        spin_sector = (Spinner) view.findViewById(R.id.spin_sector);

        List<String> list = new ArrayList<String>();
        list.add("Gigi");
        list.add("Tulang");

        FormSpinnerAdapter spinnerArray = new FormSpinnerAdapter(f, R.layout.spinner_item_white, list);
        spin_sector.setAdapter(spinnerArray);

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
