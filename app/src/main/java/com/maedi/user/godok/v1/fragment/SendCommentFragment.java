package com.maedi.user.godok.v1.fragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.activity.MainNavigationDrawer;
import com.maedi.user.godok.v1.utils.DialogUtil;

/**
 * Created by user on 11/10/2016.
 */

public class SendCommentFragment extends Fragment implements DatePickerDialogFragment.DatePickerDialogFragmentListener {
    // TODO: Rename parameter arguments, choose names that match

    private EditText ename, ebirthday, etelp, ecomment;
    private ImageButton pickdate;

    private FragmentActivity f;
    private ImageView back;
    private TextView txtTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comment, container, false);
        f = (FragmentActivity)view.getContext();

        back = (ImageView)view.findViewById(R.id.back);
        txtTitle = (TextView)view.findViewById(R.id.txtTitle);
        txtTitle.setText("Komentar");
        pickdate = (ImageButton)view.findViewById(R.id.date_search);

        ename = (EditText)view.findViewById(R.id.ename);
        ebirthday = (EditText)view.findViewById(R.id.ebirthday);
        etelp = (EditText)view.findViewById(R.id.etelp);
        ecomment = (EditText)view.findViewById(R.id.ecomment);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backHomePage();
            }
        });

        pickdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLaunchDatePicker();
            }
        });

        return view;
    }

    public void doLaunchDatePicker() {
        Bundle bundle = new Bundle();
        DialogUtil.datePicker(f, ebirthday.getText().toString(), this, "DatePicker", bundle);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDateSet(String date, String senderId, Bundle bundle) {
        if (senderId == null) return;
        if (senderId.equals("DatePicker")) {
            ebirthday.setText(date);
            return;
        }
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
}

