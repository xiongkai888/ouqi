package com.lanmei.ouqi.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lanmei.ouqi.R;
import com.lanmei.ouqi.bean.MineRecommendBean;
import com.xson.common.adapter.SwipeRefreshAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * 首页
 */
public class HomeAdapter extends SwipeRefreshAdapter<MineRecommendBean> {

    public HomeAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder2(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home, parent, false));
    }


    @Override
    public void onBindViewHolder2(RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.setParameter(null);

    }

    @Override
    public int getCount() {
        return 6;
    }

    //
    public class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.recyclerView1)
        RecyclerView recyclerView1;
        @InjectView(R.id.recyclerView2)
        RecyclerView recyclerView2;

        ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }

        public void setParameter(MineRecommendBean bean) {
            HomeSub1Adapter sub1Adapter = new HomeSub1Adapter(context);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView1.setLayoutManager(layoutManager);
            recyclerView1.setNestedScrollingEnabled(false);
            recyclerView1.setAdapter(sub1Adapter);

            HomeSub2Adapter sub2Adapter = new HomeSub2Adapter(context);
            recyclerView2.setLayoutManager(new GridLayoutManager(context,2));
            recyclerView2.setNestedScrollingEnabled(false);
            recyclerView2.setAdapter(sub2Adapter);

        }
    }

}
