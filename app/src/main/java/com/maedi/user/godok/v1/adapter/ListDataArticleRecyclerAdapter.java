package com.maedi.user.godok.v1.adapter;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.model.ListMenu;
import com.maedi.user.godok.v1.model.ListMenuHolder;
/**
 * Created by user on 12/1/2016.
 */

public class ListDataArticleRecyclerAdapter extends RecyclerView.Adapter<ListDataArticleRecyclerAdapter.ViewHolder> {

    private ListMenu mValues;
    private Context context;

    public ListDataArticleRecyclerAdapter(Context context, ListMenu items) {
        this.context = context;
        this.mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_article, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder vholder, int position) {
        ListMenu lm = (ListMenu) mValues.get(position);
        //vholder.holder.image1.setImageResource(lm.imageIcon);
        Glide.with(context)
                .load(lm.imageIcon)
                .asBitmap()
                .placeholder(R.drawable.loading_static)
                .into(vholder.holder.image1);
        vholder.holder.text.setText(lm.text);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public final View row;
        ListMenuHolder holder = null;

        public ViewHolder(View view) {
            super(view);
            row = view;

            holder = new ListMenuHolder();
            holder.image1 = (ImageView) row.findViewById(R.id.item_image1);
            holder.text = (TextView) row.findViewById(R.id.item_text1);

        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
