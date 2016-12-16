package com.maedi.user.godok.v1.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.VideoView;

import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.drawers.viewpagers.ViewPagerActivity;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Maedi on 10/202016.
 */

public class SplashActivity extends FragmentActivity {
	
	private Timer timer;
	private int countBackdoorKey;

	FragmentActivity f;

	//VideoView mVideoView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.zoom_in_from_midle, R.anim.zoom_out_from_midle);

		setContentView(R.layout.activity_splash);
		f = this;
		/*
		mVideoView = (VideoView)findViewById(R.id.splash);
		Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/opening_godok");
		mVideoView.setVideoURI(uri);
		mVideoView.seekTo(0);
		mVideoView.start();
		*/

	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		
		timer = new Timer();

		final Activity finalActivity = this;
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				try {
					Intent intent = new Intent((FragmentActivity)finalActivity,ViewPagerActivity.class);
					//Intent intent = new Intent((FragmentActivity)finalActivity,MainNavigationDrawer.class);
					startActivity(intent);
					f.finish();
				} catch (Exception e) {
				}
			}
		};
		
		timer.schedule(timerTask, 1000);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
	    	f.finish();
	    }
	    return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction() & MotionEvent.ACTION_MASK;
        switch (action) {
	        case MotionEvent.ACTION_UP: {
	            break;
	        }
        }       
        return super.onTouchEvent(event);	
    }
	
	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onStop() {
		super.onStop();
	}
}
