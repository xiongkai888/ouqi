package com.lanmei.ouqi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lanmei.ouqi.R;
import com.lanmei.ouqi.bean.MineRecommendBean;
import com.xson.common.adapter.SwipeRefreshAdapter;

import butterknife.ButterKnife;


/**
 * 红包
 */
public class RedPacketListAdapter extends SwipeRefreshAdapter<MineRecommendBean> {

    public RedPacketListAdapter(Context context) {
        super(context);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder2(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_red_packet_list, parent, false));
    }

    @Override
    public void onBindViewHolder2(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
