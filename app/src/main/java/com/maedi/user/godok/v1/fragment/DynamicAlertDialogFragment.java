package com.maedi.user.godok.v1.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;

import com.maedi.user.godok.v1.R;

public class DynamicAlertDialogFragment extends DialogFragment {
	
	String dialogTag;
	String title;
	int icon;
	String message;
	boolean showNegativeButton;
	Context context;
	
	public DynamicAlertDialogFragment() {}

	public static DynamicAlertDialogFragment newInstance(Context context, String title, int icon, String message, boolean showNegativeButton) {		
		DynamicAlertDialogFragment frag = new DynamicAlertDialogFragment();
		if(null != context)frag.context = context;
		frag.title = title;
		frag.icon = icon;
		frag.message = message;
		frag.showNegativeButton = showNegativeButton;
		Bundle args = new Bundle();
		args.putString("title", title);
		args.putString("icon", String.valueOf(icon));
		args.putString("message", message);
		args.putBoolean("showNegativeButton", showNegativeButton);
		frag.setArguments(args);
		return frag;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {						
							
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
		
		// FOR USE MY LAYOUT
		//LayoutInflater inflater = getActivity().getLayoutInflater();
        //View view = inflater.inflate(R.layout.dialog_window, null);
        //alertDialogBuilder.setView(view);

		String title = getArguments().getString("title");
		if(null == title || "".equalsIgnoreCase(title))
			alertDialogBuilder.setTitle(getActivity().getResources().getString(R.string.app_name));
		else
			alertDialogBuilder.setTitle(title);
		
		int icon = Integer.parseInt(getArguments().getString("icon"));
		if(0 == icon)
			icon = R.drawable.ic_launcher;
		
		String message = getArguments().getString("message");
		
		alertDialogBuilder.setMessage(message);
		alertDialogBuilder.setIcon(icon);
		
		alertDialogBuilder.setPositiveButton("OK",  new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
                 // on success
           }
		});
		
		boolean showNegativeButton = getArguments().getBoolean("showNegativeButton");
		if(showNegativeButton){
			alertDialogBuilder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
	           @Override
	           public void onClick(DialogInterface dialog, int which) {
	               dialog.dismiss();
	           }
			});
		}
		
		return alertDialogBuilder.create();
	}
	
	@Override
	public void onActivityCreated(Bundle arg0) {
	    super.onActivityCreated(arg0);        
	    // FOR ANIMATION DIALOG
	    getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogInOut;
	}
	
	@Override 
	public void show(FragmentManager manager, String tag)
	{
		dialogTag = tag;
		super.show(manager, dialogTag);
	}
}
