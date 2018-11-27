package com.lanmei.ouqi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import com.lanmei.ouqi.adapter.MainPagerAdapter;
import com.lanmei.ouqi.helper.TabHelper;
import com.xson.common.app.BaseActivity;
import com.xson.common.widget.NoScrollViewPager;

import butterknife.InjectView;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.viewPager)
    NoScrollViewPager mViewPager;
    @InjectView(R.id.tabLayout)
    TabLayout mTabLayout;
    TabHelper tabHelper;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        mViewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        mViewPager.setNoScroll(true);
        mViewPager.setOffscreenPageLimit(4);
        mTabLayout.setupWithViewPager(mViewPager);

        tabHelper = new TabHelper(this, mTabLayout);
        tabHelper.setOrderNum(0);
    }

    public static final String ACTION_SHOW_HOME = "android.intent.action.SHOW_HOME";
    public static final String ACTION_SHARE_BILL = "android.intent.action.SHARE_BILL";

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (ACTION_SHOW_HOME.equals(intent.getAction())) {
            mViewPager.setCurrentItem(0);
        }else if (ACTION_SHARE_BILL.equals(intent.getAction())){
            mViewPager.setCurrentItem(2);
        }
    }

    public static void showHome(Context context) {//至首页
        Intent intent = new Intent(ACTION_SHOW_HOME);
        intent.setClass(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static void showShareBill(Context context) {//至拼团
        Intent intent = new Intent(ACTION_SHARE_BILL);
        intent.setClass(context, MainActivity.class);
        context.startActivity(intent);
    }


}
