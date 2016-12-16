package com.maedi.user.godok.v1.adapter;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.activity.MainNavigationDrawer;
import com.maedi.user.godok.v1.fragment.ArticleContentFragment;
import com.maedi.user.godok.v1.fragment.ChatUserFragment;
import com.maedi.user.godok.v1.fragment.InfoHealthyFragment;
import com.maedi.user.godok.v1.fragment.MyNewsFragment;
import com.maedi.user.godok.v1.model.ListMenu;
import com.maedi.user.godok.v1.model.ListMenuHolder;

/**
 * Created by user on 11/30/2016.
 */

public class ListDataFavoriteAdapter extends ArrayAdapter<ListMenu> {

    Context context;
    FragmentActivity f;
    int layoutResourceId;
    ListMenu data = null;
    ListMenuHolder holder = null;
    String tag, title;
    int rowsize;

    public ListDataFavoriteAdapter(Context context, FragmentActivity f, int layoutResourceId, ListMenu data, String title, String tag) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.f = f;
        this.data = data;
        this.title = title;
        this.tag = tag;
        this.rowsize = data.size();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ListMenuHolder();
            holder.image1 = (ImageView)row.findViewById(R.id.item_image1);
            holder.text = (TextView)row.findViewById(R.id.item_text1);
            holder.text2 = (TextView)row.findViewById(R.id.item_text2);
            holder.text3 = (TextView)row.findViewById(R.id.item_text3);

            row.setTag(holder);

        }
        else
        {
            holder = (ListMenuHolder)row.getTag();
        }

        final ListMenu lm = (ListMenu) data.get(position);

        //holder.image1.setImageResource(lm.imageIcon);
        Glide.with(context)
                .load(lm.imageIcon)
                .asBitmap()
                .placeholder(R.drawable.loading_static)
                .into(holder.image1);
        holder.text.setText(lm.text);
        holder.text2.setText(lm.text2);
        holder.text3.setText(lm.text3);

        row.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //    if(null != tag)
                //        Toast.makeText(context, "Action with tag = "+tag, Toast.LENGTH_LONG).show();
                Runnable mPendingRunnable = new Runnable() {
                    @Override
                    public void run() {
                        // update the main content by replacing fragments
                        Fragment fragment = ArticleContentFragment.newInstance(title, "favorite");
                        FragmentTransaction fragmentTransaction = f.getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                        fragmentTransaction.replace(R.id.frame, fragment, "healthy");//.addToBackStack(null);
                        f.getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        fragmentTransaction.commitAllowingStateLoss();
                    }
                };

                Handler mHandler = new Handler();
                mHandler.post(mPendingRunnable);

            }
        });

        return row;
    }

    @Override
    public int getViewTypeCount() {
        return rowsize;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}
