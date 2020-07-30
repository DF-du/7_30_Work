package com.dlf.project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.dlf.project.adapter.Fragment_Adapter;
import com.dlf.project.fragment.HomeFragment;
import com.dlf.project.fragment.SqlLiteFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Fragment> fragments;
    private Toolbar toolbar;
    private ViewPager vp;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);
        setSupportActionBar(toolbar);
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new SqlLiteFragment());
        Fragment_Adapter adapter = new Fragment_Adapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(adapter);
        //viewpager的适配器帮忙添加tab
        //关联tablayout和viewpager
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("首页");
        tab.getTabAt(1).setText("收藏");
    }

}
