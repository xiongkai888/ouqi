package com.lanmei.ouqi.ui.mine.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;

import com.lanmei.ouqi.R;
import com.lanmei.ouqi.adapter.MineCouponAdapter;
import com.xson.common.app.BaseActivity;
import com.xson.common.widget.CenterTitleToolbar;

import butterknife.InjectView;


/**
 * 我的优惠卷
 */
public class MineCouponActivity extends BaseActivity {


    @InjectView(R.id.toolbar)
    CenterTitleToolbar toolbar;
    @InjectView(R.id.viewPager)
    ViewPager mViewPager;
    @InjectView(R.id.tabLayout)
    TabLayout mTabLayout;

    @Override
    public int getContentViewId() {
        return R.layout.activity_mine_coupon;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowTitleEnabled(true);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle(R.string.mine_coupon);
        actionbar.setHomeAsUpIndicator(R.mipmap.back);

        mViewPager.setAdapter(new MineCouponAdapter(getSupportFragmentManager(),this));
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
