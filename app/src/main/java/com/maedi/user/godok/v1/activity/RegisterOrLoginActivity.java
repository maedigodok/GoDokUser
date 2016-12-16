package com.maedi.user.godok.v1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.maedi.user.godok.v1.R;

/**
 * Created by user on 12/14/2016.
 */

public class RegisterOrLoginActivity extends AppCompatActivity {
    FragmentActivity fragmentActivity;
    Button reg, login;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_first);
        fragmentActivity = this;

        reg = (Button)findViewById(R.id.register);
        login = (Button)findViewById(R.id.login);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fragmentActivity,GetCodeActivity.class);
                startActivity(intent);
                fragmentActivity.finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fragmentActivity,ActivityLoginHome.class);
                startActivity(intent);
                fragmentActivity.finish();
            }
        });

        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
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
