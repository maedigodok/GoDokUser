package com.maedi.user.godok.v1.utils;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.maedi.user.godok.v1.fragment.DatePickerDialogFragment;

public class DialogUtil {

	public static void alert(FragmentActivity activity, String text, AlertDialogFragment.AlertDialogFragmentListener listener, String senderId, Bundle bundle) {
		String tag = RandomUtil.random() + "---" + text;
		AlertDialogFragment dialog = new AlertDialogFragment.Builder().setMessage(text).setSenderId(senderId).setBundle(bundle).build();
		dialog.setListener(listener);
		dialog.show(activity.getSupportFragmentManager(), tag);
	}

	public static void about(FragmentActivity activity, AboutDialogFragment.AboutDialogFragmentListener listener, String senderId, Bundle bundle, String choiceParameter) {
		String tag = RandomUtil.random();
		AboutDialogFragment dialog = new AboutDialogFragment.Builder().setSenderId(senderId).setBundle(bundle).setChoiceParameter(choiceParameter).build();
		dialog.setListener(listener);
		dialog.show(activity.getSupportFragmentManager(), tag);
	}

	public static void datePicker(FragmentActivity activity, String date, DatePickerDialogFragment.DatePickerDialogFragmentListener listener, String senderId, Bundle bundle) {
		String tag = RandomUtil.random() + "---" + date;
		DatePickerDialogFragment dialog = new DatePickerDialogFragment.Builder().setDate(date).setSenderId(senderId).setBundle(bundle).build();
		dialog.setListener(listener);
		dialog.show(activity.getSupportFragmentManager(), tag);
	}

}
