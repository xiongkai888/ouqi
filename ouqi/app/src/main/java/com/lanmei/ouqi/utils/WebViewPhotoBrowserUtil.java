package com.lanmei.ouqi.utils;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lanmei.ouqi.webviewpage.MJavascriptInterface;
import com.lanmei.ouqi.webviewpage.MyWebViewClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xkai on 2017/6/2.
 * webview 图片预览工具
 */

public class WebViewPhotoBrowserUtil {

    /**
     *
     * @param webView
     * @param content  内容
     */
    public static void photoBrowser(Context context,WebView webView,String content){
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        String[] imageUrls = com.lanmei.ouqi.webviewpage.StringUtils.returnImageUrlsFromHtml(content);
        loadHtml(content,webView);
        if (imageUrls != null){
            webView.addJavascriptInterface(new MJavascriptInterface(context,imageUrls), "imagelistener");
            webView.setWebViewClient(new MyWebViewClient());
        }
    }

    public static void loadHtml(String content,WebView webView) {
        String html = "<div style=\"width:100%\">" + content + "</div>";
        html = delHTMLTag(html);
        webView.loadDataWithBaseURL("", html, "text/html", "UTF-8", "");
    }


    public static String delHTMLTag(String htmlStr) {

        htmlStr = "<div style=\\\"word-wrap:break-word;word-break:break-all;\\\">"+htmlStr+"</div><script>var pic = document.getElementsByTagName(\\\"img\\\");for (var i = 0; i < pic.length; i++) {pic[i].style.maxWidth = \\\"100%%\\\";pic[i].style.maxHeight = \\\"100%%\\\";};</script>";

        String img = "<img[^>]+>";
        Pattern imgp = Pattern.compile(img);
        Matcher html = imgp.matcher(htmlStr);
        while (html.find()) {
            Matcher m = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(
                    html.group());
            while (m.find()) {
                String ig = "<img style=\"box-sizing: border-box; width: 100%; height: auto !important;\" src=\""
                        + m.group(1) + "\" />";
                htmlStr = htmlStr.replace(html.group(), ig);
            }
        }
        return htmlStr; // 返回文本字符串
    }

    public static void loadUrl(String url,WebView webview){
        WebSettings webSettings = webview.getSettings();
        //设置WebView属性，能够执行Javascript脚本
        webSettings.setJavaScriptEnabled(true);
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        //设置支持缩放
        webSettings.setBuiltInZoomControls(true);
        //加载需要显示的网页
        webview.loadUrl(url);
        //设置Web视图
        webview.setWebViewClient(new WebViewClient());
    }

}
