package com.maedi.user.godok.v1.adapter;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.maedi.user.godok.v1.MainActivity;
import com.maedi.user.godok.v1.R;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by user on 11/10/2016.
 */

public class ShareTextAdapter extends BaseAdapter {

    PackageManager pm;
    int layoutResourceId;
    List<ResolveInfo> listApp;
    FragmentActivity fragmentActivity;
    Context context;
    public ShareTextAdapter(Context _context, FragmentActivity _fragmentActivity, int _layoutResourceId, List<ResolveInfo> _listApp){
        fragmentActivity = _fragmentActivity;
        context = _context;
        layoutResourceId = _layoutResourceId;
        listApp = _listApp;
        pm=context.getPackageManager();
    }


    @Override
    public int getCount() {
        return listApp.size();
    }

    @Override
    public Object getItem(int position) {
        return listApp.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            //convertView = LayoutInflater.from(context).inflate(R.layout.share_text, parent, false);
            LayoutInflater inflater = (fragmentActivity).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
            holder.ivLogo = (ImageView) convertView.findViewById(R.id.logo_share);
            holder.tvAppName = (TextView) convertView.findViewById(R.id.app_name);
            holder.tvPackageName = (TextView) convertView.findViewById(R.id.package_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ResolveInfo appInfo = listApp.get(position);
        String aaa = (String) appInfo.loadLabel(pm);
        holder.ivLogo.setImageDrawable(appInfo.loadIcon(pm));
        holder.tvAppName.setText(appInfo.loadLabel(pm));
        holder.tvPackageName.setText(appInfo.activityInfo.packageName);

        return convertView;
    }

    static class ViewHolder {
        ImageView ivLogo;
        TextView tvAppName;
        TextView tvPackageName;
    }
}
