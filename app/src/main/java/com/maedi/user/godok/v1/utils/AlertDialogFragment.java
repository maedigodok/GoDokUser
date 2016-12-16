package com.maedi.user.godok.v1.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;

import com.maedi.user.godok.v1.R;

public class AlertDialogFragment extends DialogFragment 
{
	private String dialogTag;
	private AlertDialogFragmentListener listener;
	private boolean isBypassCancel;
	
	public interface AlertDialogFragmentListener {
		public void onAlertOKClicked(String senderId, Bundle bundle);
	}
	
	public static class Builder
	{
		private String message;
		private boolean cancelable = true;
		private String senderId;
		private Bundle bundle;

		public Builder setMessage(String message)
		{
			this.message = message;
			return this;
		}

		public Builder setCancelable(boolean cancelable)
		{
			this.cancelable = cancelable;
			return this;
		}

		public Builder setSenderId(String senderId)
		{
			this.senderId = senderId;
			return this;
		}

		public Builder setBundle(Bundle bundle)
		{
			this.bundle = bundle;
			return this;
		}
		
		public AlertDialogFragment build()
		{
			return AlertDialogFragment.newInstance(message, cancelable, senderId, bundle);
		}
	}

	protected static AlertDialogFragment newInstance()
	{
		return newInstance("", true, "", null);
	}

	protected static AlertDialogFragment newInstance(String message, boolean cancelable, String senderId, Bundle bundle)
	{
		AlertDialogFragment frag = new AlertDialogFragment();
		Bundle args = new Bundle();
		args.putString("message", message);
		args.putBoolean("cancelable", cancelable);
		args.putString("senderId", senderId);
		args.putBundle("bundle", bundle);
		frag.setArguments(args);
		return frag;
	}

	public void setListener(AlertDialogFragmentListener listener) {
		this.listener = listener;
	}
	
	@Override public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	}

	@Override public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle(getActivity().getResources().getString(R.string.app_name));
		builder.setIcon(R.drawable.ic_launcher);
		builder.setMessage(getArguments().getString("message"));
		builder.setCancelable(getArguments().getBoolean("cancelable"));
		builder.setNegativeButton("OK",  new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) {
				isBypassCancel = true;
				dialog.cancel();
				if (listener != null) {
					listener.onAlertOKClicked(getArguments().getString("senderId"), getArguments().getBundle("bundle"));
				}
			}
		});
		AlertDialog alert = builder.create();
		return alert;
	}

	@Override public void onCancel(DialogInterface dialog) {
		if (isBypassCancel) {
			isBypassCancel = false;
			return;
		}
		if (listener != null) {
			listener.onAlertOKClicked(getArguments().getString("senderId"), getArguments().getBundle("bundle"));
		}
	};
	
	@Override
	public void onAttach(android.app.Activity activity) {
		super.onAttach(activity);
		if (activity instanceof AlertDialogFragmentListener) {
			setListener((AlertDialogFragmentListener)activity);
		}
	}
	
	public void dismiss(FragmentManager manager)
	{
		AlertDialogFragment dialog = (AlertDialogFragment)manager.findFragmentByTag(dialogTag);
		if (dialog != null)
		{
			dialog.dismiss();
		}
	}

	@Override public void show(FragmentManager manager, String tag)
	{
		dialogTag = tag;
		super.show(manager, dialogTag);
	}
}
