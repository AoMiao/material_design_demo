package com.vince.masterial_design_demo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ItemActivity extends AppCompatActivity {
    public static final String CHARACTER_NAME = "NAME";
    public static final String CHARACTER_IMAGE = "IMAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>=21){
            View drcorView = getWindow().getDecorView();
            //让actvity的布局充满整个屏幕，包括状态栏
            drcorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);//状态栏颜色为透明
        }
        setContentView(R.layout.activity_character);
        Intent intent = getIntent();
        ImageView imageView = (ImageView) findViewById(R.id.character_image2);
        int id = intent.getIntExtra(ItemActivity.CHARACTER_IMAGE,0);
        TextView textView = (TextView) findViewById(R.id.character_text2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.character_toolbar);
        toolbar.setTitle(intent.getStringExtra(ItemActivity.CHARACTER_NAME));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Glide.with(this).load(id).into(imageView);
        textView.setText(intent.getIntExtra("text",0));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
