package com.lanmei.ouqi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lanmei.ouqi.R;
import com.lanmei.ouqi.bean.MineRecommendBean;
import com.lanmei.ouqi.utils.FormatTime;
import com.xson.common.adapter.SwipeRefreshAdapter;

import butterknife.ButterKnife;

/**
 * 订单列表
 */
public class OrderListSubAdapter extends SwipeRefreshAdapter<MineRecommendBean> {


    private FormatTime time;

    public OrderListSubAdapter(Context context) {
        super(context);
        time = new FormatTime(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder2(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_order_list_sub, parent, false));
    }

    @Override
    public void onBindViewHolder2(RecyclerView.ViewHolder holder, int position) {
        final MineRecommendBean bean = getItem(position);
        if (bean == null) {
            return;
        }
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.setParameter(bean, position);
    }

    @Override
    public int getCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }

        public void setParameter(final MineRecommendBean bean, final int position) {

        }
    }

}
