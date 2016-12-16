package com.maedi.user.godok.v1.utils;

import java.util.HashMap;

import com.google.gson.Gson;

import android.support.v4.app.FragmentActivity;

public abstract class BaseTask {
	private FragmentActivity activity;
	private volatile boolean isCanceled;
	private DynamicLoadingContentDialogFragment loadingContentDialog;
	
	abstract protected String getBaseTaskKey();
	abstract protected boolean getBaseShowloadingContentDialog();
	abstract protected String getBaseloadingContentMessage();
	abstract protected String getBaseloadingContentDialogTag();
	
	abstract protected boolean getBaseloadingContentCanceledOnTouchOutside();
	abstract protected boolean getBaseloadingContentCancelable();
	
	public void attachActivity(FragmentActivity a) {
		this.activity = a;
	}

	public void detachActivity() {
		this.activity = null;
	}

	public final void setCanceled() {
		isCanceled = true;
	}
	
	public final boolean isCanceled() {
		return isCanceled;
	}
	
	protected final FragmentActivity getActivity() {
		return activity;
	}
	
	protected final void baseStart() {
		if(loadingContentDialog != null)progressHide();
		TaskHelper.getInstance().addTask(getBaseTaskKey(), this, activity);
		
		if ((activity != null) && (getBaseShowloadingContentDialog())) {
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// SET PROPERTIES OF LOADING CONTENT DIALOG
			// DynamicLoadingContentDialogFragment.newInstance(message, icon, title, setCanceledOnTouchOutside, setCancelable, taskKey)
			// DynamicLoadingContentDialogFragment.newInstance(getBaseloadingContentMessage(), 0, "", 
			// getBaseloadingContentCanceledOnTouchOutside(), getBaseloadingContentCancelable(), getBaseTaskKey())
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			loadingContentDialog = DynamicLoadingContentDialogFragment.newInstance(getBaseloadingContentMessage(), 0, "", 
					getBaseloadingContentCanceledOnTouchOutside(), getBaseloadingContentCancelable(), getBaseTaskKey());
			loadingContentDialog.show(activity.getSupportFragmentManager(), getBaseloadingContentDialogTag());
		}
	}
	
	protected final void baseFinish() {
		if ((activity != null) && (getBaseShowloadingContentDialog())) {
			///////////////////////////////////////////////////////////////////
			// IF FINISH RESPONSE, CLOSE DIALOG
			///////////////////////////////////////////////////////////////////
			loadingContentDialog.dismiss(activity.getSupportFragmentManager());
		}
		TaskHelper.getInstance().removeTask(getBaseTaskKey());
	}
	
	protected final void progressHide() {
		if ((activity != null))
			loadingContentDialog.dismiss(activity.getSupportFragmentManager());
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, String> getJsonResult(String jsonText) throws Exception {
		HashMap<String, String> result = new HashMap<String, String>();
		Gson gson = new Gson();
		result = gson.fromJson(jsonText, result.getClass());
		return result;
	}
}

