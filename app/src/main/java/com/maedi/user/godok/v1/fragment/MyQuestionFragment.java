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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.activity.MainNavigationDrawer;
import com.maedi.user.godok.v1.adapter.FormSpinnerAdapter;
import com.maedi.user.godok.v1.adapter.ListDataMyQuestionAdapter;
import com.maedi.user.godok.v1.data.ListData;
import com.maedi.user.godok.v1.model.ListMenu;
import com.maedi.user.godok.v1.utils.DataReference;
import com.maedi.user.godok.v1.utils.DialogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11/29/2016.
 */

public class MyQuestionFragment extends Fragment {

    private FragmentActivity f;
    private ImageView back;
    private TextView txtTitle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_question, container, false);
        f = (FragmentActivity)view.getContext();

        back = (ImageView)view.findViewById(R.id.back);
        txtTitle = (TextView)view.findViewById(R.id.txtTitle);
        txtTitle.setText("Pertanyaan Saya");

        ListDataMyQuestionAdapter adapter = new ListDataMyQuestionAdapter(view.getContext(), f, R.layout.list_item_myquestion,
                                                                            ListData.listMyQuestion(), DataReference.TAG_LIST_MYQUESTION);
        ListView listView = (ListView)view.findViewById(R.id.listmenu);
        listView.setItemsCanFocus(true);
        listView.setAdapter(adapter);

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
                backHomePage();
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

