package com.maedi.user.godok.v1.utils;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;

import com.maedi.user.godok.v1.R;

public class DynamicLoadingContentDialogFragment extends DialogFragment {
	
	String dialogTag;
	String title;
	int icon;
	String message;
	String taskKey;
	ProgressDialog dialog;
	
	public DynamicLoadingContentDialogFragment() {}

	public static DynamicLoadingContentDialogFragment newInstance(String title, int icon, String message, boolean cancelableOnTouchOutside, boolean cancelable, String taskKey) {		
		DynamicLoadingContentDialogFragment frag = new DynamicLoadingContentDialogFragment();
		frag.title = title;
		frag.icon = icon;
		frag.message = message;
		frag.taskKey = taskKey;
		Bundle args = new Bundle();
		args.putString("title", title);
		args.putString("icon", String.valueOf(icon));
		args.putString("message", message);
		args.putBoolean("cancelableOnTouchOutside", cancelableOnTouchOutside);
		args.putBoolean("cancelable", cancelable);
		args.putString("taskKey", taskKey);
		frag.setArguments(args);
		return frag;
	}

	@SuppressLint("InflateParams")
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {						
				
		//FOR USE MY LAYOUT
		dialog = new ProgressDialog(getActivity()){
			@Override
	        public void onBackPressed() {
				dialog.setCancelable(getArguments().getBoolean("cancelable"));
	        }
		};
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View view = inflater.inflate(R.layout.dialog_loading_content_window, null);
		////////////////////////////////////////////////////////////////////////
		// CALL DIALOG SHOW BEFORE SET CONTENT VIEW TO PREVENT
		// ERROR error : "requestFeature() must be called before adding content"
		////////////////////////////////////////////////////////////////////////
		dialog.setCanceledOnTouchOutside(getArguments().getBoolean("cancelableOnTouchOutside"));
		dialog.setCancelable(getArguments().getBoolean("cancelable"));
		dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
		dialog.show();
		dialog.setContentView(view);
		
		dialog.setIndeterminate(true);
		
		return dialog;
	}
	
	@Override 
	public void onCancel(android.content.DialogInterface dialog) {
		super.onCancel(dialog);
		Log.i("onCancel TASK KEY",""+taskKey);
		if (taskKey != null) {
			BaseTask baseTask = TaskHelper.getInstance().getTask(taskKey);
			Log.i("onCancel BASK TASK 1",""+baseTask);
			if (baseTask != null) {
				//////////////////////////////////////////////////////////////////
				// SET CANCEL = TRUE FOR IMPLEMENT TaskListener IN onTaskFinished
				//////////////////////////////////////////////////////////////////
				baseTask.setCanceled();
				Log.i("onCancel BASE TASK Load",""+baseTask.isCanceled());
			}			
		}
		//////////////////////////////////////////////////////////////////////////
		// IF WE WANT TO HANDLE ON TOUCH SCREEN (ON CANCEL)
		//////////////////////////////////////////////////////////////////////////
		Log.i("onCancel Dynamic Load","True");
		//////////////////////////////////////////////////////////////////////////
	};

	/**
	 * Dismisses the dialog from the fragment manager. We need to make sure we get the right dialog reference
	 * here which is why we obtain the dialog fragment manually from the fragment manager
	 * @param manager
	 */
	public void dismiss(FragmentManager manager)
	{
		DynamicLoadingContentDialogFragment dialog = (DynamicLoadingContentDialogFragment)manager.findFragmentByTag(dialogTag);
		if (dialog != null)
		{			
			dialog.dismiss();
			Log.i("==dialog==","not null");
		}else{
			super.dismiss();
			Log.i("==dialog==","null > dialogTag == "+dialogTag);
		}
	}
	
	@Override 
	public void show(FragmentManager manager, String tag)
	{
		dialogTag = tag;
		super.show(manager, dialogTag);
	}
}
