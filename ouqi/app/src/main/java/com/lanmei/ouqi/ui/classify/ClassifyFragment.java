package com.lanmei.ouqi.ui.classify;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.lanmei.ouqi.R;
import com.lanmei.ouqi.adapter.ClassifyItemListAdapter;
import com.lanmei.ouqi.adapter.ClassifyVerticalTabAdapter;
import com.xson.common.app.BaseFragment;
import com.xson.common.widget.CenterTitleToolbar;
import com.xson.common.widget.SmartSwipeRefreshLayout;

import butterknife.InjectView;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * Created by xkai on 2018/7/13.
 * 分类
 */

public class ClassifyFragment extends BaseFragment{

    @InjectView(R.id.toolbar)
    CenterTitleToolbar toolbar;
    @InjectView(R.id.tablayout)
    VerticalTabLayout tablayout;//垂直tabLayout
    @InjectView(R.id.pull_refresh_rv)
    SmartSwipeRefreshLayout smartSwipeRefreshLayout;

    ClassifyItemListAdapter itemListAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_classify;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        toolbar.setTitle(R.string.classify);


        ClassifyVerticalTabAdapter adapter = new ClassifyVerticalTabAdapter(context);
        tablayout.setTabAdapter(adapter);
        tablayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });

        itemListAdapter = new ClassifyItemListAdapter(context);
        smartSwipeRefreshLayout.setLayoutManager(new GridLayoutManager(context, 2));
        smartSwipeRefreshLayout.setAdapter(itemListAdapter);
        smartSwipeRefreshLayout.setMode(SmartSwipeRefreshLayout.Mode.NO_PAGE);
        itemListAdapter.notifyDataSetChanged();

    }
}
