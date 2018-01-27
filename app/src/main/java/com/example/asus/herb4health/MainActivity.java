package com.example.asus.herb4health;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.example.asus.herb4health.util.HelperView;
import com.google.firebase.database.ValueEventListener;
import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, GestureDetector.OnGestureListener {

    DatabaseReference rootRef,demoRef;
    Context mContext = MainActivity.this;

    private LinearLayout tilesContainer;
    private ScrollView mainScrollView;
    //public MediaPlayer mp3;
    public String value;


    private int[] colors = new int[6];

    private int ANIMATION_DURATION = 300; //in milliseconds
    private int firstChildHeight;
    private int defaultChildHeight;

    private boolean toAnimate = true;
    private boolean toFantasticScroll = true;

    private GestureDetectorCompat detector;
    private Toolbar appBar;

    NavigationView navigationView;

    private String[] messages = {
            "คลังสมุนไพร",
            "กลุ่มอาการและโรค",
            "ร่างกายกับอาการ",
            "แบบฝึกหัด",
            "อาหารเพื่อสุขภาพ",
            "ผลิตภัณฑ์จากสมุนไพร",
            "About us"
    };

    private String[] tagLines = {
            "รวมข้อมูลชื่อสรรพคุณทางยาและวิธีใช้สมุนไพรหลายชนิด",
            "กลุ่มอาการและโรคที่พบเจอได้บ่อย",
            "ผู้ใช้สามารถกดไปบนหุ่นจำลองเพื่อดูอาการได้ตามส่วนของอวัยวะต่างๆในร่างกาย",
            "เพื่อทดสอบความรู้ความเข้าใจเกี่ยวกับสมุนไพรผู้ใช้สามารถเล่นเกมส์เพื่อทบทวนความจำได้", "รวบรวมข้อมูลอาหารเพื่อสุขภาพ",
            "รวบรวมผลิตภัณฑ์ต่างๆ ที่ผลิตจากสมุนไพรซึ่งเป็นที่นิยม","รวมคำถามที่พบบ่อยและอีเมล์ืที่สามารถติดต่อเราได้"
    };

    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;
    private HerbFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootRef = FirebaseDatabase.getInstance().getReference();
        demoRef = rootRef.child("Knowledge");
        
        demoRef.child("id"+"1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                value = dataSnapshot.getValue(String.class);
                CallDialog(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });



        setUpNavigationDrawer();

        detector = new GestureDetectorCompat(this, this);
        int displayHeight = getWindowManager().getDefaultDisplay().getHeight();
        firstChildHeight = (displayHeight * 60) / 100; //first tile should cover 60% of height
        defaultChildHeight = displayHeight / 7;

        tilesContainer = (LinearLayout) findViewById(R.id.tileContainer);

        mainScrollView = (ScrollView) findViewById(R.id.mainScrollView);
        mainScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        addTilesToContainer();
    }

    public void CallDialog(String x) {
        appBar = (Toolbar) findViewById(R.id.landingPageAppBar);
        new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText("เกร็ดน่ารู้")
                .setContentText(x)
                .setCustomImage(R.drawable.about_icon_email)
                .show();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (toFantasticScroll) {
            detector.onTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    public void addTilesToContainer() {

        View tileView;

        int[] images = {
                R.drawable.herbsfunc,
                R.drawable.disert,
                R.drawable.hert2,
                R.drawable.exercise,
                R.drawable.food_bg1,
                R.drawable.product_bg2,
                R.drawable.ab
        };

        int numberOfTiles = 7;
        for (int i = 0; i < numberOfTiles; i++) {
            if (i == 0) {
                tileView = LayoutInflater.from(mContext).inflate(R.layout.content_fragment, null);
                tileView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        firstChildHeight));
                tileView.setTag("tile - " + messages[i]);
                tileView.setOnClickListener(this);

                ImageView imageView = (ImageView) tileView.findViewById(R.id.ivBackground);
                imageView.setImageResource(images[i]);
                tileView.setOnClickListener(this);

                Button button = (Button) tileView.findViewById(R.id.btnTileMessage);
                button.setText(messages[i]);
                button.setTag(i);
                button.setOnClickListener(this);

                TextView tagLine = (TextView) tileView.findViewById(R.id.tvTileTagLine);
                tagLine.setText(tagLines[i]);

                tilesContainer.addView(tileView);
            } else {
                tileView = LayoutInflater.from(mContext).inflate(R.layout.content_fragment, null);
                tileView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        defaultChildHeight));
                tileView.setTag("tile - " + messages[i]);
                tileView.setOnClickListener(this);

                ImageView imageView = (ImageView) tileView.findViewById(R.id.ivBackground);
                imageView.setImageResource(images[i]);
                tileView.setOnClickListener(this);

                Button button = (Button) tileView.findViewById(R.id.btnTileMessage);
                button.setText(messages[i]);
                button.setTag(i);
                button.setOnClickListener(this);

                TextView tagLine = (TextView) tileView.findViewById(R.id.tvTileTagLine);
                tagLine.setText(tagLines[i]);
                tagLine.setVisibility(View.INVISIBLE);

                tilesContainer.addView(tileView);
            }
        }

        HelperView.setPrecedingView(null);
        HelperView.setCurrentView(tilesContainer.getChildAt(0));
        HelperView.getCurrentView().findViewById(R.id.tvTileTagLine).setVisibility(View.VISIBLE);
        HelperView.setFollowingView(tilesContainer.getChildAt(1));

    }

    private void addFragmentToScreen(Fragment fragment) {
        Toast.makeText(this, "ยินดีต้องรับสู่คลังสมุนไพร", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this, FetchImageFirebase.class);
        startActivity(i);

    }

    @Override
    public void onClick(final View v) {

        if (v.getTag().toString().contains("tile")) {
            if (v.getLayoutParams().height != firstChildHeight) {
                expandView(v);
            } else {
                switch (tilesContainer.indexOfChild(v)) {
                    case 0:
                        if (tilesContainer.getChildAt(0).getLayoutParams().height != firstChildHeight) {
                            downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                        }
                        //กดรูปภาพแล้ว intent ไปอีกหน้า ภาพ 1

                        else {
                            isFragmentOpened = true;
                            fragment = (HerbFragment) Fragment.instantiate(this, HerbFragment.class.getName());
                            addFragmentToScreen(fragment);
                        }
                        break;

                    case 1:
                        if (tilesContainer.getChildAt(1).getLayoutParams().height != firstChildHeight) {
                            downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                        }
                        //กดรูปภาพแล้ว intent ไปอีกหน้า ภาพ 2

                        break;

                    case 2:
                        if (tilesContainer.getChildAt(2).getLayoutParams().height != firstChildHeight) {
                            downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                        }
                        break;

                    case 3:
                        if (tilesContainer.getChildAt(3).getLayoutParams().height != firstChildHeight) {
                            downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                        }

                        break;

                    case 4:
                        if (tilesContainer.getChildAt(4).getLayoutParams().height != firstChildHeight) {
                            downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                        }

                        break;

                    case 5:
                        break;

                    case 6:
                        break;
                }
            }
        }

        switch (v.getTag().toString()) {
            case "0":

                Toast.makeText(this, "ยินดีต้องรับสู่คลังสมุนไพร", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, FetchImageFirebase.class);
                startActivity(i);




                break;

            case "1":

                Toast.makeText(this, "ยินดีต้องรับสู่กลุ่มอาการและโรค", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(this, Newlist.class);
                startActivity(a);
                if (tilesContainer.getChildAt(1).getLayoutParams().height != firstChildHeight) {
                    downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                }




                break;

            case "2":


                Toast.makeText(this, "ยินดีต้องรับสู่หุ่นจำลองร่างกาย", Toast.LENGTH_SHORT).show();
                Intent b = new Intent(this, bodyhumenActivity.class);
                startActivity(b);
                if (tilesContainer.getChildAt(2).getLayoutParams().height != firstChildHeight) {
                    downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());

                }



                break;

            case "3":
                Toast.makeText(this, "ยินดีต้องรับสู่แบบฝึกหัด", Toast.LENGTH_SHORT).show();
                Intent c = new Intent(this, Cardview_main.class);

                startActivity(c);
                //music

               /* MediaPlayer mp3 = MediaPlayer.create(getApplicationContext(), R.raw.thaimusic);
                mp3.start(); */


                break;

            case "4":
                Toast.makeText(this, "ยินดีต้องรับสู่ อาหารเพื่อสุขภาพ", Toast.LENGTH_SHORT).show();
                Intent d = new Intent(this, CoverFlowMain.class);

                startActivity(d);

                break;
            case "5":
                Toast.makeText(this, "ยินดีต้องรับสู่ ผลิตภัณฑ์จากสมุนไพร", Toast.LENGTH_SHORT).show();
                Intent e = new Intent(this, FlowProductMain.class);

                startActivity(e);

                break;


            case "6":
                Toast.makeText(this, "ยินดีต้องรับสู่ ABout us", Toast.LENGTH_SHORT).show();


                break;
        }
    }

    public void expandView(final View view) {
        int currentScrollPosition = mainScrollView.getScrollY();
        int finalScrollPosition = view.getTop();

        ValueAnimator scrollAnimator = ValueAnimator.ofInt(currentScrollPosition, finalScrollPosition);
        scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int amount = (int) animation.getAnimatedValue();
                mainScrollView.scrollTo(0, amount);
            }
        });
        scrollAnimator.setDuration(ANIMATION_DURATION);

        ValueAnimator heightAnimator = ValueAnimator.ofInt(view.getHeight(), firstChildHeight);
        heightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int height = (int) animation.getAnimatedValue();
                view.getLayoutParams().height = height;
                view.requestLayout();
            }
        });
        heightAnimator.setDuration(ANIMATION_DURATION);

        scrollAnimator.start();
        heightAnimator.start();

        if (tilesContainer.indexOfChild(view) == 0) {
            //do nothing
        } else {
            HelperView.setPrecedingView(tilesContainer.getChildAt(tilesContainer.indexOfChild(view) - 1));
        }
        HelperView.setCurrentView(view);
        HelperView.setFollowingView(tilesContainer.getChildAt(tilesContainer.indexOfChild(view) + 1));
        HelperView.getCurrentView().findViewById(R.id.tvTileTagLine).setVisibility(View.VISIBLE);
        if (tilesContainer.indexOfChild(view) < 4) {
            HelperView.getFollowingView().findViewById(R.id.tvTileTagLine).setVisibility(View.INVISIBLE);
        }
    }


    @Override
    public boolean onDown(MotionEvent e) {
        //return true because every gesture start with onDown
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        final int SWIPE_MIN_DISTANCE = 50;
        final int SWIPE_THRESHOLD_VELOCITY = 200;

        if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE &&
                Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
            //Toast.makeText(this, "Bottom to top", Toast.LENGTH_SHORT).show();
            if (HelperView.getFollowingView() != null) {
                downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
            }
            //From Bottom to top
            return true;
        } else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE &&
                Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
            //Toast.makeText(this, "top to Bottom", Toast.LENGTH_SHORT).show();
            if (HelperView.getPrecedingView() != null) {
                upToDownScroll(HelperView.getPrecedingView(), HelperView.getCurrentView());
            }
            //From top to Bottom
            return true;
        }

        return true;
    }

    public void upToDownScroll(final View precedingView, final View currentView) {

        if (toAnimate) {

            toAnimate = false;

            if (tilesContainer.indexOfChild(currentView) == 0) {
                //do-nothing
            } else {
                int currentScrollPosition = mainScrollView.getScrollY();
                int toScrollPosition = precedingView.getTop();

                ValueAnimator scrollAnimator = ValueAnimator.ofInt(currentScrollPosition, toScrollPosition);
                scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int amount = (int) animation.getAnimatedValue();
                        mainScrollView.scrollTo(0, amount);
                    }
                });
                scrollAnimator.setDuration(ANIMATION_DURATION);

                ValueAnimator heightAnimator = ValueAnimator.ofInt(currentView.getLayoutParams().height, defaultChildHeight);
                heightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int height = (int) animation.getAnimatedValue();
                        currentView.getLayoutParams().height = height;
                        currentView.requestLayout();
                    }
                });
                heightAnimator.setDuration(ANIMATION_DURATION);

                scrollAnimator.start();
                heightAnimator.start();

                HelperView.setCurrentView(precedingView);
                HelperView.setPrecedingView(tilesContainer.getChildAt(tilesContainer.indexOfChild(precedingView) - 1));
                HelperView.setFollowingView(currentView);
                HelperView.getCurrentView().findViewById(R.id.tvTileTagLine).setVisibility(View.VISIBLE);
                HelperView.getFollowingView().findViewById(R.id.tvTileTagLine).setVisibility(View.INVISIBLE);

                scrollAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                        toAnimate = false;
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        toAnimate = true;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }
        }
    }

    public void downToUpScroll(View currentView, final View followingView) {

        if (toAnimate) {

            toAnimate = false;

            int currentScrollPosition = mainScrollView.getScrollY();
            int toScrollPosition = followingView.getTop();

            ValueAnimator scrollAnimator = ValueAnimator.ofInt(currentScrollPosition, toScrollPosition);
            scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int amount = (int) animation.getAnimatedValue();
                    mainScrollView.scrollTo(0, amount);
                }
            });
            scrollAnimator.setDuration(ANIMATION_DURATION);

            ValueAnimator heightAnimator = ValueAnimator.ofInt(followingView.getHeight(), firstChildHeight);
            heightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int height = (int) animation.getAnimatedValue();
                    followingView.getLayoutParams().height = height;
                    followingView.requestLayout();
                }
            });
            heightAnimator.setDuration(ANIMATION_DURATION);

            scrollAnimator.start();
            heightAnimator.start();

            scrollAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    toAnimate = true;
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

            HelperView.setPrecedingView(currentView);
            HelperView.setCurrentView(followingView);
            HelperView.setFollowingView(tilesContainer.getChildAt(tilesContainer.indexOfChild(followingView) + 1));
            HelperView.getCurrentView().findViewById(R.id.tvTileTagLine).setVisibility(View.VISIBLE);
        }
    }

    public void setUpNavigationDrawer() {

        navigationView = (NavigationView) findViewById(R.id.fragmentDrawer);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.mainDrawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                appBar,
                R.string.open,
                R.string.close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                toFantasticScroll = true;
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                toFantasticScroll = false;
            }
        };

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    boolean isFragmentOpened = false;


    //Detect Back Button
    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

        alertDialog.setTitle("คุณต้องการจะออกจากระบบใช่หรือไม่");

        alertDialog.setPositiveButton("ใช่",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //คลิกใช่ ออกจากโปรแกรม
                        finish();
                        MainActivity.super.onBackPressed();

                    }
                });

        alertDialog.setNegativeButton("ไม่",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //คลิกไม่ cancel dialog
                        dialog.cancel();
                    }
                });

        alertDialog.show();

    }

}

