package com.devfusion.saurav.invision;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by saurav on 01/08/16.
 */
public class Adapter_Filter extends BaseAdapter {

    ArrayList<HashMap<String,String>> data;
    HashMap<String,String>map = new HashMap<>();
    Activity activity;
    private static LayoutInflater inflater = null;

    public Adapter_Filter(Activity activity,ArrayList<HashMap<String,String>> d)
    {
        this.activity=activity;
        data = d;

        // imageLoader=new ImageLoader(activity);
        inflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        System.out.println("adapter called...");
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View cview = convertView;
        if (cview == null)
        {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            cview = inflater.inflate(R.layout.list_filter, null);


        }
       /* tv2 = (TextView) (cview.findViewById(R.id.textview));
        tv3 = (TextView) (cview.findViewById(R.id.textview1));
        tv5 = (TextView) (cview.findViewById(R.id.textview2));
        imv1 = (ImageView) (cview.findViewById(R.id.imageview));*/

        //String title_title=pl.get(position).getTitle();


      /*  if(rqstType.equals("saved"))
        {


            //imageLoader.DisplayImage(pl.get(position).getImage(), imv1);
        }*/
        return cview;
    }
}
