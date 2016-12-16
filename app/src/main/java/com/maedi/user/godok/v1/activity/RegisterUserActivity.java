package com.maedi.user.godok.v1.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.drawers.navigationdrawers.NavigationDrawerWithAccountsActivity;
import com.maedi.user.godok.v1.drawers.navigationdrawers.NavigationDrawerWithAccountsAndFullHeightActivity;
import com.maedi.user.godok.v1.utils.DataScreenSize;

/**
 * Created by user on 10/31/2016.
 */

public class RegisterUserActivity extends AppCompatActivity {
    FragmentActivity fragmentActivity;

    EditText username, useremail, katasandi;
    RelativeLayout lcreg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        fragmentActivity = this;

        username = (EditText) findViewById(R.id.username);
        useremail = (EditText) findViewById(R.id.useremail);
        katasandi = (EditText) findViewById(R.id.katasandi);

        Button b = (Button)findViewById(R.id.registeruser);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(fragmentActivity,NavigationDrawerWithAccountsAndFullHeightActivity.class);
                Intent intent = new Intent(fragmentActivity, MainNavigationDrawer.class);
                startActivity(intent);
                fragmentActivity.finish();
            }
        });

        lcreg = (RelativeLayout)findViewById(R.id.layout_creg);
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        DataScreenSize ds = new DataScreenSize(this);
        int heightScreen = ds.getHeight();
        Log.i("heightScreen", ""+heightScreen);
        int plusHg = ds.DpToPixel(80, this);
        int mtopMdpi = 300+plusHg;//px
        int mtopHdpi = 440+plusHg;
        int mtopXhdpi = 586+plusHg;
        int mtopXXhdpi = 880+plusHg;

        if(heightScreen <= 800)
            p.setMargins(0, mtopMdpi, 0, 0);
        else if(heightScreen > 800 & heightScreen <= 1280)
            p.setMargins(0, mtopHdpi, 0, 0);//left,top,right,bottom

        lcreg.setLayoutParams(p);

        //username.requestFocus();
        //Handler handler = new Handler();
        //handler.postDelayed(new Runnable() {
        //    @Override
        //    public void run() {
        //        InputMethodManager imm = (InputMethodManager)fragmentActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        //        imm.showSoftInput(username, InputMethodManager.SHOW_IMPLICIT);
        //    }
        //}, 100);

        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("onActivityResult", "" + requestCode);
        switch (requestCode) {
            case 200:
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
        }
        return super.onKeyDown(keyCode, event);
    }
}
