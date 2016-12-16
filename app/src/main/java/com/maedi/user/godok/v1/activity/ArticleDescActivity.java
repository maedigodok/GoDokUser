package com.maedi.user.godok.v1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.TextView;

import com.maedi.user.godok.v1.R;

/**
 * Created by user on 11/11/2016.
 */

public class ArticleDescActivity extends AppCompatActivity {
    FragmentActivity fragmentActivity;

    TextView title;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_fragment_1);
        fragmentActivity = this;

        title = (TextView) findViewById(R.id.title);
        overridePendingTransition(R.anim.slide_in_right, R.anim.zoom_out_from_midle);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
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

