package com.devfusion.saurav.invision;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SkillActivity extends AppCompatActivity {

    ImageView back,imv_film,imv_theater,imv_fashion,imv_music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skill);
        getSupportActionBar().hide();
        back=(ImageView)findViewById(R.id.back);

        imv_film=(ImageView)findViewById(R.id.imv_film);
        imv_theater=(ImageView)findViewById(R.id.imv_theater);
        imv_fashion=(ImageView)findViewById(R.id.imv_fashion);
        imv_music=(ImageView)findViewById(R.id.imv_music);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        imv_film.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),FilmActivity.class);
                startActivity(intent);
            }
        });
        imv_theater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),FilmActivity.class);
                startActivity(intent);
            }
        });
        imv_fashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),FilmActivity.class);
                startActivity(intent);
            }
        });
        imv_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),FilmActivity.class);
                startActivity(intent);
            }
        });

    }
}
