package com.lanmei.ouqi.ui.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

import com.lanmei.ouqi.R;
import com.lanmei.ouqi.adapter.HomeClassifyListAdapter;
import com.lanmei.ouqi.bean.HomeClassifyBean;
import com.lanmei.ouqi.bean.HomeClassifyListBean;
import com.xson.common.api.OuQiApi;
import com.xson.common.app.BaseActivity;
import com.xson.common.bean.NoPageListBean;
import com.xson.common.helper.SwipeRefreshController;
import com.xson.common.widget.CenterTitleToolbar;
import com.xson.common.widget.SmartSwipeRefreshLayout;

import butterknife.InjectView;


/**
 * 分类列表
 */
public class HomeClassifyListActivity extends BaseActivity {

    @InjectView(R.id.toolbar)
    CenterTitleToolbar toolbar;
    @InjectView(R.id.pull_refresh_rv)
    SmartSwipeRefreshLayout smartSwipeRefreshLayout;
    HomeClassifyListAdapter adapter;
    HomeClassifyBean bean;

    @Override
    public int getContentViewId() {
        return R.layout.activity_home_classify_list;
    }

    @Override
    public void initIntent(Intent intent) {
        super.initIntent(intent);
        Bundle bundle = intent.getBundleExtra("bundle");
        if (bundle == null){
            return;
        }
        bean = (HomeClassifyBean)bundle.getSerializable("bean");
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowTitleEnabled(true);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.mipmap.back);

        if (bean == null){
            return;
        }
        actionbar.setTitle(bean.getName());

        smartSwipeRefreshLayout.initWithLinearLayout();
        OuQiApi api = new OuQiApi("post/index");
        adapter = new HomeClassifyListAdapter(this);
        smartSwipeRefreshLayout.setAdapter(adapter);
        SwipeRefreshController<NoPageListBean<HomeClassifyListBean>> controller = new SwipeRefreshController<NoPageListBean<HomeClassifyListBean>>(getContext(), smartSwipeRefreshLayout, api, adapter) {
        };
        adapter.notifyDataSetChanged();

    }

}
