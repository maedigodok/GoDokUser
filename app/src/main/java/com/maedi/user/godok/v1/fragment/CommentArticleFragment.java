package com.maedi.user.godok.v1.fragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.activity.MainNavigationDrawer;
import com.maedi.user.godok.v1.adapter.ListDataCommentArticleAdapter;
import com.maedi.user.godok.v1.adapter.ListDataFavoriteAdapter;
import com.maedi.user.godok.v1.data.ListData;
import com.maedi.user.godok.v1.utils.DataReference;

/**
 * Created by user on 12/7/2016.
 */

public class CommentArticleFragment extends Fragment {

    private FragmentActivity f;
    private ImageView back, share;
    //private TextView txtTitle;
    private Button btnComment, submit, cancel;
    private RelativeLayout lyt1, lyt1a;

    public static CommentArticleFragment newInstance(String title, String page){
        CommentArticleFragment frag = new CommentArticleFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("page", page);
        frag.setArguments(args);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comment_article, container, false);
        f = (FragmentActivity)view.getContext();

        back = (ImageView)view.findViewById(R.id.back);
        share = (ImageView)view.findViewById(R.id.share);
        //txtTitle = (TextView)view.findViewById(R.id.txtTitle);
        //txtTitle.setText("Komentar");
        lyt1 = (RelativeLayout)view.findViewById(R.id.lyt_1);
        lyt1a = (RelativeLayout)view.findViewById(R.id.lyt_1a);
        btnComment = (Button)view.findViewById(R.id.comment_button);
        submit = (Button)view.findViewById(R.id.submit);
        cancel = (Button)view.findViewById(R.id.cancel);

        ListDataCommentArticleAdapter adapter = new ListDataCommentArticleAdapter(view.getContext(), R.layout.list_item_comment_article,
                ListData.listCommentArticle(), DataReference.TAG_LIST_COMMENT_ARTICLE);
        final ListView listView = (ListView)view.findViewById(R.id.listmenu);
        listView.setItemsCanFocus(true);
        listView.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back(getArguments().getString("title"));
            }
        });

        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lyt1.setVisibility(View.GONE);
                btnComment.setVisibility(View.GONE);
                lyt1a.setVisibility(View.VISIBLE);
                RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                p.addRule(RelativeLayout.BELOW, R.id.lyt_1a);
                listView.setLayoutParams(p);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lyt1.setVisibility(View.VISIBLE);
                btnComment.setVisibility(View.VISIBLE);
                lyt1a.setVisibility(View.GONE);
                RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                p.addRule(RelativeLayout.BELOW, R.id.comment_button);
                listView.setLayoutParams(p);
            }
        });

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if( keyCode == KeyEvent.KEYCODE_BACK ) {
                    back(getArguments().getString("title"));
                    return true;
                } else {
                    return false;
                }
            }
        });

        return view;
    }

    private void back(final String title){
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = ArticleContentFragment.newInstance(title, getArguments().getString("page"));
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

    @Override
    public void onDetach() {
        super.onDetach();
    }
}