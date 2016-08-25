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
 * Created by saurav on 30/07/16.
 */
public class LazyAdapter_Request extends BaseAdapter {

    ArrayList<HashMap<String, String>> data;
    HashMap<String, String> map = new HashMap<String, String>();
    Activity activity;

    private static LayoutInflater inflater = null;

    public LazyAdapter_Request(Activity a, ArrayList<HashMap<String, String>> d)
    {
        activity=a;
        data=d;
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

            cview = inflater.inflate(R.layout.row_list1, null);


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
