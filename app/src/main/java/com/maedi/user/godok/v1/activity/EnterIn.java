package com.maedi.user.godok.v1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.maedi.user.godok.v1.R;

/**
 * Created by Maedi on 10/20/2016.
 */
public class EnterIn extends Fragment {

    FragmentActivity f;

    public EnterIn() {
    }

    public static EnterIn newInstance() {
        EnterIn fragment = new EnterIn();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.slide_fragment_3, container, false);

        f = (FragmentActivity)view.getContext();
        /*
        Button b = (Button)view.findViewById(R.id.login_button_ok);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(f,RegisterOrLoginActivity.class);
                startActivity(intent);
                f.finish();
            }
        });
        */

        //RelativeLayout enterHome = (RelativeLayout)view.findViewById(R.id.enter_home);
        //enterHome.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        Intent intent = new Intent(f,RegisterOrLoginActivity.class);
        //        startActivity(intent);
        //    }
        //});

        ImageView welcome = (ImageView)view.findViewById(R.id.welcome);
        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(f,RegisterOrLoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
