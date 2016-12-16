package com.maedi.user.godok.v1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Spinner;

import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.adapter.FormSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maedi on 10/20/2016.
 */
public class ProfileActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(name);

        loadBackdrop(this);

        Spinner sgender = (Spinner) findViewById(R.id.spin_gender);
        List<String> list = new ArrayList<String>();
        list.add("Laki Laki");
        list.add("Wanita");

        FormSpinnerAdapter spinnerArray = new FormSpinnerAdapter(this, R.layout.form_spinner_item, list);
        sgender.setAdapter(spinnerArray);

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    private void loadBackdrop(Activity a) {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        imageView.setImageDrawable(ContextCompat.getDrawable(a, R.drawable.logo_godok));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            //action for navigation back(icon right toolbar)
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        /*
        if (navItemIndex != 0) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            com.maedi.user.godok.v1.activity.MainNavigationDrawer.loadHomeFragment();
            return;
        }
        */
        super.onBackPressed();
    }
}
