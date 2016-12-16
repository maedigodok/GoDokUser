package com.maedi.user.godok.v1.adapter;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.model.ListMenu;
import com.maedi.user.godok.v1.model.ListMenuHolder;
import android.widget.Toast;

/**
 * Created by user on 11/28/2016.
 */

public class ListDataProfileAdapter extends ArrayAdapter<ListMenu>{

    Context context;
    int layoutResourceId;
    ListMenu data = null;
    ListMenuHolder holder = null;
    String tag;
    int rowsize;

    public ListDataProfileAdapter(Context context, int layoutResourceId, ListMenu data, String tag) {
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
            holder.text = (TextView)row.findViewById(R.id.item_text);
            holder.textfield = (EditText)row.findViewById(R.id.item_textfield);
            holder.spinfield = (Spinner)row.findViewById(R.id.item_spinfield);
            //holder.button = (Button)row.findViewById(R.id.item_button);

            row.setTag(holder);

        }
        else
        {
            holder = (ListMenuHolder)row.getTag();
        }

        ListMenu lm = (ListMenu) data.get(position);

        holder.text.setText(lm.text);
        holder.textfield.setHint(lm.text2);
        if(lm.text.equalsIgnoreCase("Jenis Kelamin")){
            holder.textfield.setVisibility(View.GONE);
            holder.spinfield.setVisibility(View.VISIBLE);
            List<String> list = new ArrayList<String>();
            list.add("Laki Laki");
            list.add("Wanita");

            FormSpinnerAdapter spinnerArray = new FormSpinnerAdapter((Activity) context, R.layout.form_spinner_item, list);
            holder.spinfield.setAdapter(spinnerArray);

        }else if(lm.text.equalsIgnoreCase("Password")){
            holder.textfield.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }

        if(position == 0){
            //holder.button.setVisibility(View.VISIBLE);
            if(lm.text.equalsIgnoreCase("")){
                holder.textfield.requestFocus();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.showSoftInput(holder.textfield, InputMethodManager.SHOW_IMPLICIT);
                    }
                }, 100);

            }
        }

        row.setOnClickListener(new OnClickListener(){
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