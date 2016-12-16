package com.maedi.user.godok.v1.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.maedi.user.godok.v1.R;

public class FormSpinnerAdapter extends ArrayAdapter<String> {

	private Activity context;
    ArrayList<String> data = null;

    public FormSpinnerAdapter(Activity context, int resource, List<String> list)
    {
        super(context, resource, list);
        this.context = context;
        this.data = (ArrayList<String>) list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) 
    {   // Ordinary view in Spinner, we use android.R.layout.simple_spinner_item
        return super.getView(position, convertView, parent);   
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {   // This view starts when we click the spinner.
        View row = convertView;
        if(row == null)
        {
            LayoutInflater inflater = context.getLayoutInflater();
            row = inflater.inflate(R.layout.form_spinner_item, parent, false);
        }

        String item = data.get(position);

        if(item != null)
        {   // Parse the data from each object and set it.
            TextView textData = (TextView) row.findViewById(R.id.form_spinner_item_textview);
            textData.setText(item);
        }

        return row;
    }	
}
