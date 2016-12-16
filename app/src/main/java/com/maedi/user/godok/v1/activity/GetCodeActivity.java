package com.maedi.user.godok.v1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.maedi.user.godok.v1.R;

/**
 * Created by user on 10/31/2016.
 */

public class GetCodeActivity extends AppCompatActivity {
    FragmentActivity fragmentActivity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestcode);
        fragmentActivity = this;

        Button b = (Button)findViewById(R.id.req_code);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fragmentActivity,SendCodeActivity.class);
                startActivity(intent);
                fragmentActivity.finish();
            }
        });

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
