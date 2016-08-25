package com.devfusion.saurav.invision;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class UserProfileActivity extends AppCompatActivity {

    TextView tv_profile,tv_setting,tv_request,tv_address,tv_name;
    Button btn_edit;
    ImageView back,search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);
        getSupportActionBar().hide();

        tv_profile=(TextView)findViewById(R.id.tv_profile);
        tv_setting=(TextView)findViewById(R.id.tv_setting);
        tv_request=(TextView)findViewById(R.id.tv_request);
        tv_address=(TextView)findViewById(R.id.tv_address);
        btn_edit=(Button)findViewById(R.id.btn_edit);
        back=(ImageView) findViewById(R.id.back);
        search=(ImageView) findViewById(R.id.search);

        tv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),DetailActivity.class);
                startActivity(intent);
            }
        });

        tv_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),SettingActivity.class);
                startActivity(intent);
            }
        });
        tv_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),RequestActivity.class);
                startActivity(intent);
            }
        });
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),AddSkillActivity.class);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
