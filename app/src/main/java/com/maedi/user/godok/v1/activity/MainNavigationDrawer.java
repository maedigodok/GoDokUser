package com.maedi.user.godok.v1.activity;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.drawers.searchbar.SearchBarActivity;
import com.maedi.user.godok.v1.drawers.viewpagers.ViewPagerWithTabsFragment;
import com.maedi.user.godok.v1.fragment.ArticleFragment;
import com.maedi.user.godok.v1.fragment.ArticleVideoFragment;
import com.maedi.user.godok.v1.fragment.DynamicDialogSelfLayoutFragment;
import com.maedi.user.godok.v1.fragment.FavoriteFragment;
import com.maedi.user.godok.v1.fragment.InfoHealthyFragment;
import com.maedi.user.godok.v1.fragment.MyNewsFragment;
import com.maedi.user.godok.v1.fragment.MyQuestionFragment;
import com.maedi.user.godok.v1.fragment.PoinFragment;
import com.maedi.user.godok.v1.fragment.ProfileFragment;
import com.maedi.user.godok.v1.fragment.SampleFragment_1;
import com.maedi.user.godok.v1.fragment.SendCommentFragment;
import com.maedi.user.godok.v1.fragment.Tab1Fragment;
import com.maedi.user.godok.v1.utils.AnimationSlide;
import com.maedi.user.godok.v1.utils.DataReference;
import com.maedi.user.godok.v1.utils.DialogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11/2/2016.
 */

public class MainNavigationDrawer extends AppCompatActivity {

    private static NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtTitleName, txtSubtitle;
    private Toolbar toolbar, toolbar_second;
    private ImageView findarticle;
    //private FloatingActionButton fab;

    // urls to load navigation header background image
    // and profile image
    private static final String urlNavHeaderBg = "http://api.androidhive.info/images/nav-menu-header-bg.jpg";
    private static final String urlProfileImg = "https://lh3.googleusercontent.com/eCtE_G34M9ygdkmOpYvCag1vBARCmZwnVS6rS5t4JLzJ6QgQSBquM0nuTsCpLhYbKljoyS-txg";

    // index to identify current nav menu item
    public static int navItemIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_HOME = "home";
    private static final String TAG_PROFILE = "profile";
    private static final String TAG_MYQUESTION = "question";
    private static final String TAG_FAVORITE = "favorite";
    private static final String TAG_POIN = "poin";
    private static final String TAG_HEALTH = "healthy";
    private static final String SHARE = "share";
    private static final String COMMENT = "comment";
    private static final String INFO = "info";
    private static final String TAG_ARTICLE = "article";
    public static String CURRENT_TAG = TAG_HOME;

    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;

    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;

    private FragmentActivity fragmentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentActivity = this;
        setContentView(R.layout.activity_main_navigation);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //remove title space from menu item list
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setTitle(null);
        findarticle = (ImageView)findViewById(R.id.find_article);

        findarticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fragmentActivity,SearchArticleActivity.class);
                startActivity(intent);
            }
        });

        /*
        toolbar_second = (Toolbar)findViewById(R.id.toolbar_second);
        findarticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationSlide.outFromBottomToTop(1f, 0f);
                toolbar.startAnimation(anim);
                anim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        // TODO Auto-generated method stub
                    }
                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        // TODO Auto-generated method stub
                    }
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        toolbar.setVisibility(View.GONE);
                        toolbar_second.setVisibility(View.VISIBLE);
                        setSupportActionBar(toolbar_second);
                    }
                });
            }
        });

        ImageView findarticle2 = (ImageView)findViewById(R.id.find_article2);
        findarticle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationSlide.fromTopToBottom(1f, 0f);
                toolbar_second.startAnimation(anim);
                anim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        // TODO Auto-generated method stub
                    }
                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        // TODO Auto-generated method stub
                    }
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        toolbar.setBackgroundColor(fragmentActivity.getResources().getColor(R.color.white));
                        toolbar.setVisibility(View.VISIBLE);
                        toolbar_second.setVisibility(View.GONE);
                    }
                });
            }
        });
        */

        mHandler = new Handler();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        //fab = (FloatingActionButton) findViewById(R.id.fab);

        // Navigation view header
        navHeader = navigationView.getHeaderView(0);
        txtTitleName = (TextView) navHeader.findViewById(R.id.title);
        txtSubtitle = (TextView) navHeader.findViewById(R.id.subtitle);
