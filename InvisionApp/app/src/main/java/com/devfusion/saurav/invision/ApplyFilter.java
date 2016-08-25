package com.devfusion.saurav.invision;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.LinearLayout;

import com.devfusion.saurav.invision.DirectionalViewPager.OnPageChangeListener;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ApplyFilter extends AppCompatActivity implements OnPageChangeListener{

    // ImageView user,chat;
    //ListView listview;

    //private ImageView mBg;
    private int mCurrentItem;
    Adapter_Filter adapter;
    ArrayList<HashMap<String, String>> arraylist = new ArrayList<>();


    private static final Integer[] IMAGES = {R.drawable.temp, R.drawable.temp, R.drawable.temp, R.drawable.temp};

    private final static int DIRECTION = DirectionalViewPager.VERTICAL;
    private DirectionalViewPager mDirectionalViewPager;
    private LinearLayout linearLayoutIndicator;
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    private List<ImageView> imageViewIndicatorList = null;


    boolean abc = true;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apply_filter);
        getSupportActionBar().hide();

       /* user=(ImageView)findViewById(R.id.user);
        chat=(ImageView)findViewById(R.id.chat);
        listview=(ListView)findViewById(R.id.listview);*/

        init();
        initIndicator();


        adapter = new Adapter_Filter(this, arraylist);
        //  listview.setAdapter(adapter);

       /* user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),InboxActivity.class);
                startActivity(intent);

            }
        });*/
       /* listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"position is:"+position,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),SwipeActivity.class);
                startActivity(intent);
            }
        });*/

    }


    private void init() {

        for (int i = 0; i < IMAGES.length; i++) ImagesArray.add(IMAGES[i]);

        mDirectionalViewPager = (DirectionalViewPager) findViewById(R.id.pager);
        linearLayoutIndicator = (LinearLayout) findViewById(R.id.indicator_ll);
        mDirectionalViewPager.setOrientation(DIRECTION);
        mDirectionalViewPager.setAdapter(new SlidingImage_Adapter(ApplyFilter.this, ImagesArray));
        mDirectionalViewPager.setOnPageChangeListener(this);

        /* for(int i=0;i<IMAGES.length;i++) ImagesArray.add(IMAGES[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(MainActivity.this,ImagesArray));
        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);
        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(5 * density);
        NUM_PAGES =IMAGES.length;*/



      /*  // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);*/

        // Pager listener over indicator
       /* indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });*/

    }

    private void initIndicator() {
        imageViewIndicatorList = new ArrayList<ImageView>();

        linearLayoutIndicator.setOrientation(DIRECTION);
        if (DIRECTION == DirectionalViewPager.HORIZONTAL) {
            linearLayoutIndicator.setPadding(
                    getPaddingLeft(), 0, 0, dp2px(this, 10));
            linearLayoutIndicator.setGravity(Gravity.BOTTOM);
        } else {
            linearLayoutIndicator.setPadding(dp2px(this, 10), 0, 0, 0);
            linearLayoutIndicator.setGravity(Gravity.RIGHT);
        }

        for (int i = 0; i < IMAGES.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            if (DIRECTION == DirectionalViewPager.HORIZONTAL) {
                iv.setPadding(dp2px(this, 15), 0, 0, 0);
            } else {
                iv.setPadding(0, dp2px(this, 10), 0, 0);
            }

            if (i == 0) {

                iv.setImageResource(R.drawable.shape_sel);
            } else {
                iv.setImageResource(R.drawable.shape_nor);
            }
             imageViewIndicatorList.add(iv);
            linearLayoutIndicator.addView(iv);
        }
    }


    public static int dp2px(Context paramContext, float paramFloat) {
        DisplayMetrics localDisplayMetrics = paramContext.getResources()
                .getDisplayMetrics();
        return (int) TypedValue.applyDimension(1, paramFloat,
                localDisplayMetrics);
    }

    public int getPaddingLeft() {

        return getScreenWidth() / 2 - dp2px(this, 48);//48=15+5+15+5+15/2
    }

    public int getScreenHeigh() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    public int getScreenWidth() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //super.onSaveInstanceState(outState);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        System.out.println("onPageScrolled");
        if (positionOffset == 0.0f)
            return;
        if(DIRECTION == DirectionalViewPager.HORIZONTAL) {
            // mBg.setX(-((position + positionOffset) * mSize));
        }else {
            // mBg.setY(-((position + positionOffset) * mSize));
        }
    }

    @Override
    public void onPageSelected(int position) {
        mCurrentItem = position;
        System.out.println("onPageSelected--- "+mCurrentItem);
        System.out.println("imageViewIndicatorList size---"+imageViewIndicatorList);
        for (int i = 0; i < imageViewIndicatorList.size(); i++) {
            if (position == i) {
                imageViewIndicatorList.get(i).setImageResource(
                        R.drawable.shape_sel);
            } else {
                imageViewIndicatorList.get(i).setImageResource(
                        R.drawable.shape_nor);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        System.out.println("onPageScrollStateChanged");
        if (state == ViewPager.SCROLL_STATE_IDLE) {
            if(DIRECTION == DirectionalViewPager.HORIZONTAL) {
                /// mBg.setX(-mCurrentItem * mSize);
            }else {
                // mBg.setY(-mCurrentItem * mSize);
            }
        }
    }


}
