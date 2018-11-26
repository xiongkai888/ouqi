package com.lanmei.ouqi.ui.mine;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lanmei.ouqi.R;
import com.lanmei.ouqi.adapter.MineRecommendAdapter;
import com.xson.common.app.BaseFragment;
import com.xson.common.widget.CenterTitleToolbar;

import butterknife.InjectView;

/**
 * Created by xkai on 2018/7/13.
 * 首页
 */

public class MineFragment extends BaseFragment{

    @InjectView(R.id.toolbar)
    CenterTitleToolbar toolbar;
    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        toolbar.setTitle(R.string.mine);

        MineRecommendAdapter adapter = new MineRecommendAdapter(context);
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);
    }
}
