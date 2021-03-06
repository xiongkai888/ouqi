package com.lanmei.ouqi.ui.mine.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.lanmei.ouqi.R;
import com.lanmei.ouqi.utils.CommonUtils;
import com.xson.common.app.BaseActivity;
import com.xson.common.utils.IntentUtil;
import com.xson.common.widget.CenterTitleToolbar;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 设置
 */
public class SettingActivity extends BaseActivity {

    @InjectView(R.id.toolbar)
    CenterTitleToolbar toolbar;

    @Override
    public int getContentViewId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowTitleEnabled(true);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle(R.string.setting);
        actionbar.setHomeAsUpIndicator(R.mipmap.back);
    }

    @OnClick({R.id.ll_member, R.id.ll_safety, R.id.ll_about, R.id.bt_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_member:
                IntentUtil.startActivity(this, MineMemberActivity.class);
                break;
            case R.id.ll_safety:
                IntentUtil.startActivity(this, SecurityCenterActivity.class);
                break;
            case R.id.ll_about:
                CommonUtils.developing(this);
                break;
            case R.id.bt_logout:
                CommonUtils.developing(this);
                break;
        }
    }
}
