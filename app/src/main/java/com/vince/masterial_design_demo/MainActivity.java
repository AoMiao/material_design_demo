package com.vince.masterial_design_demo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private NavigationView nav_layout;
    private DrawerLayout draw_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nav_layout = (NavigationView) findViewById(R.id.nav_layout);
        draw_layout = (DrawerLayout) findViewById(R.id.draw_layout);
        ActionBar actionBar = getSupportActionBar();//获取actionbar实例，实际上是Toolbar
        actionBar.setDisplayHomeAsUpEnabled(true);//显示HomeAsUp导航键
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//监听HomeAsUp导航键
        switch (item.getItemId()){
            case android.R.id.home:
                draw_layout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }
}
