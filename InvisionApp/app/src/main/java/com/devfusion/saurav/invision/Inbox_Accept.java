package com.devfusion.saurav.invision;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Inbox_Accept extends AppCompatActivity  {

    TextView tv_done;
    ImageView back;
    ListView listview;

    ListView list;
    LazyAdapter_Accept adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inbox__accept);
        getSupportActionBar().hide();

        back=(ImageView)findViewById(R.id.back);
        tv_done=(TextView)findViewById(R.id.tv_done);

        list=(ListView)findViewById(R.id.listview);
        ArrayList<HashMap<String,String>> arraylist = new ArrayList<HashMap<String, String>>();

        adapter = new LazyAdapter_Accept(this,arraylist);
        //  adapter = new LazyAdapter(this);
        list.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tv_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
