package com.maedi.user.godok.v1.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.maedi.user.godok.v1.R;

/**
 * Created by user on 11/11/2016.
 */

public class SlidePromoProductFragment extends Fragment {

    private static final String fragmentKey = "SLIDEKEY";
    private int _slideNumber;

    public static SlidePromoProductFragment newInstance(int slideNumber) {
        SlidePromoProductFragment fragment = new SlidePromoProductFragment(slideNumber);
        fragment._slideNumber = slideNumber;
        return fragment;
    }

    public static int getSlideCount() {
        return 5;
    }

    public SlidePromoProductFragment() {
        super();
    }

    @SuppressLint("ValidFragment")
    private SlidePromoProductFragment(int slideNumber) {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null) && savedInstanceState.containsKey(fragmentKey)) {
            _slideNumber = savedInstanceState.getInt(fragmentKey);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(getActivity().getResources().getLayout(R.layout.content_slide_promo_product), container, false);
        Context ctx;
        final ImageView img = (ImageView)view.findViewById(R.id.itemimage);

        //final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar1);
        //new Handler().postDelayed(new Runnable() {
        //    @Override
        //    public void run() {
        //    }
        //}, 1000);
        Log.i("_slideNUmber","A_"+_slideNumber);
        switch (_slideNumber) {
            case 0:
                //img.setImageDrawable(getResources().getDrawable(R.drawable.iko_cantik1));
                Log.i("_slideNUmber","B_"+_slideNumber);
                Glide.with(view.getContext())
                        .load(R.drawable.iko_cantik1)
                        .asBitmap()
                        .placeholder(R.drawable.black_bg)
                        .fitCenter()
                        //.listener(new RequestListener<String, GlideDrawable>() {
                        //    @Override
                        //    public boolean onException(Exception arg0, String arg1,Target<GlideDrawable> arg2, boolean arg3) {
                        //        return false;
                        //    }
                        //    @Override
                        //   public boolean onResourceReady(GlideDrawable arg0, String arg1,Target<GlideDrawable> arg2, boolean arg3, boolean arg4) {
                        //        progressBar.setVisibility(View.GONE);
                        //        return false;
                        //   }
                        //})
                        .into(img);
                /*
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(view.getContext())
                                .load(R.drawable.iko_cantik1)
                                .asBitmap()
                                .placeholder(R.drawable.loading_static)
                                .fitCenter()
                                .into(img);
                    }
                }, 600);
                */
                break;
            case 1:
                //img.setImageDrawable(getResources().getDrawable(R.drawable.iko_cantik2));
                //new Handler().postDelayed(new Runnable() {
                //    @Override
                //    public void run() {
                        Glide.with(view.getContext())
                                .load(R.drawable.iko_cantik2)
                                .asBitmap()
                                .placeholder(R.drawable.loading_static)
                                .fitCenter()
                                .into(img);
                //    }
                //}, 600);

                break;
            case 2:
                //img.setImageDrawable(getResources().getDrawable(R.drawable.iko_cantik3));Glide.with(view.getContext())
                //new Handler().postDelayed(new Runnable() {
                //    @Override
                //    public void run() {
                        Glide.with(view.getContext())
                                .load(R.drawable.iko_cantik3)
                                .asBitmap()
                                .placeholder(R.drawable.loading_static)
                                .fitCenter()
                                .into(img);
                //    }
                //}, 600);


                break;
            case 3:
                //img.setImageDrawable(getResources().getDrawable(R.drawable.iko_cantik4));
                //new Handler().postDelayed(new Runnable() {
                //    @Override
                //    public void run() {
                        Glide.with(view.getContext())
                                .load(R.drawable.iko_cantik4)
                                .asBitmap()
                                .placeholder(R.drawable.loading_static)
                                .fitCenter()
                                .into(img);
                //    }
                //}, 600);

                break;
            case 4:
                //img.setImageDrawable(getResources().getDrawable(R.drawable.iko_cantik5));
                //new Handler().postDelayed(new Runnable() {
                //    @Override
                //    public void run() {

                Runnable mPendingRunnable = new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(view.getContext())
                                .load(R.drawable.iko_cantik5)
                                .asBitmap()
                                .placeholder(R.drawable.loading_static)
                                .fitCenter()
                                .into(img);
                    }
                };
                Handler mHandler = new Handler();
                mHandler.post(mPendingRunnable);
                //    }
                //}, 600);

                break;

            default:
                break;
        }
        //((ViewGroup)view.getParent()).removeView(view);
        //container.addView(view);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(fragmentKey, _slideNumber);
    }
}

