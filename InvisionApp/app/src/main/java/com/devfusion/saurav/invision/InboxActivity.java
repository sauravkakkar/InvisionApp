package com.devfusion.saurav.invision;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class InboxActivity extends AppCompatActivity {

    ListView list;
    LazyAdapter adapter;

    ImageView back,file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inbox);
        getSupportActionBar().hide();
/*
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowCustomEnabled(true);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setIcon(R.drawable.slider_left);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.ustom_actionbar2, null);
        back = (ImageView)mCustomView.findViewById(R.id.back);
        mActionBar.setCustomView(mCustomView);*/
        back=(ImageView)findViewById(R.id.back);
        file=(ImageView)findViewById(R.id.file);

        list=(ListView)findViewById(R.id.listview);
        ArrayList<HashMap<String,String>> arraylist = new ArrayList<HashMap<String, String>>();

        adapter = new LazyAdapter(this,arraylist);
      //  adapter = new LazyAdapter(this);
        list.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Inbox_Accept.class);
                startActivity(intent);

            }
        });

    }

}
