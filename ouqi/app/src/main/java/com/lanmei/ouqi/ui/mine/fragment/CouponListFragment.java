package com.lanmei.ouqi.ui.mine.fragment;

import android.os.Bundle;

import com.lanmei.ouqi.R;
import com.lanmei.ouqi.adapter.CouponListAdapter;
import com.lanmei.ouqi.bean.MineRecommendBean;
import com.xson.common.api.OuQiApi;
import com.xson.common.app.BaseFragment;
import com.xson.common.bean.NoPageListBean;
import com.xson.common.helper.SwipeRefreshController;
import com.xson.common.widget.SmartSwipeRefreshLayout;

import butterknife.InjectView;


/**
 * Created by xkai on 2017/4/27.
 * 优惠券
 */

public class CouponListFragment extends BaseFragment {

    @InjectView(R.id.pull_refresh_rv)
    SmartSwipeRefreshLayout smartSwipeRefreshLayout;
    CouponListAdapter mAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_single_listview_no;
    }


    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        initSwipeRefreshLayout();
    }
    private void initSwipeRefreshLayout() {
        smartSwipeRefreshLayout.initWithLinearLayout();
        Bundle bundle = getArguments();
        String cid = bundle.getString("cid");
        OuQiApi api = new OuQiApi("post/index");
        api.addParams("cid",cid);
        mAdapter = new CouponListAdapter(context);
        smartSwipeRefreshLayout.setAdapter(mAdapter);
        SwipeRefreshController<NoPageListBean<MineRecommendBean>> controller = new SwipeRefreshController<NoPageListBean<MineRecommendBean>>(getContext(), smartSwipeRefreshLayout, api, mAdapter) {
        };
        mAdapter.notifyDataSetChanged();
    }
}
