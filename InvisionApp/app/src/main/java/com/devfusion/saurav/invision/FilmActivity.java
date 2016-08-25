package com.devfusion.saurav.invision;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FilmActivity extends AppCompatActivity {

    ImageView back,imv_film;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film);

        getSupportActionBar().hide();
        back=(ImageView)findViewById(R.id.back);
        imv_film=(ImageView)findViewById(R.id.imv_film);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
