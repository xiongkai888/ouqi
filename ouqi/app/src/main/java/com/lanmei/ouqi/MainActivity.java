package com.lanmei.ouqi;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.lanmei.ouqi.adapter.MainPagerAdapter;
import com.lanmei.ouqi.helper.TabHelper;
import com.xson.common.app.BaseActivity;

import butterknife.InjectView;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.viewPager)
    ViewPager mViewPager;
    @InjectView(R.id.tabLayout)
    TabLayout mTabLayout;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        mViewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(4);
        mTabLayout.setupWithViewPager(mViewPager);

        new TabHelper(this, mTabLayout);
    }

}
