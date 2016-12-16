package com.maedi.user.godok.v1.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.activity.MainNavigationDrawer;
import com.maedi.user.godok.v1.activity.SendCodeActivity;
import com.maedi.user.godok.v1.adapter.FormSpinnerAdapter;
import com.maedi.user.godok.v1.adapter.ListDataProfileAdapter;
import com.maedi.user.godok.v1.data.ListData;
import com.maedi.user.godok.v1.model.ListMenu;
import com.maedi.user.godok.v1.utils.DataReference;
import com.maedi.user.godok.v1.utils.DialogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11/25/2016.
 */

public class ProfileFragment extends Fragment implements DatePickerDialogFragment.DatePickerDialogFragmentListener {

    private FragmentActivity f;

    private TextView name, birthday, gender, provinsi, height, weight, goldar, email, password;
    private EditText ename, ebirthday, eprovinsi, eheight, eweight, egoldar, e_email, epassword;
    private Spinner sgender;
    private ImageView back;
    private ImageButton pickdate;
    private TextView txtTitle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_user, container, false);
        f = (FragmentActivity)view.getContext();

//        ListDataProfileAdapter adapter = new ListDataProfileAdapter(view.getContext(), R.layout.list_item_profile, ListData.listProfile(), DataReference.TAG_LIST_PROFILE);
//        ListView listView = (ListView)view.findViewById(R.id.listmenu);
//        listView.setItemsCanFocus(true);
//        listView.setAdapter(adapter);

        back = (ImageView)view.findViewById(R.id.back);
        pickdate = (ImageButton)view.findViewById(R.id.date_search);
        txtTitle = (TextView)view.findViewById(R.id.txtTitle);
        name = (TextView)view.findViewById(R.id.title1);
        birthday = (TextView)view.findViewById(R.id.title2);
        gender = (TextView) view.findViewById(R.id.title3);
        provinsi = (TextView)view.findViewById(R.id.title4);
        height = (TextView)view.findViewById(R.id.title5);
        weight = (TextView)view.findViewById(R.id.title6);
        goldar = (TextView)view.findViewById(R.id.title7);
        email = (TextView)view.findViewById(R.id.title8);
        password = (TextView)view.findViewById(R.id.title9);

        ename = (EditText)view.findViewById(R.id.edtext1);
        ebirthday = (EditText)view.findViewById(R.id.edtext2);
        sgender = (Spinner)view.findViewById(R.id.spin_gender);
        eprovinsi = (EditText)view.findViewById(R.id.edtext4);
        eheight = (EditText)view.findViewById(R.id.edtext5);
        eweight = (EditText)view.findViewById(R.id.edtext6);
        egoldar = (EditText)view.findViewById(R.id.edtext7);
        e_email = (EditText)view.findViewById(R.id.edtext8);
        epassword = (EditText)view.findViewById(R.id.edtext9);

        txtTitle.setText("Profile Saya");

        ListMenu lm = ListData.listProfile().get(0);

        for(int i=0; i<ListData.listProfile().size(); i++){
            lm = ListData.listProfile().get(i);

            switch(i){
                case 0 :
                    name.setText(lm.text);
                    ename.setHint(lm.text2);
                    break;
                case 1 :
                    birthday.setText(lm.text);
                    ebirthday.setHint(lm.text2);
                    break;
                case 2 :
                    gender.setText(lm.text);
                    List<String> list = new ArrayList<String>();
                    list.add("Laki Laki");
                    list.add("Wanita");

                    FormSpinnerAdapter spinnerArray = new FormSpinnerAdapter(f, R.layout.form_spinner_item, list);
                    sgender.setAdapter(spinnerArray);
                    break;
                case 3 :
                    provinsi.setText(lm.text);
                    eprovinsi.setHint(lm.text2);
                    break;
                case 4 :
                    height.setText(lm.text);
                    eheight.setHint(lm.text2);
                    break;
                case 5 :
                    weight.setText(lm.text);
                    eweight.setHint(lm.text2);
                    break;
                case 6 :
                    goldar.setText(lm.text);
                    egoldar.setHint(lm.text2);
                    break;
                case 7 :
                    email.setText(lm.text);
                    e_email.setHint(lm.text2);
                    break;
                case 8 :
                    password.setText(lm.text);
                    epassword.setHint(lm.text2);
                    break;
            }
        }
        /*
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(ename, InputMethodManager.SHOW_IMPLICIT);
            }
        }, 100);
        */

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //f.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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
