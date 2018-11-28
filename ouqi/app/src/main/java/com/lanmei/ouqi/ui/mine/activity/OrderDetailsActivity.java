package com.lanmei.ouqi.ui.mine.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.lanmei.ouqi.R;
import com.lanmei.ouqi.adapter.MineRecommendAdapter;
import com.xson.common.app.BaseActivity;
import com.xson.common.widget.CenterTitleToolbar;

import butterknife.InjectView;

/**
 * 订单详情
 */
public class OrderDetailsActivity extends BaseActivity {

    @InjectView(R.id.toolbar)
    CenterTitleToolbar toolbar;
    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    @InjectView(R.id.type_tv)
    TextView typeTv;

    @Override
    public int getContentViewId() {
        return R.layout.activity_order_details;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowTitleEnabled(true);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle(R.string.order_details);
        actionbar.setHomeAsUpIndicator(R.mipmap.back);

        MineRecommendAdapter adapter = new MineRecommendAdapter(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);

        typeTv.setText("你可能还想要");
    }

}
