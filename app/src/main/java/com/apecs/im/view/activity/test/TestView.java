package com.apecs.im.view.activity.test;


import com.apecs.im.base.BaseView;

/**
 * Created by HJianFei on 2017/6/29.
 * <p>
 * 描述：
 */

public interface TestView extends BaseView {

    //View效果就是展示下载进度框
    void showUpdateDialog();

    void showProgressDialog();

    void DissProgressDialog();

    void ShowToast(String message);
}
