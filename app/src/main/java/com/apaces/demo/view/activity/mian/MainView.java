package com.apaces.demo.view.activity.mian;

import com.apaces.demo.base.BaseView;

/**
 * Created by HJianFei on 2017/6/29.
 * <p>
 * 描述：
 */

public interface MainView extends BaseView {

    //View效果就是展示下载进度框
    void showUpdateDialog();

    void showProgressDialog();

    void DissProgressDialog();

    void ShowToast(String message);
}
