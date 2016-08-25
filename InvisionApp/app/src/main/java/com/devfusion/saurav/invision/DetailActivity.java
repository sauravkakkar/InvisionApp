package com.devfusion.saurav.invision;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    ImageView imv_add,imv_back;
    Button btn_edit,btn_searching;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        getSupportActionBar().hide();

        imv_back=(ImageView)findViewById(R.id.imv_back);
        imv_add=(ImageView)findViewById(R.id.imv_add);
        btn_edit = (Button)findViewById(R.id.btn_edit);
        btn_searching = (Button)findViewById(R.id.btn_searching);

        imv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddSkillActivity.class);
                startActivity(intent);

            }
        });
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AfterLogin.class);
                startActivity(intent);
            }
        });
        btn_searching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(intent);
                finish();
            }
        });

        imv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }// on create
}
