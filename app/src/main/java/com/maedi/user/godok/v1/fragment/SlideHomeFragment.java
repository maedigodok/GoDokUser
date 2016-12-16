package com.maedi.user.godok.v1.fragment;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.adapter.SlidePromoProductAdapter;
import com.maedi.user.godok.v1.animation.FadePageTransformer;
import com.maedi.user.godok.v1.data.ListData;
import com.maedi.user.godok.v1.utils.DataReference;
import com.maedi.user.godok.v1.utils.DataScreenSize;
import com.maedi.user.godok.v1.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

/**
 * Created by user on 11/16/2016.
 */

public class SlideHomeFragment extends Fragment {

    private static final String fragmentKey = "SLIDE-HOME";
    private int slideNumber;

    public static SlideHomeFragment newInstance(int _slideNumber) {
        SlideHomeFragment fragment = new SlideHomeFragment(_slideNumber);
        return fragment;
    }

    public static int getSlideCount() {
        return 3;
    }

    public static String[] titlePage() {
        return ListData.TabsText();
    }

    public SlideHomeFragment() {
        super();
    }

    @SuppressLint("ValidFragment")
    private SlideHomeFragment(int slideNumber) {
        super();
        this.slideNumber = slideNumber;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null) && savedInstanceState.containsKey(fragmentKey)) {
            slideNumber = savedInstanceState.getInt(fragmentKey);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = null;
        Log.i("-view-", "SlideNumber: "+slideNumber);
        switch (slideNumber) {
            case 0:
                //view = new ArticleFragment(R.layout.activity_mynotes).setView(inflater);
                view = inflater.inflate(getActivity().getResources().getLayout(R.layout.activity_mynotes), container, false);
                //Context ctx = view.getContext();

                final FragmentActivity f = (FragmentActivity)view.getContext();
                RelativeLayout mainLayout = (RelativeLayout)view.findViewById(R.id.main_layout);
                ImageView askdoctor = (ImageView) view.findViewById(R.id.askto_doctor);
                ImageView searchdoctor = (ImageView) view.findViewById(R.id.search_doctor);

                askdoctor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DynamicDialogSelfLayoutFragment dialog = DynamicDialogSelfLayoutFragment.newInstance(f, true, DataReference.TAG_ASK_DOCTOR);
                        dialog.show(f.getSupportFragmentManager(), DataReference.TAG_ASK_DOCTOR);
                    }
                });

                searchdoctor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //DynamicAlertDialogFragment dialog = DynamicAlertDialogFragment.newInstance(f, "Tip", 0, "Poin kamu adalah 0, silahkan peroleh poin dulu.", true);
                        //dialog.show(f.getSupportFragmentManager(), "");
                        DynamicDialogSelfLayoutFragment dialog = DynamicDialogSelfLayoutFragment.newInstance(f, false, DataReference.TAG_FIND_DOCTOR);
                        dialog.show(f.getSupportFragmentManager(), DataReference.TAG_FIND_DOCTOR);
                    }
                });

                ViewPager viewPager = (ViewPager)view.findViewById(R.id.slide_pager);
                SlidePromoProductAdapter mAdapter = new SlidePromoProductAdapter(getChildFragmentManager());
                viewPager.setAdapter(mAdapter);
                viewPager.setPageTransformer(false, new FadePageTransformer());

                PageIndicator mIndicator = (CirclePageIndicator)view.findViewById(R.id.slide_indicator);
                mIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        Log.i("page selected",""+position);
                    }
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    }
                    @Override
                    public void onPageScrollStateChanged(int state) {
                    }
                });

                mIndicator.setViewPager(viewPager);
                break;
            case 1:
                view = inflater.inflate(getActivity().getResources().getLayout(R.layout.sample_fragment_1), container, false);
                break;
            case 2:
                view = inflater.inflate(getActivity().getResources().getLayout(R.layout.sample_fragment_1), container, false);
                break;
            default:
                break;
        }
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(fragmentKey, slideNumber);
    }
}
