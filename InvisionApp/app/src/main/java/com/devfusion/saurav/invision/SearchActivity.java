package com.devfusion.saurav.invision;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SearchActivity extends AppCompatActivity {

    ImageView user,chat;
    Button btn_searching;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        getSupportActionBar().hide();

        user=(ImageView)findViewById(R.id.user);
        chat=(ImageView)findViewById(R.id.chat);

        btn_searching = (Button)findViewById(R.id.btn_searching);


        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UserProfileActivity.class);
                startActivity(intent);

            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),InboxActivity.class);
                startActivity(intent);

            }
        });
        btn_searching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SearchFilterActivity.class);
                startActivity(intent);
            }
        });


    }
}
