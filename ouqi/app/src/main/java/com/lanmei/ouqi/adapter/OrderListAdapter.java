package com.lanmei.ouqi.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lanmei.ouqi.R;
import com.lanmei.ouqi.ui.mine.fragment.OrderListFragment;


/**
 * 我的项目订单
 */
public class OrderListAdapter extends FragmentPagerAdapter {

    private Context context;

    public OrderListAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        OrderListFragment fragment = new OrderListFragment();
        Bundle bundle = new Bundle();
        switch (position) {
            case 0:
                bundle.putString("status","0");//0全部1待付款2已付款3未消费4已完成
                break;
            case 1:
                bundle.putString("status","1");
                break;
            case 2:
                bundle.putString("status","3");
                break;
            case 3:
                bundle.putString("status","4");
                break;
            case 4:
                bundle.putString("status","4");
                break;
            case 5:
                bundle.putString("status","4");
                break;
            case 6:
                bundle.putString("status","4");
                break;

        }
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.all);
            case 1:
                return context.getString(R.string.wait_pay);
            case 2:
                return context.getString(R.string.wait_receiving);
            case 3:
                return context.getString(R.string.doned);
            case 4:
                return context.getString(R.string.wait_deliver);
            case 5:
                return context.getString(R.string.wait_evaluate);
            case 6:
                return context.getString(R.string.wait_share);
        }
        return "";
    }
}
