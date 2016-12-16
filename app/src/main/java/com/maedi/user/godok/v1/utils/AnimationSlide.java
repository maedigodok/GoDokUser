package com.maedi.user.godok.v1.utils;

import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

public class AnimationSlide {
	
	public static Animation fromTopToBottom(float startScale, float endScale) {
	    Animation anim = new ScaleAnimation(
	            1f, 1f, // Start and end values for the X axis scaling
	            startScale, endScale, // Start and end values for the Y axis scaling
	            Animation.RELATIVE_TO_SELF, 1f, // Pivot point of X scaling
	            Animation.RELATIVE_TO_SELF, 0f); // Pivot point of Y scaling
	    anim.setFillAfter(true); // Needed to keep the result of the animation
	    anim.setDuration(400);
	    return anim;
	}

	public static Animation inFromBottomToTop(float startScale, float endScale) {
		Animation anim = new ScaleAnimation(
				1f, 1f, // Start and end values for the X axis scaling
				startScale, endScale, // Start and end values for the Y axis scaling
				Animation.RELATIVE_TO_SELF, 0f, // Pivot point of X scaling
				Animation.RELATIVE_TO_SELF, 1f); // Pivot point of Y scaling
		anim.setFillAfter(true); // Needed to keep the result of the animation
		anim.setDuration(400);
		return anim;
	}
	
	public static Animation outFromBottomToTop(float startScale, float endScale) {
	    Animation anim = new ScaleAnimation(
	            1f, 1f, // Start and end values for the X axis scaling
	            startScale, endScale, // Start and end values for the Y axis scaling
	            Animation.RELATIVE_TO_SELF, 0f, // Pivot point of X scaling
	            Animation.RELATIVE_TO_SELF, 0f); // Pivot point of Y scaling
	    anim.setFillAfter(true); // Needed to keep the result of the animation
	    anim.setDuration(400);
	    return anim;
	}
	
}
