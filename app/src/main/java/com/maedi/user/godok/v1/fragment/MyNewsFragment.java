package com.maedi.user.godok.v1.fragment;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.activity.ArticleDescActivity;
import com.maedi.user.godok.v1.activity.MainNavigationDrawer;
import com.maedi.user.godok.v1.adapter.SlidePromoProductAdapter;
import com.maedi.user.godok.v1.animation.FadePageTransformer;
import com.maedi.user.godok.v1.data.ListData;
import com.maedi.user.godok.v1.model.ListMenu;
import com.maedi.user.godok.v1.utils.DataReference;
import com.maedi.user.godok.v1.utils.DataScreenSize;
import com.maedi.user.godok.v1.utils.DynamicLoadingContentDialogFragment;
import com.maedi.user.godok.v1.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

/**
 * Created by Maedi on 1/18/2016.
 */
public class MyNewsFragment extends Fragment {
    private ViewGroup viewgroup;
    private View view;
    public static RelativeLayout mainLayout;
    private static int pos = -1;
    ImageView askdoctor, searchdoctor, articlevideo, event;
    RelativeLayout lyt_headline;
    static FragmentActivity f;

    //private ViewPager viewPager;
    //private PageIndicator mIndicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View drawer = inflater.inflate(R.layout.activity_mynotes, container, false);
        f = (FragmentActivity)drawer.getContext();
        mainLayout = (RelativeLayout)drawer.findViewById(R.id.main_layout);
        askdoctor = (ImageView) drawer.findViewById(R.id.askto_doctor);
        searchdoctor = (ImageView) drawer.findViewById(R.id.search_doctor);
        articlevideo = (ImageView) drawer.findViewById(R.id.article_video);
        event = (ImageView) drawer.findViewById(R.id.event);
        lyt_headline = (RelativeLayout)drawer.findViewById(R.id.lyt_headline);

        askdoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DynamicDialogSelfLayoutFragment dialog = DynamicDialogSelfLayoutFragment.newInstance(f, true, DataReference.TAG_ASK_DOCTOR);
                //dialog.show(f.getSupportFragmentManager(), DataReference.TAG_ASK_DOCTOR);
                Runnable mPendingRunnable = new Runnable() {
                    @Override
                    public void run() {
                        // update the main content by replacing fragments
                        Fragment fragment = new ConsultationDoctorFragment();
                        FragmentTransaction fragmentTransaction = f.getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                        fragmentTransaction.replace(R.id.frame, fragment, "consultation_doctor");
                        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        fragmentTransaction.commitAllowingStateLoss();
                        //MainNavigationDrawer.selectHome();
                    }
                };

                Handler mHandler = new Handler();
                mHandler.post(mPendingRunnable);
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

        articlevideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DynamicLoadingContentDialogFragment loadingContentDialog= DynamicLoadingContentDialogFragment.newInstance("", 0, "",
                        true, true, "loading");
                loadingContentDialog.show(f.getSupportFragmentManager(), "loading");
                Handler handler = new Handler();

