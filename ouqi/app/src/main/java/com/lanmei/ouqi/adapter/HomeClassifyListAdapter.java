package com.lanmei.ouqi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lanmei.ouqi.R;
import com.lanmei.ouqi.bean.HomeClassifyListBean;
import com.lanmei.ouqi.ui.home.activity.GoodsDetailsActivity;
import com.xson.common.adapter.SwipeRefreshAdapter;
import com.xson.common.utils.IntentUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * 分类列表
 */
public class HomeClassifyListAdapter extends SwipeRefreshAdapter<HomeClassifyListBean> {

    public HomeClassifyListAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder2(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_classify_list, parent, false));
    }

    @Override
    public void onBindViewHolder2(RecyclerView.ViewHolder holder, int position) {
//        final HomeClassifyListBean bean = getItem(position);
//        if (bean == null) {
//            return;
//        }
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.setParameter(null);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtil.startActivity(context, GoodsDetailsActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("bean",bean);
//                IntentUtil.startActivity(context, HomeClassifyListActivity.class,bundle);
            }
        });
    }

    @Override
    public int getCount() {
        return 13;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.goods_details_iv)
        ImageView goodsDetailsIv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }

        public void setParameter(HomeClassifyListBean bean) {
//            goodsDetailsIv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
        }
    }

}
