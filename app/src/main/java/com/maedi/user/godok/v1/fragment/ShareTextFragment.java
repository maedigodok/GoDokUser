package com.maedi.user.godok.v1.fragment;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.maedi.user.godok.v1.R;

import java.util.ArrayList;
import java.util.List;
import com.maedi.user.godok.v1.adapter.ShareTextAdapter;

import static android.content.pm.PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
import static android.content.pm.PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
import static android.content.pm.PackageManager.MATCH_DEFAULT_ONLY;

/**
 * Created by user on 11/10/2016.
 */

public class ShareTextFragment extends Fragment {
    FragmentActivity f;

    private GridView gridShareText;
    private List<ResolveInfo> listApp;

    public ShareTextFragment() {
        // Required empty public constructor
    }

    public static ShareTextFragment newInstance() {
        ShareTextFragment fragment = new ShareTextFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.share_text, container, false);
        f = (FragmentActivity)view.getContext();
        gridShareText = (GridView) view.findViewById(R.id.gridShareText);
        listApp = showAllShareApp();
        if (listApp != null) {
            gridShareText.setAdapter(new ShareTextAdapter(f, f, R.layout.share_item_gallery, listApp));
            gridShareText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    share(listApp.get(position));
                }
            });
        }

        return view;
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
        intent.putExtra(Intent.EXTRA_TEXT, "sample:www.go-dok.com");
        intent.setType("text/plain");
        //PackageManager pManager = f.getPackageManager();
        //mApps = pManager.queryIntentActivities(intent,
        //        COMPONENT_ENABLED_STATE_DEFAULT);

        List<ResolveInfo> resInfo = f.getPackageManager().queryIntentActivities(intent, 0);
        if (!resInfo.isEmpty()) {
            for (ResolveInfo resolveInfo : resInfo) {
                String packageName = resolveInfo.activityInfo.packageName;
                Log.i("PACKAGE_NAME", packageName);
                if (packageName.contains("facebook") ||
                        packageName.contains("twitter") ||
                        packageName.contains("bbm") ||
                        packageName.contains("gmail") ||
                        packageName.contains("email") ||
                        packageName.contains("whatsapp") ||
                        packageName.contains("hangeouts") ||
                        packageName.contains("com.google.android.apps.plus") ||
                        packageName.contains("kakao.talk") ||
                        packageName.contains("com.beetalk") ||
                        packageName.contains("org.telegram.messanger")) {
                    mApps.add(resolveInfo);
                }
            }
        }
        return mApps;
    }

}