                Runnable r = new Runnable() {
                    public void run() {
                        loadingContentDialog.dismiss();
                        Runnable mPendingRunnable = new Runnable() {
                            @Override
                            public void run() {
                                // update the main content by replacing fragments
                                Fragment fragment = new ArticleVideoFragment();
                                FragmentTransaction fragmentTransaction = f.getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                                fragmentTransaction.replace(R.id.frame, fragment, "article_video");
                                getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                                fragmentTransaction.commitAllowingStateLoss();
                            }
                        };

                        Handler mHandler = new Handler();
                        mHandler.post(mPendingRunnable);
                    }
                };
                handler.postDelayed(r, 500);
            }
        });

        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable mPendingRunnable = new Runnable() {
                    @Override
                    public void run() {
                        // update the main content by replacing fragments
                        Fragment fragment = new EventFragment();
                        FragmentTransaction fragmentTransaction = f.getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                        fragmentTransaction.replace(R.id.frame, fragment, "event");
                        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        fragmentTransaction.commitAllowingStateLoss();
                    }
                };

                Handler mHandler = new Handler();
                mHandler.post(mPendingRunnable);
            }
        });

        lyt_headline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable mPendingRunnable = new Runnable() {
                    @Override
                    public void run() {
                        // update the main content by replacing fragments
                        Fragment fragment = ArticleContentFragment.newInstance("Info Sehat", "healthy");
                        FragmentTransaction fragmentTransaction = f.getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                        fragmentTransaction.replace(R.id.frame, fragment, "article_content");
                        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        fragmentTransaction.commitAllowingStateLoss();
                    }
                };

                Handler mHandler = new Handler();
                mHandler.post(mPendingRunnable);
            }
        });


        final PageIndicator mIndicator = (CirclePageIndicator)drawer.findViewById(R.id.slide_indicator);
        final ViewPager viewPager = (ViewPager)drawer.findViewById(R.id.slide_pager);
        //ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        //        LinearLayout.LayoutParams.WRAP_CONTENT,
        //        LinearLayout.LayoutParams.WRAP_CONTENT);
        //int pheightBanner = 582;
        //int hbannerdp = DataScreenSize.PixelToDP(drawer.getContext(), pheightBanner);
        //Log.i("height_banner", ""+hbannerdp);
        //params.height= hbannerdp;
        //viewPager.setLayoutParams(params);
        SlidePromoProductAdapter mAdapter = new SlidePromoProductAdapter(getFragmentManager());
        viewPager.setAdapter(mAdapter);
        viewPager.setPageTransformer(false, new FadePageTransformer());
        mIndicator.setViewPager(viewPager);

        mIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
            }
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_DRAGGING) {
                } else if (state == ViewPager.SCROLL_STATE_IDLE) {
                }
            }
        });

        /*
        viewPager = (ViewPager)drawer.findViewById(R.id.slide_pager);
        SlidePromoProductAdapter mAdapter = new SlidePromoProductAdapter(f.getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
        viewPager.setPageTransformer(false, new FadePageTransformer());

        mIndicator = (CirclePageIndicator)drawer.findViewById(R.id.slide_indicator);
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

        ((View) mIndicator).setVisibility(View.VISIBLE);
        */

        //RecyclerView rv = (RecyclerView) drawer.findViewById(R.id.recyclerview);
        //this.viewgroup = container;
        //setupRecyclerView(rv);

        return drawer;
    }

    //private void setupRecyclerView(RecyclerView recyclerView) {
    //    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    //    recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(), ListData.listNews()));

        //LayoutInflater inflater = getActivity().getLayoutInflater();
        //View v = inflater.inflate(R.layout.activity_main_pager, null);
        /*
        recyclerView.setOnScrollListener(new HidingScrollListener() {
            @Override
            public void onHide() {
                //hideViews();
                //Toast.makeText(getActivity(), "Toast ONHide",
                //        Toast.LENGTH_SHORT).show();
                //MainActivityPager.showHeaderProfile();
                //MainActivity.showHeaderProfile();
                //mainLayout.setVisibility(View.GONE);
            }

            @Override
            public void onShow() {
                //showViews();
                //Toast.makeText(getActivity(), "Toast ONShow",
                //        Toast.LENGTH_SHORT).show();
                //MainActivityPager.hideHeaderProfile();
                //MainActivity.hideHeaderProfile();
                //mainLayout.setVisibility(View.VISIBLE);
            }
        });
        */

    //}

    /*
    public static class SimpleStringRecyclerViewAdapter extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

        private ListMenu mValues;
        private Context context;

        public SimpleStringRecyclerViewAdapter(Context context, ListMenu items) {
            this.context = context;
            this.mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_news, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            pos = position;
            ListMenu lm = (ListMenu) mValues.get(position);
            holder.text.setText(lm.text);

            if(pos == 0) {
                holder.topLayout.setVisibility(View.VISIBLE);
                SlidePromoProductAdapter mAdapter = new SlidePromoProductAdapter(f.getSupportFragmentManager());
                holder.viewPager.setAdapter(mAdapter);
                holder.viewPager.setPageTransformer(false, new FadePageTransformer());
                //new Handler().postDelayed(new Runnable() {
                //    @Override
                //    public void run() {
                //    }
                //}, 500);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        holder.mIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
                        holder.mIndicator.setViewPager(holder.viewPager);
                    }
                }, 100);


            }else{
                holder.topLayout.setVisibility(View.GONE);
            }
            //text hours
            if(null != holder.text2)holder.text2.setText(lm.text2);
            //text status
            if(null != holder.text3)
                if(!lm.text3.trim().equalsIgnoreCase("")){
                    holder.text3.setVisibility(View.VISIBLE);
                    holder.text3.setText(lm.text3);
                }
                else holder.text3.setVisibility(View.GONE);
            //text count like
            if(null != holder.text4)holder.text4.setText(lm.text4);
            //text count comment
            if(null != holder.text5)holder.text5.setText(lm.text5);
            //image profile
            holder.imgIcon.setImageResource(lm.imageIcon);
            //image arrow report news
            if(null != holder.imgIcon2)if(lm.imageIcon2 > 0)holder.imgIcon2.setImageResource(lm.imageIcon2);
            //image like
            if(null != holder.imgIcon3)if(lm.imageIcon3 > 0)holder.imgIcon3.setImageResource(lm.imageIcon3);
            //image write comment
            if(null != holder.imgIcon4)if(lm.imageIcon4 > 0)holder.imgIcon4.setImageResource(lm.imageIcon4);
            //image news status
            if(null != holder.imgIcon5)
                if(lm.imageIcon5 > 0){
                    holder.imgIcon5.setVisibility(View.VISIBLE);
                    holder.imgIcon5.setImageResource(lm.imageIcon5);
                }
                else holder.imgIcon5.setVisibility(View.GONE);

            RelativeLayout.LayoutParams l = (RelativeLayout.LayoutParams) holder.layoutPage.getLayoutParams();
            if(pos > 0)
                l.setMargins(0, DataScreenSize.PixelToDP(context, 20), 0, 0);//left,top,right,bottom

            holder.parent_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ArticleDescActivity.class);
                    context.startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public String mBoundString;

            public final View row;
            public ImageView imgIcon;
            public ImageView imgIcon2;
            public ImageView imgIcon3;
            public ImageView imgIcon4;
            public ImageView imgIcon5;
            public TextView text;
            public TextView text2;
            public TextView text3;
            public TextView text4;
            public TextView text5;
            public TextView label_static_group;
            public RelativeLayout layoutPage;
            public LinearLayout topLayout;
            public RelativeLayout parent_layout;
            public RelativeLayout lyIcWriteCamera;
            public EditText edit_status;
            public ImageView ic_write_status;
            public TextView txtStatus;
            public ImageView ic_camera;
            public TextView txtCamera;
            public ViewPager viewPager;
            public PageIndicator mIndicator;

            public ViewHolder(View view) {
                super(view);
                row = view;

                topLayout = (LinearLayout)row.findViewById(R.id.ly_slide_product);
                parent_layout = (RelativeLayout)row.findViewById(R.id.parent_layout);
                //lyIcWriteCamera = (RelativeLayout)row.findViewById(R.id.lyIcWriteCamera);
                //edit_status = (EditText)row.findViewById(R.id.edit_status);
                //ic_write_status = (ImageView)row.findViewById(R.id.ic_write_status);
                //txtStatus = (TextView)row.findViewById(R.id.txtStatus);
                //ic_camera = (ImageView)row.findViewById(R.id.ic_camera);
                //txtCamera = (TextView)row.findViewById(R.id.txtCamera);

                text = (TextView)row.findViewById(R.id.listmenuitemtext);
                text2 = (TextView)row.findViewById(R.id.listmenuitemtext2);
                text3 = (TextView)row.findViewById(R.id.listmenuitemtext3);
                text4 = (TextView)row.findViewById(R.id.listmenuitemtext4);
                text5 = (TextView)row.findViewById(R.id.listmenuitemtext5);
                imgIcon = (ImageView)row.findViewById(R.id.listmenuitemicon);
                //imgIcon2 = (ImageView)row.findViewById(R.id.listmenuitemicon2);
                imgIcon3 = (ImageView)row.findViewById(R.id.listmenuitemicon3);
                //imgIcon4 = (ImageView)row.findViewById(R.id.listmenuitemicon4);
                imgIcon5 = (ImageView)row.findViewById(R.id.listmenuitemicon5);
                layoutPage = (RelativeLayout)row.findViewById(R.id.main_layout);
                viewPager = (ViewPager)row.findViewById(R.id.slide_pager);
                mIndicator = (CirclePageIndicator)row.findViewById(R.id.slide_indicator);
            }

            @Override
            public String toString() {
                return super.toString();
            }
        }

    }
    */
}


