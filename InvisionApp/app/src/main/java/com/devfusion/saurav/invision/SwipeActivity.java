package com.devfusion.saurav.invision;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.*;
import android.widget.RelativeLayout.LayoutParams;

import java.util.ArrayList;
import java.util.List;

import com.bumptech.glide.Glide;


public class SwipeActivity extends AppCompatActivity implements FlingCardListener.ActionDownInterface {

    public static MyAppAdapter myAppAdapter;
    public static ViewHolder viewHolder;
    private ArrayList<Data> al;
    private SwipeFlingAdapterView flingContainer;
    ImageView chat,user;


    public static void removeBackground() {
       // viewHolder.background.setVisibility(View.GONE);
        myAppAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe);
        getSupportActionBar().hide();
        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);
        user=(ImageView)findViewById(R.id.user);
        chat=(ImageView)findViewById(R.id.chat);

        al = new ArrayList<>();
        al.add(new Data("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness."));
        al.add(new Data("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness."));
        al.add(new Data("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness."));
        al.add(new Data("http://switchboard.nrdc.org/blogs/dlashof/mission_impossible_4-1.jpg", "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness."));
        al.add(new Data("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness."));

        myAppAdapter = new MyAppAdapter(al, SwipeActivity.this);
        flingContainer.setAdapter(myAppAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {

            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                al.remove(0);
                myAppAdapter.notifyDataSetChanged();
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                Toast.makeText(getApplicationContext(),"Left swipe..",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {

                al.remove(0);
                myAppAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"Right swipe..",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {

            }

            @Override
            public void onScroll(float scrollProgressPercent) {

                View view = flingContainer.getSelectedView();
               // view.findViewById(R.id.background).setAlpha(0);
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {

              //  View view = flingContainer.getSelectedView();
                //view.findViewById(R.id.background).setAlpha(0);
               // myAppAdapter.notifyDataSetChanged();
                System.out.println("position is.."+itemPosition);
                Intent i = new Intent(getApplicationContext(), ApplyFilter.class);
                startActivity(i);
                //finish();

            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),InboxActivity.class);
                startActivity(intent);
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UserProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onActionDownPerform() {

        Log.e("action", "bingo");
    }

    public static class ViewHolder {
      //  public static FrameLayout background;

         TextView tv_name,tv_disance,tv_color,tv_about,tv_content,tv_skill;
         Button btn_invite,btn_photographer,btn_director;
         boolean abc=true;
         ImageView cardImage,imv_down;
         RelativeLayout rl_hide,rl_main,rl_top;
         Data data;
    }
   /* public void downClick(View v){
System.out.println("downClick--->");
       // ViewHolder viewHolder = new ViewHolder();
        if(viewHolder.abc) {
            viewHolder.rl_hide.setVisibility(View.GONE);

          //  RelativeLayout relativeLayout = findViewById(R.id.your_relative_layout);

            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.MATCH_PARENT); // or wrap_content
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

           // viewHolder.rl_main.addView(viewHolder.rl_top , layoutParams);
            viewHolder.abc=false;
            myAppAdapter.notifyDataSetInvalidated();
            System.out.println("if case-->"+viewHolder.abc);
        }
        else {
            viewHolder.rl_hide.setVisibility(View.VISIBLE);
            viewHolder.abc=true;
            myAppAdapter.notifyDataSetInvalidated();
            System.out.println("else case-->"+viewHolder.abc);
        }
    }*/

    public class MyAppAdapter extends BaseAdapter {


        public List<Data> parkingList;
        public Context context;

        private MyAppAdapter(List<Data> apps, Context context) {
            this.parkingList = apps;
            this.context = context;
        }

        @Override
        public int getCount() {
            return parkingList.size();
        }

        @Override
        public Object getItem(int position) {
            return parkingList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        int playingItemPosition=-1;
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

          View rowView = convertView;


            if (rowView == null) {

                LayoutInflater inflater = getLayoutInflater();
                rowView = inflater.inflate(R.layout.item_swipe, parent, false);

                // configure view holder
                viewHolder = new ViewHolder();
                viewHolder.data = parkingList.get(position);
                viewHolder.tv_name=(TextView)rowView.findViewById(R.id.tv_name);
                viewHolder.tv_disance=(TextView)rowView.findViewById(R.id.tv_disance);
                viewHolder.tv_color=(TextView)rowView.findViewById(R.id.tv_color);
                viewHolder.tv_about=(TextView)rowView.findViewById(R.id.tv_about);
                viewHolder.tv_content=(TextView)rowView.findViewById(R.id.tv_content);
                viewHolder.tv_skill=(TextView)rowView.findViewById(R.id.tv_skill);

                viewHolder.imv_down=(ImageView)rowView.findViewById(R.id.imv_down);

                viewHolder.btn_invite=(Button)rowView.findViewById(R.id.btn_invite);
                viewHolder.btn_photographer=(Button)rowView.findViewById(R.id.btn_photographer);
                viewHolder.btn_director=(Button)rowView.findViewById(R.id.btn_director);
                viewHolder.cardImage = (ImageView) rowView.findViewById(R.id.cardImage);

                viewHolder.rl_hide = (RelativeLayout)rowView.findViewById(R.id.rl_hide);
                viewHolder.rl_main = (RelativeLayout)rowView.findViewById(R.id.rl_main);
                viewHolder.rl_top = (RelativeLayout)rowView.findViewById(R.id.rl_top);

                viewHolder.imv_down.setTag(viewHolder.data);
                viewHolder.imv_down.setTag(position);
                viewHolder.rl_hide.setTag(viewHolder.data);
                viewHolder.rl_main.setTag(viewHolder.data);
                rowView.setTag(viewHolder);

               /* viewHolder.btn_invite.setVisibility(View.GONE);
                viewHolder.tv_color.setVisibility(View.GONE);
                viewHolder.tv_about.setVisibility(View.GONE);
                viewHolder.tv_content.setVisibility(View.GONE);
                viewHolder.tv_skill.setVisibility(View.GONE);
                viewHolder.btn_photographer.setVisibility(View.GONE);
                viewHolder.btn_director.setVisibility(View.GONE);
                viewHolder.abc=false;*/

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
                viewHolder.imv_down.getTag();
                viewHolder.rl_hide.getTag();
               // viewHolder.rl_main.getTag();
            }


            viewHolder.imv_down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                      //  Data abc= (Data)v.getTag();

                    int position1=(Integer)v.getTag();
                    /*System.out.println("get.view--->"+position);*/

                    final int position = flingContainer.getPositionForView((View) v.getParent());

                    System.out.println("image view clicked..."+position);
                    if(viewHolder.abc)
                    {
                        //();
                          Toast.makeText(getApplicationContext(), "if case: " , Toast.LENGTH_SHORT).show();

                       // viewHolder.rl_main.setVisibility(View.GONE);
                        LayoutParams lp = (LayoutParams) viewHolder.rl_main.getLayoutParams();
                        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                        viewHolder.rl_main.setLayoutParams(lp);

                        viewHolder.rl_hide.setVisibility(View.GONE);
                       /*RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT); // or wrap_content
                        layoutParams.addRule(viewHolder.rl_main.ALIGN_PARENT_BOTTOM);
                        layoutParams.addRule(viewHolder.rl_top.ALIGN_PARENT_BOTTOM);
                        viewHolder.imv_down.setLayoutParams(layoutParams);*/
                        //viewHolder.rl_main.addView(viewHolder.tv_name , layoutParams);

                        System.out.println("if case... "+viewHolder.abc);
                        viewHolder.tv_name.setText("saurav..");
                        /*viewHolder.btn_invite.setVisibility(View.GONE);
                        viewHolder.tv_color.setVisibility(View.GONE);
                        viewHolder.tv_about.setVisibility(View.GONE);
                        viewHolder.tv_content.setVisibility(View.GONE);
                        viewHolder.tv_skill.setVisibility(View.GONE);
                        viewHolder.btn_photographer.setVisibility(View.GONE);
                        viewHolder.btn_director.setVisibility(View.GONE);*/
                        viewHolder.abc=false;
                      /*  myAppAdapter.notifyDataSetInvalidated();
                        myAppAdapter.notifyDataSetChanged();*/

                    }
                    else
                    {
                        myAppAdapter.notifyDataSetInvalidated();
                        myAppAdapter.notifyDataSetChanged();
                        System.out.println("else case... "+viewHolder.abc);
                        viewHolder.tv_name.setText("Kakkar..");
                        viewHolder.rl_hide.setVisibility(View.VISIBLE);;
                      //  viewHolder.rl_main.setVisibility(View.VISIBLE);

                        /*viewHolder.btn_invite.setVisibility(View.VISIBLE);
                        viewHolder.tv_color.setVisibility(View.VISIBLE);
                        viewHolder.tv_about.setVisibility(View.VISIBLE);
                        viewHolder.tv_content.setVisibility(View.VISIBLE);
                        viewHolder.tv_skill.setVisibility(View.VISIBLE);
                        viewHolder.btn_photographer.setVisibility(View.VISIBLE);
                        viewHolder.btn_director.setVisibility(View.VISIBLE);*/
                        viewHolder.abc=true;
                          Toast.makeText(getApplicationContext(), "else case: " , Toast.LENGTH_SHORT).show();
                        myAppAdapter.notifyDataSetInvalidated();
                        myAppAdapter.notifyDataSetChanged();
                    }

                }
            });




            viewHolder.imv_down.setTag(position);

            // Glide.with(SwipeActivity.this).load(parkingList.get(position).getImagePath()).into(viewHolder.cardImage);
            Glide.with(SwipeActivity.this).load(R.drawable.temp).into(viewHolder.cardImage);


            //set values to your items
           // viewHolder.imv_down.setTag(position);
            return rowView;
        }
    }


    public void updateList(){
        System.out.println("updateList called---");
        al.add(new Data("http://i.ytimg.com/vi/PnxsTxV8y3g/maxresdefault.jpg", "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness."));

       // myAppAdapter.notifyDataSetInvalidated();
    }
}
