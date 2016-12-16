package com.maedi.user.godok.v1.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.model.ListMenu;
import com.maedi.user.godok.v1.model.ListMenuHolder;

/**
 * Created by user on 12/7/2016.
 */

public class ListDataCommentArticleAdapter extends ArrayAdapter<ListMenu> {

    Context context;
    int layoutResourceId;
    ListMenu data = null;
    ListMenuHolder holder = null;
    String tag;
    int rowsize;

    public ListDataCommentArticleAdapter(Context context, int layoutResourceId, ListMenu data, String tag) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
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
            holder.text4 = (TextView)row.findViewById(R.id.item_text4);
            holder.text5 = (TextView)row.findViewById(R.id.item_text5);
            holder.text6 = (TextView)row.findViewById(R.id.item_text6);
            holder.text7 = (TextView)row.findViewById(R.id.item_text7);
            holder.text8 = (TextView)row.findViewById(R.id.item_text8);

            row.setTag(holder);

        }
        else
        {
            holder = (ListMenuHolder)row.getTag();
        }

        ListMenu lm = (ListMenu) data.get(position);

        //holder.image1.setImageResource(lm.imageIcon);
        Glide.with(context)
                .load(lm.imageIcon)
                .asBitmap()
                .placeholder(R.drawable.loading_static)
                .into(holder.image1);
        holder.text.setText(lm.text);
        holder.text2.setText(lm.text2);
        holder.text3.setText(lm.text3);
        holder.text4.setText(lm.text4);
        holder.text5.setText(lm.text5);
        holder.text6.setText(lm.text6);
        holder.text7.setText(lm.text7);
        holder.text8.setText(lm.text8);

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

