package com.lanmei.ouqi.ui.mine;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lanmei.ouqi.MainActivity;
import com.lanmei.ouqi.R;
import com.lanmei.ouqi.adapter.MineRecommendAdapter;
import com.lanmei.ouqi.ui.mine.activity.MineAccountActivity;
import com.lanmei.ouqi.ui.mine.activity.MineCouponActivity;
import com.lanmei.ouqi.ui.mine.activity.MineRedPacketActivity;
import com.lanmei.ouqi.ui.mine.activity.OrderListActivity;
import com.lanmei.ouqi.ui.mine.activity.SettingActivity;
import com.lanmei.ouqi.utils.CommonUtils;
import com.xson.common.app.BaseFragment;
import com.xson.common.utils.IntentUtil;
import com.xson.common.widget.CenterTitleToolbar;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by xkai on 2018/7/13.
 * 首页
 */

public class MineFragment extends BaseFragment {

    @InjectView(R.id.toolbar)
    CenterTitleToolbar toolbar;
    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    @InjectView(R.id.type_tv)
    TextView typeTv;

    @InjectView(R.id.name_tv)
    TextView nameTv;
    @InjectView(R.id.account_tv)
    TextView accountTv;
    @InjectView(R.id.red_packet_tv)
    TextView redPacketTv;
    @InjectView(R.id.discount_coupon_tv)
    TextView discountCouponTv;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        toolbar.setTitle(R.string.mine);

        MineRecommendAdapter adapter = new MineRecommendAdapter(context);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);

        typeTv.setText("为您推荐");

        CommonUtils.setSpannableString("0.00","0.00",accountTv.getText().toString(),accountTv,"#000000");
        CommonUtils.setSpannableString("0","0",redPacketTv.getText().toString(),redPacketTv,"#000000");
        CommonUtils.setSpannableString("0","0",discountCouponTv.getText().toString(),discountCouponTv,"#000000");

    }

    @OnClick({R.id.account_tv, R.id.red_packet_tv, R.id.discount_coupon_tv, R.id.play_yards_tv, R.id.order_all_tv, R.id.mine_1_tv, R.id.mine_2_tv, R.id.mine_3_tv, R.id.mine_4_tv, R.id.mine_5_tv, R.id.mine_6_tv, R.id.mine_7_tv, R.id.mine_8_tv, R.id.mine_9_tv, R.id.mine_10_tv, R.id.mine_11_tv, R.id.mine_12_tv, R.id.mine_13_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.account_tv://余额提现(我的账户)
                IntentUtil.startActivity(context, MineAccountActivity.class);
                break;
            case R.id.red_packet_tv://红包
                IntentUtil.startActivity(context, MineRedPacketActivity.class);
                break;
            case R.id.discount_coupon_tv://优惠券
                IntentUtil.startActivity(context, MineCouponActivity.class);
                break;
            case R.id.play_yards_tv://出场码
                CommonUtils.developing(context);
                break;
            case R.id.order_all_tv://查看全部
                IntentUtil.startActivity(context, 0, OrderListActivity.class);
                break;
            case R.id.mine_1_tv://待付款
                IntentUtil.startActivity(context, 1, OrderListActivity.class);
                break;
            case R.id.mine_2_tv://待发货
                IntentUtil.startActivity(context, 4, OrderListActivity.class);
                break;
            case R.id.mine_3_tv://待收货
                IntentUtil.startActivity(context, 2, OrderListActivity.class);
                break;
            case R.id.mine_4_tv://待评价
                IntentUtil.startActivity(context, 5, OrderListActivity.class);
                break;
            case R.id.mine_5_tv://待分享
                IntentUtil.startActivity(context, 6, OrderListActivity.class);
                break;
            case R.id.mine_6_tv://我的拼团
                MainActivity.showShareBill(context);
                break;
            case R.id.mine_7_tv://收藏商品
                CommonUtils.developing(context);
                break;
            case R.id.mine_8_tv://历史浏览
                CommonUtils.developing(context);
                break;
            case R.id.mine_9_tv://退款售后
                CommonUtils.developing(context);
                break;
            case R.id.mine_10_tv://果园种植
                CommonUtils.developing(context);
                break;
            case R.id.mine_11_tv://收藏商品
                CommonUtils.developing(context);
                break;
            case R.id.mine_12_tv://个人设置
                IntentUtil.startActivity(context, SettingActivity.class);
                break;
            case R.id.mine_13_tv://收货地址
                CommonUtils.developing(context);
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
