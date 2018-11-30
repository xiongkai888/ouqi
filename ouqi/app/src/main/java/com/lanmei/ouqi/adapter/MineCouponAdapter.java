package com.lanmei.ouqi.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lanmei.ouqi.R;
import com.lanmei.ouqi.ui.mine.fragment.CouponListFragment;

/**
 *
 */
public class MineCouponAdapter extends FragmentPagerAdapter {


    private Context context;

    public MineCouponAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        CouponListFragment fragment = new CouponListFragment();
        bundle.putString("cid","cid");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return context.getString(R.string.to_be_used);
            case 1:
                return context.getString(R.string.have_been_used);
            case 2:
                return context.getString(R.string.have_expired);
        }

        return null;
    }

}
