package com.maedi.user.godok.v1.fragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.activity.MainNavigationDrawer;
import com.maedi.user.godok.v1.adapter.ListDataFavoriteAdapter;
import com.maedi.user.godok.v1.data.ListData;
import com.maedi.user.godok.v1.utils.DataReference;

/**
 * Created by user on 12/5/2016.
 */

public class ArticleContentFragment extends Fragment {

    private FragmentActivity f;
    private ImageView back;
    private TextView txtTitle, textContent, writeComment;
    private static int ckey;

    public static ArticleContentFragment newInstance(String title, String page){
        ArticleContentFragment frag = new ArticleContentFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("page", page);
        frag.setArguments(args);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.article_content, container, false);
        f = (FragmentActivity)view.getContext();
        ckey = 0;

        back = (ImageView)view.findViewById(R.id.back);
        txtTitle = (TextView)view.findViewById(R.id.txtTitle);
        txtTitle.setText(getArguments().getString("title"));
        textContent = (TextView)view.findViewById(R.id.item_text3);
        textContent.setText("Siapa sih yang tidak kenal dengan buah mangga? "
                +"Buah yang dianggap sebagai salah satu buah yang nikmat dan enak di ini banyak ditemukan di negara Indonesia, "
                +"karena pohon mangga merupakan tanaman yang dapat tumbuh subur pada daerah beriklim tropis. "
                +"Karena merupakan jenis buah musiman yang hanya ada dan berbuah pada saat tertentu saja, mangga menjadi buah yang dirindukan kehadirannya oleh para penggemarnya. "
                +"Selain dapat dikonsumsi secara langsung, buah mangga juga dapat diolah menjadi sejumlah hidangan yang nikmat seperti jus mangga, puding mangga, salad buah, smoothie, "
                +"campuran rujak buah dan hasil olahan lainnya. Dengan demikian, "
                +"penggemar buah mangga tidak akan merasa bosan ketika mengkonsumsinya");

        writeComment = (TextView)view.findViewById(R.id.item_text8);

        writeComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable mPendingRunnable = new Runnable() {
                    @Override
                    public void run() {
                        // update the main content by replacing fragments
                        Fragment fragment = CommentArticleFragment.newInstance(getArguments().getString("title"), getArguments().getString("page"));
                        FragmentTransaction fragmentTransaction = f.getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                        fragmentTransaction.replace(R.id.frame, fragment, "comment_article");
                        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        fragmentTransaction.commitAllowingStateLoss();
                    }
                };

                Handler mHandler = new Handler();
                mHandler.post(mPendingRunnable);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back(getArguments().getString("title"), getArguments().getString("page"));
            }
        });

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if( keyCode == KeyEvent.KEYCODE_BACK ) {
                    Fragment tagFragment = getFragmentManager().findFragmentByTag("comment_article");
                    if(tagFragment instanceof CommentArticleFragment){
                        if(ckey == 0)ckey++;
                        else back(getArguments().getString("title"), getArguments().getString("page"));
                    }else back(getArguments().getString("title"), getArguments().getString("page"));
                    return true;
                } else {
                    return false;
                }
            }
        });

        return view;
    }

    private void back(final String title, final String page){
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = null;
                String tag = null;
                if(page.equalsIgnoreCase("healthy")){
                    fragment = InfoHealthyFragment.newInstance(title);
                    tag = "healthy";
                }else if(page.equalsIgnoreCase("favorite")){
                    fragment = new FavoriteFragment();
                    tag = "favorite";
                }
                FragmentTransaction fragmentTransaction = f.getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                fragmentTransaction.replace(R.id.frame, fragment, tag);
                getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        Handler mHandler = new Handler();
        mHandler.post(mPendingRunnable);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

