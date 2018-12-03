package com.lanmei.ouqi.ui.home.fragment;

import android.os.Bundle;
import android.webkit.WebView;

import com.lanmei.ouqi.R;
import com.lanmei.ouqi.utils.WebViewPhotoBrowserUtil;
import com.xson.common.app.BaseFragment;
import com.xson.common.utils.StringUtils;

import butterknife.InjectView;


/**
 * 图文详情webview的Fragment
 */
public class GoodsInfoWebFragment extends BaseFragment {

    @InjectView(R.id.detail_webView)
    WebView detailWebView;

    
    @Override
    public int getContentViewId() {
        return R.layout.fragment_item_info_web;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle == null){
            return;
        }
        String content = bundle.getString("content");
        if (StringUtils.isEmpty(content)){
            return;
        }
        WebViewPhotoBrowserUtil.photoBrowser(context, detailWebView, content);
    }

}