//        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
//        imgNavHeaderBg.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.backround_page_1));
        imgProfile = (ImageView) navHeader.findViewById(R.id.photo_profile);
        imgProfile.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.iko_cantik1));

        // load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);

        /*
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        // load nav menu header data
        loadNavHeader();

        // initializing navigation menu
        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }
    }

    /***
     * Load navigation menu header information
     * like background image, profile image
     * name, website, notifications action view (dot)
     */
    private void loadNavHeader() {
        // name, website
        txtTitleName.setText("Malika");
        txtSubtitle.setText("26 Years Old");
        /*
        // loading header background image
        Glide.with(this).load(urlNavHeaderBg)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgNavHeaderBg);

        // Loading profile image
        Glide.with(this).load(urlProfileImg)
                .crossFade()
                .thumbnail(0.5f)
                .bitmapTransform(new CircleTransform(this))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgProfile);
        */
        // showing dot next to notifications label
        //navigationView.getMenu().getItem(0).getSubMenu().getItem(3).setActionView(R.layout.menu_dot);
//        navigationView.getMenu().getItem(3).setActionView(R.layout.menu_dot);
    }

    /***
     * Returns respected fragment that user
     * selected from navigation menu
     */
    public void loadHomeFragment() {
        // selecting appropriate nav menu item
        selectNavMenu();

        // set toolbar title
        setToolbarTitle();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();

            // show or hide the fab button
            //toggleFab();
            return;
        }

        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                //if(navItemIndex != 6)fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                //else fragmentTransaction.setCustomAnimations(R.anim.in, R.anim.out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }

        // show or hide the fab button
        //toggleFab();

        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragment() {
        //Log.i("First-fragment",""+navItemIndex);
        //Log.i("navItemIndex", "II index "+navItemIndex);
        switch (navItemIndex) {
            case 0:
                //Tab1Fragment t1Fragment = new Tab1Fragment();
                MyNewsFragment t1Fragment = new MyNewsFragment();
                return t1Fragment;
            case 1:
                ProfileFragment pFragment = new ProfileFragment();
                return pFragment;
            case 2:
                //ViewPagerWithTabsFragment questionFragment = new ViewPagerWithTabsFragment();
                //return questionFragment;
                MyQuestionFragment mqfragment = new MyQuestionFragment();
                return mqfragment;
            case 3:
                FavoriteFragment faFragment = new FavoriteFragment();
                return faFragment;
            case 4:
                //PoinFragment pfragment = new PoinFragment();
                ArticleVideoFragment pfragment = new ArticleVideoFragment();
                return pfragment;
            //case 5:
            //    InfoHealthyFragment healtyFragment = new InfoHealthyFragment();
            //    return healtyFragment;
            //case 6:
            //    ShareTextFragment fragmentShare = new ShareTextFragment();
            //    return fragmentShare;
        //    case 7:
        //        SampleFragment_1 sFragment = new SampleFragment_1();
        //        sFragment.newInstance("Info","");
        //        return sFragment;
            case 8:
                SendCommentFragment scmfragment = new SendCommentFragment();
                return scmfragment;
            default:
                //return new Tab1Fragment();
                return new MyNewsFragment();
        }
    }

    private void setToolbarTitle() {
        //hide or show title
        //getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }

    public static void selectHome() {
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    private void selectNavMenu() {
        if(navItemIndex <= 7){
            navigationView.getMenu().getItem(navItemIndex).setChecked(true);
            //Log.i("selectmenu",""+navItemIndex);
        }
        else {
            //MenuItem mm = (MenuItem) navigationView.getMenu();
            //navigationView.getMenu().getItem(navItemIndex).getSubMenu().getItem().setChecked(true);
        }
    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_home:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_HOME;
                        break;
                    case R.id.nav_profile:
                        //navigationView.getMenu().getItem(navItemIndex).setEnabled(true);
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_PROFILE;
                        //startActivity(new Intent(MainNavigationDrawer.this, ProfileActivity.class));
                        //drawer.closeDrawers();
                        //return true;
                        break;
                    case R.id.nav_myquestion:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_MYQUESTION;
                        break;
                    case R.id.nav_favorite:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_FAVORITE;
                        break;
                    //case R.id.nav_poin:
                    //    navItemIndex = 4;
                    //    CURRENT_TAG = TAG_POIN;
                    //    break;
                    //case R.id.nav_infohealth:
                    //    navItemIndex = 5;
                    //    CURRENT_TAG = TAG_HEALTH;
                    //    break;
                    case R.id.nav_article:
                            navItemIndex = 4;
                            CURRENT_TAG = TAG_ARTICLE;
                            break;
                    case R.id.nav_share:
                        //navItemIndex = 6;
                        //CURRENT_TAG = SHARE;
                        // launch new intent instead of loading fragment
                        //startActivity(new Intent(MainNavigationDrawer.this, AboutUsActivity.class));
                        //drawer.closeDrawers();
                        //shareTextUrl();
                        //ShareTextFragment.newInstance();
                        //Log.i("navItemIndex", "share index "+navItemIndex);
                        DynamicDialogSelfLayoutFragment dialog = DynamicDialogSelfLayoutFragment.newInstance(fragmentActivity, false, DataReference.TAG_SHARE_TEXT);
                        dialog.show(fragmentActivity.getSupportFragmentManager(), DataReference.TAG_SHARE_TEXT);
                        break;
                //    case R.id.nav_info:
                        // launch new intent instead of loading fragment
                        //startActivity(new Intent(MainNavigationDrawer.this, PrivacyPolicyActivity.class));
                        //drawer.closeDrawers();
                //        navItemIndex = 7;
                //        CURRENT_TAG = INFO;
                        //SampleFragment_1 sFragment = new SampleFragment_1();
                        //sFragment.newInstance("Info","");
                //        break;
                    case R.id.comment:
                        navItemIndex = 8;
                        CURRENT_TAG = COMMENT;
                        break;
                    case R.id.aboutus:
                        DialogUtil.about(fragmentActivity, null, null, null,"ABOUT-US");
                        break;
                    case R.id.version:
                        //DialogUtil.about(fragmentActivity, null, null, null,"APP-VERSION");
                        //break;
                    default:
                        navItemIndex = 0;
                        //CURRENT_TAG = TAG_HOME;
                        break;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);
                //Log.i("navItemIndex", "I index "+navItemIndex);
                loadHomeFragment();

                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    private void shareTextUrl() {
        /*
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        // Add data to the intent, the receiving app will decide
        // what to do with it.
        share.putExtra(Intent.EXTRA_SUBJECT, "Download");
        share.putExtra(Intent.EXTRA_TEXT, "http://www.godok.com");

        startActivity(Intent.createChooser(share, "Bagikan"));
        */
        List<Intent> targetedShareIntents = new ArrayList<Intent>();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        List<ResolveInfo> resInfo = getPackageManager().queryIntentActivities(intent, 0);
        if (!resInfo.isEmpty()) {
            for (ResolveInfo resolveInfo : resInfo) {
                String packageName = resolveInfo.activityInfo.packageName;
                Log.i("PACKAGE_NAME", packageName);
                if (packageName.contains("facebook") ||
                        packageName.contains("twitter") ||
                        packageName.contains("bbm") ||
                        packageName.contains("gmail") ||
                        packageName.contains("email") ||
                        packageName.contains("whatsapp") ||
                        packageName.contains("hangeouts") ||
                        packageName.contains("com.google.android.apps.plus") ||
                        packageName.contains("kakao.talk") ||
                        packageName.contains("com.beetalk") ||
                        packageName.contains("org.telegram.messanger")) {
                    Intent targetedShareIntent = new Intent(Intent.ACTION_SEND);
                    targetedShareIntent.setType("text/plain");
                    targetedShareIntent.putExtra(Intent.EXTRA_TITLE, "");
                    targetedShareIntent.putExtra(Intent.EXTRA_SUBJECT, "");
                    //if ("com.facebook.katana".equals(packageName) || "com.facebook.orca".equals(packageName)) {
                    // don't add Facebook or Facebook messenger app to list
                    //    continue;
                    //} else {
                    targetedShareIntent.putExtra(Intent.EXTRA_TEXT, "http://www.godok.com");
                    //}
                    targetedShareIntent.setPackage(packageName);
                    targetedShareIntents.add(targetedShareIntent);
                }
            }

            Intent chooserIntent = Intent.createChooser(targetedShareIntents.remove(0), "Pilih Aplikasi");
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetedShareIntents.toArray(new Parcelable[]{}));
            startActivityForResult(chooserIntent, 123);
        }
    }

    @Override
    public void onBackPressed() {
        //Log.i("selectmenu","onBackPressed");
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            //Log.i("selectmenu","closeDrawer");
            return;
        }

        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        if (shouldLoadHomeFragOnBackPress) {
            // checking if user is on other navigation menu
            // rather than home
            //Log.i("selectmenu","shouldLoadHome");
            if (navItemIndex != 0) {
                //Log.i("selectmenu","NavItem-0");
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                loadHomeFragment();
                return;
            }
        }

        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        // show menu only when home fragment is selected
    //    if (navItemIndex == 0) {
    //        getMenuInflater().inflate(R.menu.main, menu);
    //    }

        // when fragment is notifications, load the menu created for notifications
    //    if (navItemIndex == 3) {
    //        getMenuInflater().inflate(R.menu.notifications, menu);
    //    }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Toast.makeText(getApplicationContext(), "Logout user!", Toast.LENGTH_LONG).show();
            return true;
        }

        // user is in notifications fragment
        // and selected 'Mark all as Read'
        if (id == R.id.action_mark_all_read) {
            Toast.makeText(getApplicationContext(), "All notifications marked as read!", Toast.LENGTH_LONG).show();
        }

        // user is in notifications fragment
        // and selected 'Clear All'
        if (id == R.id.action_clear_notifications) {
            Toast.makeText(getApplicationContext(), "Clear all notifications!", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    // show or hide the fab
//    private void toggleFab() {
//        if (navItemIndex == 0)
//            fab.show();
//        else
//            fab.hide();
//    }
}
