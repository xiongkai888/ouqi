package com.lanmei.ouqi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lanmei.ouqi.ui.home.HomeFragment;


public class MainPagerAdapter extends FragmentPagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
//        switch (position) {
//            case 0:
//                return new HomeFragment();//首页
//            case 1:
//                return new HomeFragment();//消息
//            case 2:
//                return new HomeFragment();//教程
//            case 3:
//                return new HomeFragment();//我的
//            case 4:
//                return new HomeFragment();//我的
//        }
        return new HomeFragment();
    }

    @Override
    public int getCount() {
        return 5;
    }

}
