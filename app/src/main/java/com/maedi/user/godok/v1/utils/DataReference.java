package com.maedi.user.godok.v1.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Intent;

public class DataReference {

	public static int FLAG_CLEAR_TOP = Intent.FLAG_ACTIVITY_CLEAR_TOP;
	
	public static int FLAG_NEW_TASK = Intent.FLAG_ACTIVITY_NEW_TASK;

	public static String TAG_ASK_DOCTOR = "ASK-DOCTOR";

	public static String TAG_SHARE_TEXT = "SHARE-TEXT";

	public static String TAG_FIND_DOCTOR = "FIND-DOCTOR";
	
	public static String exitApp = "DESTROY-APP";

	public static String TAG_LIST_PROFILE = "LIST_PROFILE";

	public static String TAG_LIST_MYQUESTION = "MYQUESTION";

	public static String TAG_LIST_POINT_RESULT = "POINT-RESULT";

	public static String TAG_LIST_POINT_USED = "POINT-USED";

	public static String TAG_LIST_INFO_HEALTHY = "INFO-HEALTHY";

	public static String TAG_LIST_INFO_EVENT = "EVENT";

	public static String TAG_LIST_ARTICLE = "ARTICLE";

	public static String TAG_LIST_DOCTORS = "DOCTOR";

	public static String TAG_LIST_COMMENT_ARTICLE = "COMMENT-ARTICLE";

	public static String TAG_LIST_CHAT = "CHAT";
	
	public static Map<Integer, ArrayList<String>> mapBroadcastReceiver;
	
	@SuppressLint("UseSparseArrays")
	public static Map<Integer, ArrayList<String>> setMapBroadcastReceiver(){
		if(null == mapBroadcastReceiver)
			mapBroadcastReceiver = new HashMap<Integer, ArrayList<String>>();
		
		return mapBroadcastReceiver;
	}
	
	public static enum LeftMenuRowTitle{
		KABAR,
	    OBROL,
	    KONTAK,
	    GRUPS,
	    RASA,
	    UNDANG
	}
	

//	public static String getClassName(Class<?> c) {
//		String FQClassName = c.getName();
//	    int firstChar;
//	    firstChar = FQClassName.lastIndexOf ('.') + 1;
//	    if ( firstChar > 0 ) {
//	    	FQClassName = FQClassName.substring ( firstChar );
//	    }
//	    return FQClassName;
//	}

}
