package com.devfusion.saurav.invision;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class RequestActivity extends AppCompatActivity {

    ListView list;
    LazyAdapter_Request adapter;

    ImageView user,chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request);
        getSupportActionBar().hide();

        user=(ImageView)findViewById(R.id.back);
        chat=(ImageView)findViewById(R.id.file);

        list=(ListView)findViewById(R.id.listview);
        ArrayList<HashMap<String,String>> arraylist = new ArrayList<HashMap<String, String>>();

        adapter = new LazyAdapter_Request(this,arraylist);
        //  adapter = new LazyAdapter(this);
        list.setAdapter(adapter);

        user.setOnClickListener(new View.OnClickListener() {
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
        });
    }
}
