package com.devfusion.saurav.invision;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;


public class SearchFilterActivity extends AppCompatActivity {

    ImageView back,imv_blue,imv_green,imv_brown,imv_black,imv_grey,imv_darkbrown;
    ImageView imv_rec_lightbrown,imv_rec_black,imv_rec_darkbrown,imv_rec_silver,imv_greyishbrown,imv_rec_majanta;
    Button btn_apply;
    CrystalRangeSeekbar rangeSeekbar;
    TextView tvMin,tvMax;
    boolean clicked=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_filter);
        getSupportActionBar().hide();

        back=(ImageView)findViewById(R.id.back);
        imv_blue=(ImageView)findViewById(R.id.imv_blue);
        imv_green=(ImageView)findViewById(R.id.imv_green);
        imv_brown=(ImageView)findViewById(R.id.imv_brown);
        imv_black=(ImageView)findViewById(R.id.imv_black);
        imv_darkbrown=(ImageView)findViewById(R.id.imv_darkbrown);
        imv_grey=(ImageView)findViewById(R.id.imv_grey);

        imv_rec_lightbrown=(ImageView)findViewById(R.id.imv_rec_lightbrown);
        imv_rec_black=(ImageView)findViewById(R.id.imv_rec_black);
        imv_rec_darkbrown=(ImageView)findViewById(R.id.imv_rec_darkbrown);
        imv_rec_silver=(ImageView)findViewById(R.id.imv_rec_silver);
        imv_greyishbrown=(ImageView)findViewById(R.id.imv_greyishbrown);
        imv_rec_majanta=(ImageView)findViewById(R.id.imv_rec_majanta);


        btn_apply=(Button)findViewById(R.id.btn_apply);

        setRangeSeekbar1();
        setRangeSeekbar3();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),SwipeActivity.class);
                startActivity(intent);
            }
        });
        imv_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* if(clicked) {
                    System.out.println(" if clicked--blue");
                    //imv_blue.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_blue));
                    imv_blue.setImageResource(R.drawable.circle_blue);
                    imv_green.setImageResource(R.drawable.circle_green);
                    imv_brown.setImageResource(R.drawable.circle_brown);
                    imv_black.setImageResource(R.drawable.circle_black);
                    imv_grey.setImageResource(R.drawable.circle_grey);
                    imv_darkbrown.setImageResource(R.drawable.circle_darkbrown);
                    clicked=false;
                }
                else*/{
                    System.out.println(" else clicked--blue");
                    imv_blue.setImageResource(R.drawable.circle_blue_clicked);
                    imv_green.setImageResource(R.drawable.circle_green);
                    imv_brown.setImageResource(R.drawable.circle_brown);
                    imv_black.setImageResource(R.drawable.circle_black);
                    imv_grey.setImageResource(R.drawable.circle_grey);
                    imv_darkbrown.setImageResource(R.drawable.circle_darkbrown);
                    clicked=true;
                }
            }
        });
        imv_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* if(clicked) {
                    System.out.println(" if clicked--green");
                    imv_blue.setImageResource(R.drawable.circle_blue);
                    imv_green.setImageResource(R.drawable.circle_green);
                    imv_brown.setImageResource(R.drawable.circle_brown);
                    imv_black.setImageResource(R.drawable.circle_black);
                    imv_grey.setImageResource(R.drawable.circle_grey);
                    imv_darkbrown.setImageResource(R.drawable.circle_darkbrown);
                    clicked=false;
                }
                else*/{
                    System.out.println(" else clicked--green");
                    imv_blue.setImageResource(R.drawable.circle_blue);
                    imv_green.setImageResource(R.drawable.circle_green_clicked);
                    imv_brown.setImageResource(R.drawable.circle_brown);
                    imv_black.setImageResource(R.drawable.circle_black);
                    imv_grey.setImageResource(R.drawable.circle_grey);
                    imv_darkbrown.setImageResource(R.drawable.circle_darkbrown);

                    clicked=true;
                }
            }
        });
        imv_brown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("clicked--");
              /*  if(clicked) {
                    imv_brown.setImageResource(R.drawable.circle_brown);
                    clicked=false;
                }
                else*/{
                    imv_blue.setImageResource(R.drawable.circle_blue);
                    imv_green.setImageResource(R.drawable.circle_green);
                    imv_brown.setImageResource(R.drawable.circle_brown_clicked);
                    imv_black.setImageResource(R.drawable.circle_black);
                    imv_grey.setImageResource(R.drawable.circle_grey);
                    imv_darkbrown.setImageResource(R.drawable.circle_darkbrown);
                    clicked=true;
                }
            }
        });
        imv_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("clicked--");
                imv_blue.setImageResource(R.drawable.circle_blue);
                imv_green.setImageResource(R.drawable.circle_green);
                imv_brown.setImageResource(R.drawable.circle_brown);
                imv_black.setImageResource(R.drawable.circle_black_clicked);
                imv_grey.setImageResource(R.drawable.circle_grey);
                imv_darkbrown.setImageResource(R.drawable.circle_darkbrown);
            }
        });
        imv_grey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("clicked--");
                imv_blue.setImageResource(R.drawable.circle_blue);
                imv_green.setImageResource(R.drawable.circle_green);
                imv_brown.setImageResource(R.drawable.circle_brown);
                imv_black.setImageResource(R.drawable.circle_black);
                imv_grey.setImageResource(R.drawable.circle_grey_clicked);
                imv_darkbrown.setImageResource(R.drawable.circle_darkbrown);
            }
        });
        imv_darkbrown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("clicked--");
                imv_blue.setImageResource(R.drawable.circle_blue);
                imv_green.setImageResource(R.drawable.circle_green);
                imv_brown.setImageResource(R.drawable.circle_brown);
                imv_black.setImageResource(R.drawable.circle_black);
                imv_grey.setImageResource(R.drawable.circle_grey);
                imv_darkbrown.setImageResource(R.drawable.circle_darkbrown_clicked);
            }
        });

        imv_rec_lightbrown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("clicked--");
                imv_rec_lightbrown.setImageResource(R.drawable.rec_brown_clicked);
                imv_rec_black.setImageResource(R.drawable.rec_black);
                imv_rec_darkbrown.setImageResource(R.drawable.rec_darkbrown);
                imv_rec_silver.setImageResource(R.drawable.rec_grey);
                imv_greyishbrown.setImageResource(R.drawable.rec_greyishbrown);
                imv_rec_majanta.setImageResource(R.drawable.rec_majanta);
            }
        });
        imv_rec_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imv_rec_lightbrown.setImageResource(R.drawable.rec_brown);
                imv_rec_black.setImageResource(R.drawable.rec_black_clicked);
                imv_rec_darkbrown.setImageResource(R.drawable.rec_darkbrown);
                imv_rec_silver.setImageResource(R.drawable.rec_grey);
                imv_greyishbrown.setImageResource(R.drawable.rec_greyishbrown);
                imv_rec_majanta.setImageResource(R.drawable.rec_majanta);
            }
        });
        imv_rec_darkbrown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("clicked--");
                imv_rec_lightbrown.setImageResource(R.drawable.rec_brown);
                imv_rec_black.setImageResource(R.drawable.rec_black);
                imv_rec_darkbrown.setImageResource(R.drawable.rec_darkbrown_clicked);
                imv_rec_silver.setImageResource(R.drawable.rec_grey);
                imv_greyishbrown.setImageResource(R.drawable.rec_greyishbrown);
                imv_rec_majanta.setImageResource(R.drawable.rec_majanta);
            }
        });
        imv_rec_silver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("clicked--");
                imv_rec_lightbrown.setImageResource(R.drawable.rec_brown);
                imv_rec_black.setImageResource(R.drawable.rec_black);
                imv_rec_darkbrown.setImageResource(R.drawable.rec_darkbrown);
                imv_rec_silver.setImageResource(R.drawable.rec_grey_clicked);
                imv_greyishbrown.setImageResource(R.drawable.rec_greyishbrown);
                imv_rec_majanta.setImageResource(R.drawable.rec_majanta);
            }
        });
        imv_greyishbrown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("clicked--");
                imv_rec_lightbrown.setImageResource(R.drawable.rec_brown);
                imv_rec_black.setImageResource(R.drawable.rec_black);
                imv_rec_darkbrown.setImageResource(R.drawable.rec_darkbrown);
                imv_rec_silver.setImageResource(R.drawable.rec_grey);
                imv_greyishbrown.setImageResource(R.drawable.rec_greyishbrown_clicked);
                imv_rec_majanta.setImageResource(R.drawable.rec_majanta);
            }
        });
        imv_rec_majanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("clicked--");
                imv_rec_lightbrown.setImageResource(R.drawable.rec_brown);
                imv_rec_black.setImageResource(R.drawable.rec_black);
                imv_rec_darkbrown.setImageResource(R.drawable.rec_darkbrown);
                imv_rec_silver.setImageResource(R.drawable.rec_grey);
                imv_greyishbrown.setImageResource(R.drawable.rec_greyishbrown);
                imv_rec_majanta.setImageResource(R.drawable.rec_majanta_clicked);
            }
        });
    }
    private void setRangeSeekbar1(){

        // get seekbar from view
        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) findViewById(R.id.rangeSeekbar1);

        //final CrystalRangeSeekbar rangeSeekbar = (MyRangeSeekbar) findViewById(R.id.rangeSeekbar1);
        // get min and max text view
        final TextView tvMin = (TextView) findViewById(R.id.tv_years);
        final TextView tvMax = (TextView) findViewById(R.id.tv_cm);


        // set listener
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
               // tvMin.setText(String.valueOf(minValue));
               // tvMax.setText(String.valueOf(maxValue));
            }
        });
    }

    private void setRangeSeekbar3(){

        // get seekbar from view
        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) findViewById(R.id.rangeSeekbar3);

        // get min and max text view
        final TextView tvMin = (TextView) findViewById(R.id.tv_years);
        final TextView tvMax = (TextView) findViewById(R.id.tv_years);

      /*  // set properties
        rangeSeekbar
                .setCornerRadius(10f)
                .setBarColor(Color.parseColor("#93F9B5"))
                .setBarHighlightColor(Color.parseColor("#16E059"))
                .setMinValue(10)
                .setMaxValue(110)
                .setSteps(20)
                .setLeftThumbDrawable(R.drawable.thumb_android)
                .setLeftThumbHighlightDrawable(R.drawable.thumb_android_pressed)
                .setRightThumbDrawable(R.drawable.thumb_android)
                .setRightThumbHighlightDrawable(R.drawable.thumb_android_pressed)
                .setDataType(CrystalRangeSeekbar.DataType.INTEGER)
                .apply();*/

        // set listener
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
             //   tvMin.setText(String.valueOf(minValue));
              //  tvMax.setText(String.valueOf(maxValue));
            }
        });
    }


}
