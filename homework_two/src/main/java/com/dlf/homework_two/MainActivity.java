package com.dlf.homework_two;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.dlf.homework_two.databinding.ActivityMainBinding;
import com.dlf.homework_two.fragment.BlankFragment;
import com.dlf.homework_two.fragment.HomeFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding root;
    private BlankFragment blankFragment;
    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        root = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(root.getRoot());
        initView();
    }

    private void initView() {
        homeFragment = new HomeFragment();
        blankFragment = new BlankFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(root.frame.getId(),homeFragment);
        transaction.add(root.frame.getId(),blankFragment);
        transaction.commit();
        getCommit();
        getSupportFragmentManager().beginTransaction().show(blankFragment).commit();
        root.tab.addTab(root.tab.newTab().setText("Home"));
        root.tab.addTab(root.tab.newTab().setText("Blank"));
        root.tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        getCommit();
                        getSupportFragmentManager().beginTransaction().show(homeFragment).commit();
                        break;
                    case 1:
                        getCommit();
                        getSupportFragmentManager().beginTransaction().show(blankFragment).commit();
                        break;
                }
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        root.tab.getTabAt(0).setText("Home");
//        root.tab.getTabAt(1).setText("Blank");

    }

    private void getCommit() {
        getSupportFragmentManager().beginTransaction().hide(blankFragment).hide(homeFragment).commit();
    }
}
