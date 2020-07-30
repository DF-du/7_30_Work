package com.dlf.project.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class Fragment_Adapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
//    private ArrayList<String> titles;

    public Fragment_Adapter(@NonNull FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
//        this.titles = titles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

 /*   @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }*/
}
