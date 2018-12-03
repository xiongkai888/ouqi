package com.lanmei.ouqi.ui.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.lanmei.ouqi.R;
import com.lanmei.ouqi.adapter.HomeAdapter;
import com.lanmei.ouqi.adapter.HomeClassifyAdapter;
import com.lanmei.ouqi.adapter.HomeMsAdapter;
import com.lanmei.ouqi.bean.HomeClassifyBean;
import com.lanmei.ouqi.utils.CommonUtils;
import com.paradoxie.autoscrolltextview.VerticalTextview;
import com.xson.common.app.BaseFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by xkai on 2018/7/13.
 * 首页
 */

public class HomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    @InjectView(R.id.tvBulletin)
    VerticalTextview tvBulletin;// 滚动广告（公告）
    @InjectView(R.id.recyclerView_ms)
    RecyclerView recyclerView_ms;//秒杀
    @InjectView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;//下拉刷新
    @InjectView(R.id.recyclerView_classify)
    RecyclerView recyclerViewClassify;//分类
    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;//首页列表
    @InjectView(R.id.banner)
    ConvenientBanner banner;//轮播图

    @Override
    public int getContentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.color83AE05);

        initVerticalTextView();
        initRecyclerView_ms();//秒杀
        initHome();
        initHomeClassify();

        CommonUtils.setBanner(banner, CommonUtils.getList(), true);
    }

    private void initHomeClassify() {
        HomeClassifyAdapter adapter = new HomeClassifyAdapter(context);
        adapter.setData(getList());
        recyclerViewClassify.setLayoutManager(new GridLayoutManager(context, 5));
        recyclerViewClassify.setNestedScrollingEnabled(false);
        recyclerViewClassify.setAdapter(adapter);
    }


    private List<HomeClassifyBean> getList() {
        List<HomeClassifyBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            HomeClassifyBean bean = new HomeClassifyBean();
            switch (i){
                case 0:
                    bean.setName("精品区");
                    bean.setPicId(R.mipmap.home_classify_1);
                    break;
                case 1:
                    bean.setName("特美推荐");
                    bean.setPicId(R.mipmap.home_classify_2);
                    break;
                case 2:
                    bean.setName("品牌汇");
                    bean.setPicId(R.mipmap.home_classify_3);
                    break;
                case 3:
                    bean.setName("每日上新");
                    bean.setPicId(R.mipmap.home_classify_4);
                    break;
                case 4:
                    bean.setName("母婴");
                    bean.setPicId(R.mipmap.home_classify_5);
                    break;
                case 5:
                    bean.setName("百货");
                    bean.setPicId(R.mipmap.home_classify_6);
                    break;
                case 6:
                    bean.setName("食品");
                    bean.setPicId(R.mipmap.home_classify_7);
                    break;
                case 7:
                    bean.setName("粮油");
                    bean.setPicId(R.mipmap.home_classify_8);
                    break;
                case 8:
                    bean.setName("美妆");
                    bean.setPicId(R.mipmap.home_classify_9);
                    break;
                case 9:
                    bean.setName("更多");
                    bean.setPicId(R.mipmap.home_classify_10);
                    break;
            }
            list.add(bean);
        }
        return list;
    }


    private void initHome() {
        HomeAdapter adapter = new HomeAdapter(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);
    }

    //秒杀
    private void initRecyclerView_ms() {
        HomeMsAdapter adapter = new HomeMsAdapter(context);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_ms.setLayoutManager(layoutManager);
        recyclerView_ms.setNestedScrollingEnabled(false);
        recyclerView_ms.setAdapter(adapter);
    }

    private void initVerticalTextView() {
        ArrayList<String> bulletinList = new ArrayList<>();
        Collections.addAll(bulletinList, "我们不一样", "我们真不一样");
        tvBulletin.setTextList(bulletinList);
        tvBulletin.setText(12, 0, R.color.black);//设置属性,具体跟踪源码
        tvBulletin.setTextStillTime(3000);//设置停留时长间隔
        tvBulletin.setAnimTime(500);//设置进入和退出的时间间隔
        //对单条文字的点击监听
//                viewHolder.tvBulletin.setOnItemClickListener(new VerticalTextview.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(int position) {
//                        UIHelper.ToastMessage(context, bulletinList.get(position));
//                    }
//                });
        tvBulletin.startAutoScroll();
    }

    @Override
    public void onRefresh() {
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 500);
    }
}
