package com.lanmei.ouqi.ui.mine.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.lanmei.ouqi.R;
import com.lanmei.ouqi.utils.CommonUtils;
import com.xson.common.app.BaseActivity;
import com.xson.common.widget.CenterTitleToolbar;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 安全中心
 */
public class SecurityCenterActivity extends BaseActivity {

    @InjectView(R.id.toolbar)
    CenterTitleToolbar toolbar;

    @Override
    public int getContentViewId() {
        return R.layout.activity_security_center;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowTitleEnabled(true);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle(R.string.security_center);
        actionbar.setHomeAsUpIndicator(R.mipmap.back);

    }

    @OnClick({R.id.center1_tv, R.id.center2_tv, R.id.center3_tv, R.id.center4_tv, R.id.center5_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.center1_tv:
                CommonUtils.developing(this);
                break;
            case R.id.center2_tv:
                CommonUtils.developing(this);
                break;
            case R.id.center3_tv:
                CommonUtils.developing(this);
                break;
            case R.id.center4_tv:
                CommonUtils.developing(this);
                break;
            case R.id.center5_tv:
                CommonUtils.developing(this);
                break;
        }
    }
}
