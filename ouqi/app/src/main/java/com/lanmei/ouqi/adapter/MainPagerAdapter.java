package com.lanmei.ouqi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lanmei.ouqi.ui.classify.ClassifyFragment;
import com.lanmei.ouqi.ui.home.HomeFragment;
import com.lanmei.ouqi.ui.mine.MineFragment;
import com.lanmei.ouqi.ui.share_bill.ShareBillFragment;


public class MainPagerAdapter extends FragmentPagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();//首页
            case 1:
                return new ClassifyFragment();//分类
            case 2:
                return new ShareBillFragment();//拼单
            case 3:
                return new HomeFragment();//购物车
            case 4:
                return new MineFragment();//我的
        }
        return new HomeFragment();
    }

    @Override
    public int getCount() {
        return 5;
    }

}
