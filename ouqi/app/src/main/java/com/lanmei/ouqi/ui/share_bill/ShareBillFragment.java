package com.lanmei.ouqi.ui.share_bill;

import android.os.Bundle;

import com.lanmei.ouqi.R;
import com.lanmei.ouqi.adapter.ShareBillAdapter;
import com.lanmei.ouqi.bean.MineRecommendBean;
import com.xson.common.api.OuQiApi;
import com.xson.common.app.BaseFragment;
import com.xson.common.bean.NoPageListBean;
import com.xson.common.helper.SwipeRefreshController;
import com.xson.common.widget.CenterTitleToolbar;
import com.xson.common.widget.SmartSwipeRefreshLayout;

import butterknife.InjectView;

/**
 * Created by xkai on 2018/11/26.
 * 拼团
 */

public class ShareBillFragment extends BaseFragment{

    @InjectView(R.id.toolbar)
    CenterTitleToolbar toolbar;
    @InjectView(R.id.pull_refresh_rv)
    SmartSwipeRefreshLayout smartSwipeRefreshLayout;
    SwipeRefreshController<NoPageListBean<MineRecommendBean>> controller;

    ShareBillAdapter adapter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_single_listview_no;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        toolbar.setTitle("我的拼团");

        smartSwipeRefreshLayout.initWithLinearLayout();
        OuQiApi api = new OuQiApi("app/good_list");
        adapter = new ShareBillAdapter(context);
        smartSwipeRefreshLayout.setAdapter(adapter);
        controller = new SwipeRefreshController<NoPageListBean<MineRecommendBean>>(context, smartSwipeRefreshLayout, api, adapter) {
        };
        smartSwipeRefreshLayout.setMode(SmartSwipeRefreshLayout.Mode.NO_PAGE);
//        View view = LayoutInflater.from(context).inflate(R.layout.empty_shop_car, smartSwipeRefreshLayout, true);
//        smartSwipeRefreshLayout.setEmptyLayout(view);
        adapter.notifyDataSetChanged();
    }
}
