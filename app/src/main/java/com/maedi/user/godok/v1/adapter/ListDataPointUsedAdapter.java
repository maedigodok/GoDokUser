package com.maedi.user.godok.v1.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.model.ListMenu;
import com.maedi.user.godok.v1.model.ListMenuHolder;

/**
 * Created by user on 11/30/2016.
 */

public class ListDataPointUsedAdapter extends ArrayAdapter<ListMenu> {

    Context context;
    int layoutResourceId;
    ListMenu data = null;
    ListMenuHolder holder = null;
    String tag;
    int rowsize;

    public ListDataPointUsedAdapter(Context context, int layoutResourceId, ListMenu data, String tag) {
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
            holder.text = (TextView)row.findViewById(R.id.item_text1);
            holder.text2 = (TextView)row.findViewById(R.id.item_text2);
            holder.button = (Button) row.findViewById(R.id.button1);

            row.setTag(holder);

        }
        else
        {
            holder = (ListMenuHolder)row.getTag();
        }

        ListMenu lm = (ListMenu) data.get(position);

        holder.text.setText(lm.text);
        holder.text2.setText(lm.text2);
        holder.button.setText(lm.text3);

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

