package com.maedi.user.godok.v1.fragment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.activity.MainNavigationDrawer;
import com.maedi.user.godok.v1.adapter.FormSpinnerAdapter;
import com.maedi.user.godok.v1.adapter.ShareTextAdapter;
import com.maedi.user.godok.v1.utils.DataReference;
import com.maedi.user.godok.v1.utils.DataScreenSize;

public class DynamicDialogSelfLayoutFragment extends DialogFragment {
	
	String dialogTag;
	boolean screenSize;
	private RelativeLayout mainLayout;
	
	DataScreenSize dsc;	
	Context ctx;
	
	FragmentActivity fragmentActivity;
	String tag;
	
	public DynamicDialogSelfLayoutFragment() {}

	public static DynamicDialogSelfLayoutFragment newInstance(FragmentActivity fragmentActivity, boolean screenSize, String tag) {		
		DynamicDialogSelfLayoutFragment frag = new DynamicDialogSelfLayoutFragment();
		if(null != fragmentActivity)frag.fragmentActivity = fragmentActivity;
		frag.screenSize = screenSize;
		frag.tag = tag;
		return frag;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		View view = null;
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        if(tag.equalsIgnoreCase(DataReference.TAG_ASK_DOCTOR)){
        	view = inflater.inflate(R.layout.ask_doctor, container);
        	
        	mainLayout = (RelativeLayout)view.findViewById(R.id.main_layout);
        	
        	DataReference.setMapBroadcastReceiver().clear();
        	
        	final EditText desc = (EditText)view.findViewById(R.id.desc);
			EditText age = (EditText)view.findViewById(R.id.age);
			Spinner sgender = (Spinner) view.findViewById(R.id.spin_gender);

			List<String> list = new ArrayList<String>();
			list.add("Laki Laki");
			list.add("Wanita");

			FormSpinnerAdapter spinnerArray = new FormSpinnerAdapter(fragmentActivity, R.layout.form_spinner_item, list);
			sgender.setAdapter(spinnerArray);

			desc.requestFocus();
    		Handler handler = new Handler();
			handler.postDelayed(new Runnable() {
				@Override
				public void run() {
					InputMethodManager imm = (InputMethodManager)fragmentActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.showSoftInput(desc, InputMethodManager.SHOW_IMPLICIT);
				}
			}, 100);
        	      	
        	Button back = (Button)view.findViewById(R.id.submit);
    		back.setOnClickListener(new OnClickListener(){
            	@Override
    			public void onClick(View v) {
            		getDialog().dismiss();           		
    			}
            });

        }else if(tag.equalsIgnoreCase(DataReference.TAG_SHARE_TEXT)){
			view = inflater.inflate(R.layout.share_text, container, false);
			mainLayout = (RelativeLayout)view.findViewById(R.id.main_layout);
			//fragmentActivity = (FragmentActivity)view.getContext();
			GridView gridShareText;
			gridShareText = (GridView) view.findViewById(R.id.gridShareText);
			final List<ResolveInfo> listApp = showAllShareApp();
			if (listApp != null) {
				gridShareText.setAdapter(new ShareTextAdapter(view.getContext(), fragmentActivity, R.layout.share_item_gallery, listApp));
				gridShareText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
						share(listApp.get(position));
					}
				});
			}
		}else if(tag.equalsIgnoreCase(DataReference.TAG_FIND_DOCTOR)){
			view = inflater.inflate(R.layout.dialog_default_app, container);

			mainLayout = (RelativeLayout)view.findViewById(R.id.main_layout);
			TextView title = (TextView)view.findViewById(R.id.txt_title);
			title.setText("Perlu 20 poin untuk berkonsultasi\ndengan dokter pilihan.\nMulai sekarang?");
			Button ok = (Button)view.findViewById(R.id.yes);
			ok.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Runnable mPendingRunnable = new Runnable() {
						@Override
						public void run() {
							// update the main content by replacing fragments
							Fragment fragment = new DoctorsFragment();
							FragmentTransaction fragmentTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
							fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
							fragmentTransaction.replace(R.id.frame, fragment, "select_doctors");
							getFragmentManager().popBackStack(null, android.app.FragmentManager.POP_BACK_STACK_INCLUSIVE);
							fragmentTransaction.commitAllowingStateLoss();
							MainNavigationDrawer.selectHome();
						}
					};

					Handler mHandler = new Handler();
					mHandler.post(mPendingRunnable);
					getDialog().dismiss();
				}
			});
			Button bCancel = (Button)view.findViewById(R.id.not);
			bCancel.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					getDialog().dismiss();
				}
			});
		}
        
        return view;
    }
	
	@Override
	public void onActivityCreated(Bundle arg0) {
	    super.onActivityCreated(arg0);    
	    
	    if(screenSize){	     		    	
	        getDialog().getWindow().setLayout(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
	    	//fullscreen without statusbar
	    	//getDialog().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    }else{
			mainLayout.measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			int hmainLayout = 0;
			if(tag.equalsIgnoreCase(DataReference.TAG_FIND_DOCTOR)){
				hmainLayout = mainLayout.getMeasuredHeight()+DataScreenSize.PixelToDP(fragmentActivity, 15);
			}else {
				WindowManager.LayoutParams params = getDialog().getWindow().getAttributes();
				if (tag.equalsIgnoreCase(DataReference.TAG_SHARE_TEXT))
					params.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
				else params.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
				getDialog().getWindow().setAttributes(params);
				hmainLayout = mainLayout.getMeasuredHeight();
			}
			getDialog().getWindow().setLayout(LayoutParams.MATCH_PARENT, hmainLayout);
	    }
	    
	    // FOR ANIMATION DIALOG
		if(tag.equalsIgnoreCase(DataReference.TAG_SHARE_TEXT))getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogInOutFromCorner;
		else if(tag.equalsIgnoreCase(DataReference.TAG_FIND_DOCTOR)) getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogSlideFromRight;
		else getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogInOut;
	}
	
	@Override 
	public void show(FragmentManager manager, String tag)
	{
		dialogTag = tag;
		super.show(manager, dialogTag);
	}
	
	@Override
	public void onDismiss(DialogInterface dialogInterface) {
	    super.dismiss();
	}

	private void share(ResolveInfo appInfo) {
		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
		if (appInfo != null) {
			sendIntent
					.setComponent(new ComponentName(
							appInfo.activityInfo.packageName,
							appInfo.activityInfo.name));
		}
		sendIntent.setType("text/plain");
//        startActivity(Intent.createChooser(sendIntent, "Share"));
		startActivity(sendIntent);
	}

	private List<ResolveInfo> showAllShareApp() {
		List<ResolveInfo> mApps = new ArrayList<ResolveInfo>();
		Intent intent = new Intent(Intent.ACTION_SEND, null);
		intent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
		intent.setType("text/plain");
		//PackageManager pManager = f.getPackageManager();
		//mApps = pManager.queryIntentActivities(intent,
		//        COMPONENT_ENABLED_STATE_DEFAULT);

		List<ResolveInfo> resInfo = fragmentActivity.getPackageManager().queryIntentActivities(intent, 0);
		if (!resInfo.isEmpty()) {
			for (ResolveInfo resolveInfo : resInfo) {
				String packageName = resolveInfo.activityInfo.packageName;
				Log.i("PACKAGE_NAME", packageName);
				//if (packageName.contains("facebook") ||
				//		packageName.contains("twitter") ||
				//		packageName.contains("bbm") ||
				//		packageName.contains("gmail") ||
				//		packageName.contains("email") ||
				//		packageName.contains("whatsapp") ||
				//		packageName.contains("hangeouts") ||
				//		packageName.contains("com.google.android.apps.plus") ||
				//		packageName.contains("kakao.talk") ||
				//		packageName.contains("com.beetalk") ||
				//		packageName.contains("org.telegram.messanger")) {
				//	mApps.add(resolveInfo);
				//}
				if (!packageName.contains("lenovo") ||
						!packageName.contains("samsung") ||
						!packageName.contains("sony") ||
						!packageName.contains("oppo") ||
						!packageName.contains("xiaomi") ||
						!packageName.contains("advance")) {
					mApps.add(resolveInfo);
				}
			}
		}
		return mApps;
	}
}
