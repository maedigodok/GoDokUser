package com.maedi.user.godok.v1.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.maedi.user.godok.v1.R;

public class AboutDialogFragment extends DialogFragment {
	private String dialogTag;
	private AboutDialogFragmentListener listener;
	
	public interface AboutDialogFragmentListener {
		public void onAlertOKClicked(String senderId, Bundle bundle);
	}
	
	public static class Builder
	{
		private boolean cancelable = true;
		private String senderId;
		private Bundle bundle;
		private String choiceParameter;

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
		
		public Builder setChoiceParameter(String choiceParameter)
		{
			this.choiceParameter = choiceParameter;
			return this;
		}
		
		public AboutDialogFragment build()
		{
			return AboutDialogFragment.newInstance(cancelable, senderId, bundle, choiceParameter);
		}
	}

	protected static AboutDialogFragment newInstance()
	{
		return newInstance(true, "", null);
	}

	protected static AboutDialogFragment newInstance(boolean cancelable, String senderId, Bundle bundle)
	{
		AboutDialogFragment frag = new AboutDialogFragment();
		Bundle args = new Bundle();
		args.putBoolean("cancelable", cancelable);
		args.putString("senderId", senderId);
		args.putBundle("bundle", bundle);
		frag.setArguments(args);
		return frag;
	}
	
	protected static AboutDialogFragment newInstance(boolean cancelable, String senderId, Bundle bundle, String choiceParameter)
	{
		AboutDialogFragment frag = new AboutDialogFragment();
		Bundle args = new Bundle();
		args.putBoolean("cancelable", cancelable);
		args.putString("senderId", senderId);
		args.putBundle("bundle", bundle);
		args.putString("choiceParameter", choiceParameter);
		frag.setArguments(args);
		return frag;
	}

	public void setListener(AboutDialogFragmentListener listener) {
		this.listener = listener;
	}
	
	@Override public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	}

	@Override public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setNegativeButton("OK",  new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
				if (listener != null) {
					listener.onAlertOKClicked(getArguments().getString("senderId"), getArguments().getBundle("bundle"));
				}
			}
		});
		
		if(getArguments().getString("choiceParameter").equalsIgnoreCase("ABOUT-US")){
			View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_about, null);

			//TextView title = new TextView(view.getContext());
			//title.setText("Go Dok");
			//title.setPadding(10, 10, 10, 10);
			//title.setGravity(Gravity.LEFT);
			//title.setTextColor(getActivity().getResources().getColor(R.color.default_blue));
			//title.setTextSize(24);

	        TextView textVersion = (TextView)view.findViewById(R.id.about_version);
	        textVersion.setText("Versi 1.0.0");
	        
	        TextView textCopyright = (TextView)view.findViewById(R.id.about_copyright);
	        textCopyright.setText("Copyright @ 2016 by Medical A.P. Co.Ltd");
	        
	        TextView textLink1 = (TextView)view.findViewById(R.id.about_link_1);
	        textLink1.setText("www.go-dok.com");
	        
	        TextView textLink2 = (TextView)view.findViewById(R.id.about_link_2);
	        textLink2.setText(getActivity().getResources().getString(R.string.about_link_2));
			
		    builder.setView(view);
		}else if(getArguments().getString("choiceParameter").equalsIgnoreCase("APP-VERSION")){

			//builder.setTitle(getActivity().getResources().getString(R.string.app_name));
		//	builder.setTitle("Go Dok");
		//	builder.setIcon(R.drawable.logo_godok);
		//	builder.setCancelable(getArguments().getBoolean("cancelable"));

			View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_about, null);
			TextView textVersion = (TextView)view.findViewById(R.id.about_version);
			textVersion.setText(getActivity().getResources().getString(R.string.app_version_label) + " 2.0");

			TextView textCopyright = (TextView)view.findViewById(R.id.about_copyright);
			textCopyright.setText(getActivity().getResources().getString(R.string.about_copyright));

			TextView textLink1 = (TextView)view.findViewById(R.id.about_link_1);
			textLink1.setText(getActivity().getResources().getString(R.string.about_link_1));

			TextView textLink2 = (TextView)view.findViewById(R.id.about_link_2);
			textLink2.setText(getActivity().getResources().getString(R.string.about_link_2));

			builder.setView(view);
		}
	    
		AlertDialog alert = builder.create();
		return alert;
	}
	
	@Override
	public void onAttach(android.app.Activity activity) {
		super.onAttach(activity);
		if (activity instanceof AboutDialogFragmentListener) {
			setListener((AboutDialogFragmentListener)activity);
		}
	}
	
	public void dismiss(FragmentManager manager)
	{
		AboutDialogFragment dialog = (AboutDialogFragment)manager.findFragmentByTag(dialogTag);
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
