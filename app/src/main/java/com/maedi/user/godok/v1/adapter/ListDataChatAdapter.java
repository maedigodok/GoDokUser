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
import com.maedi.user.godok.v1.fragment.ChatUserFragment;
import com.maedi.user.godok.v1.model.ListMenu;
import com.maedi.user.godok.v1.model.ListMenuHolder;

/**
 * Created by user on 12/8/2016.
 */

public class ListDataChatAdapter extends ArrayAdapter<ListMenu> {

    Context context;
    int layoutResourceId;
    ListMenu data = null;
    ListMenuHolder holder = null;
    String tag;
    int rowsize;
    FragmentActivity f;

    public ListDataChatAdapter(Context context, FragmentActivity f, int layoutResourceId, ListMenu data, String tag) {
        super(context, layoutResourceId, data);
        if(layoutResourceId != 0)this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
        this.tag = tag;
        this.rowsize = data.size();
        this.f = f;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        final ListMenu lm = (ListMenu) data.get(position);

        if(lm.p1 == 0){
            row = inflater.inflate(R.layout.list_item_message_right, parent, false);

            holder = new ListMenuHolder();
            holder.image1 = (ImageView)row.findViewById(R.id.item_image1);
            holder.text = (TextView)row.findViewById(R.id.item_text1);
            holder.text2 = (TextView)row.findViewById(R.id.item_text2);
            holder.text3 = (TextView)row.findViewById(R.id.item_text3);

            row.setTag(holder);
        }else{
            row = inflater.inflate(R.layout.list_item_message_left, parent, false);

            holder = new ListMenuHolder();
            holder.image1 = (ImageView)row.findViewById(R.id.item_image1);
            holder.text = (TextView)row.findViewById(R.id.item_text1);
            holder.text2 = (TextView)row.findViewById(R.id.item_text2);
            holder.text3 = (TextView)row.findViewById(R.id.item_text3);

            row.setTag(holder);
        }

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

