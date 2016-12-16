package com.maedi.user.godok.v1.fragment;

import android.app.FragmentManager;
import android.content.Context;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.adapter.ListDataChatAdapter;
import com.maedi.user.godok.v1.adapter.ListDataCommentArticleAdapter;
import com.maedi.user.godok.v1.adapter.ListDataInfoHealthyAdapter;
import com.maedi.user.godok.v1.data.ListData;
import com.maedi.user.godok.v1.utils.DataReference;

import github.ankushsachdeva.emojicon.EmojiconEditText;
import github.ankushsachdeva.emojicon.EmojiconsPopup;

import github.ankushsachdeva.emojicon.EmojiconEditText;
import github.ankushsachdeva.emojicon.EmojiconGridView.OnEmojiconClickedListener;
import github.ankushsachdeva.emojicon.EmojiconsPopup;
import github.ankushsachdeva.emojicon.EmojiconsPopup.OnEmojiconBackspaceClickedListener;
import github.ankushsachdeva.emojicon.EmojiconsPopup.OnSoftKeyboardOpenCloseListener;
import github.ankushsachdeva.emojicon.emoji.Emojicon;

import android.widget.PopupWindow.OnDismissListener;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by user on 12/7/2016.
 */

public class ChatUserFragment extends Fragment {

    private FragmentActivity f;
    private ImageView back;
    private TextView txtTitle;
    private EmojiconEditText emojiconEditText;
    private View rootView;
    private ImageView take_icon, send_chat;
    private RelativeLayout lyt_bottom;
    private LinearLayout lyt_file;

    public static ChatUserFragment newInstance(String title, String page){
        ChatUserFragment frag = new ChatUserFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("page", page);
        frag.setArguments(args);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_user, container, false);
        f = (FragmentActivity)view.getContext();

        back = (ImageView)view.findViewById(R.id.back);
        txtTitle = (TextView)view.findViewById(R.id.txtTitle);
        txtTitle.setText(getArguments().getString("title"));
        take_icon = (ImageView)view.findViewById(R.id.take_icon);
        send_chat = (ImageView)view.findViewById(R.id.send_chat);
        emojiconEditText = (EmojiconEditText)view.findViewById(R.id.content_chat);
        rootView = view.findViewById(R.id.lyt_bottom);
        lyt_bottom = (RelativeLayout)view.findViewById(R.id.lyt_bottom);
        lyt_file = (LinearLayout)view.findViewById(R.id.lyt_file);

        ListDataChatAdapter adapter = new ListDataChatAdapter(view.getContext(), f, 0,
                ListData.listChat(), DataReference.TAG_LIST_CHAT);
        ListView listView = (ListView)view.findViewById(R.id.listmenu);
        listView.setItemsCanFocus(true);
        listView.setAdapter(adapter);

        /*
        // Give the topmost view of your activity layout hierarchy. This will be used to measure soft keyboard height
        final EmojiconsPopup popup = new EmojiconsPopup(rootView, f);

        //Will automatically set size according to the soft keyboard size
        popup.setSizeForSoftKeyboard();

        //If the emoji popup is dismissed, change emojiButton to smiley icon
        popup.setOnDismissListener(new OnDismissListener() {

            @Override
            public void onDismiss() {
                changeEmojiKeyboardIcon(take_icon, R.drawable.plus_white);
            }
        });

        //If the text keyboard closes, also dismiss the emoji popup
        popup.setOnSoftKeyboardOpenCloseListener(new OnSoftKeyboardOpenCloseListener() {

            @Override
            public void onKeyboardOpen(int keyBoardHeight) {

            }

            @Override
            public void onKeyboardClose() {
                if(popup.isShowing())
                    popup.dismiss();
            }
        });

        //On emoji clicked, add it to edittext
        popup.setOnEmojiconClickedListener(new OnEmojiconClickedListener() {

            @Override
            public void onEmojiconClicked(Emojicon emojicon) {
                if (emojiconEditText == null || emojicon == null) {
                    return;
                }

                int start = emojiconEditText.getSelectionStart();
                int end = emojiconEditText.getSelectionEnd();
                if (start < 0) {
                    emojiconEditText.append(emojicon.getEmoji());
                } else {
                    emojiconEditText.getText().replace(Math.min(start, end),
                            Math.max(start, end), emojicon.getEmoji(), 0,
                            emojicon.getEmoji().length());
                }
            }
        });

        //On backspace clicked, emulate the KEYCODE_DEL key event
        popup.setOnEmojiconBackspaceClickedListener(new EmojiconsPopup.OnEmojiconBackspaceClickedListener() {

            @Override
            public void onEmojiconBackspaceClicked(View v) {
                KeyEvent event = new KeyEvent(
                        0, 0, 0, KeyEvent.KEYCODE_DEL, 0, 0, 0, 0, KeyEvent.KEYCODE_ENDCALL);
                emojiconEditText.dispatchKeyEvent(event);
            }
        });

        // To toggle between text keyboard and emoji keyboard keyboard(Popup)
        take_icon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //If popup is not showing => emoji keyboard is not visible, we need to show it
                if(!popup.isShowing()){

                    //If keyboard is visible, simply show the emoji popup
                    if(popup.isKeyBoardOpen()){
                        popup.showAtBottom();
                        changeEmojiKeyboardIcon(take_icon, R.drawable.plus_green);
                    }

                    //else, open the text keyboard first and immediately after that show the emoji popup
                    else{
                        emojiconEditText.setFocusableInTouchMode(true);
                        emojiconEditText.requestFocus();
                        popup.showAtBottomPending();
                        final InputMethodManager inputMethodManager = (InputMethodManager) f.getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputMethodManager.showSoftInput(emojiconEditText, InputMethodManager.SHOW_IMPLICIT);
                        changeEmojiKeyboardIcon(take_icon, R.drawable.plus_green);
                    }
                }

                //If popup is showing, simply dismiss it to show the undelying text keyboard
                else{
                    popup.dismiss();
                }
            }
        });
        */

        take_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                if(lyt_file.getVisibility() == View.GONE) {
                    p.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 0);
                    p.addRule(RelativeLayout.ABOVE, R.id.lyt_file);
                    lyt_bottom.setLayoutParams(p);
                    lyt_file.setVisibility(View.VISIBLE);

                }else{
                    p.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
                    lyt_bottom.setLayoutParams(p);
                    lyt_file.setVisibility(View.GONE);
                }

            }
        });

        //On submit, add the edittext text to listview and clear the edittext
        send_chat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //String newText = emojiconEditText.getText().toString();
                //emojiconEditText.getText().clear();
                //mAdapter.add(newText);
                //mAdapter.notifyDataSetChanged();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back(getArguments().getString("page"));
            }
        });

        emojiconEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((keyCode == KeyEvent.KEYCODE_BACK)) {
                    back(getArguments().getString("page"));
                    return true;
                }
                return false;
            }
        });

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if( keyCode == KeyEvent.KEYCODE_BACK ) {
                    back(getArguments().getString("page"));
                    return true;
                } else {
                    return false;
                }
            }
        });

        return view;
    }

    private void back(final String page){
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = null;
                String tag = null;
                if(page.equalsIgnoreCase("doctor")){
                    fragment = new DoctorsFragment();
                    tag = "doctor";
                }else if(page.equalsIgnoreCase("myquestion")){
                    fragment = new MyQuestionFragment();
                    tag = "myquestion";
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

    private void changeEmojiKeyboardIcon(ImageView iconToBeChanged, int drawableResourceId){
        iconToBeChanged.setImageResource(drawableResourceId);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
