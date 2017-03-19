package com.vince.masterial_design_demo;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.vince.masterial_design_demo.model.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //private NavigationView nav_layout;
    private DrawerLayout draw_layout;
    private CharacterAdapter adapter;
    private Random random;
    private List<Character> list = new ArrayList();
    private Character[] characters = {new Character("香克斯",R.drawable.a),new Character("罗罗诺亚·索隆",R.drawable.b),
            new Character("山治",R.drawable.c),new Character("波特卡斯·D·艾斯",R.drawable.d),new Character("妮可·罗宾",R.drawable.e),
            new Character("布鲁克",R.drawable.f),new Character("波雅·汉库克",R.drawable.g),new Character("战国",R.drawable.h),
            new Character("特拉法尔加·罗",R.drawable.i),new Character("乔拉可尔·米霍克",R.drawable.j),new Character("沙·克洛克达尔",R.drawable.k),
            new Character("巴基",R.drawable.l),new Character("多弗朗明哥",R.drawable.m)};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //nav_layout = (NavigationView) findViewById(R.id.nav_layout);
        draw_layout = (DrawerLayout) findViewById(R.id.draw_layout);
        ActionBar actionBar = getSupportActionBar();//获取actionbar实例，实际上是Toolbar
        actionBar.setDisplayHomeAsUpEnabled(true);//显示HomeAsUp导航键

        initCharacters();
        adapter = new CharacterAdapter(list);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager manager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

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
    public void initCharacters(){
        list.clear();
        for (int i=0;i<characters.length;i++){
            //random = new Random();
            //int index = random.nextInt(characters.length);
            //list.add(characters[index]);
            list.add(characters[i]);
        }
    }
}
