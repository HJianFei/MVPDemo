package com.apaces.demo.base;

/**
 * Created by HJianFei on 2017/6/29.
 * <p>
 * 描述：封装视图基类
 * 一般的Activity中要用到View操作无非是显示加载框、隐藏加载框、显示出错信息、显示当数据为空的时候的view之类的
 */

public interface BaseView {

    //显示对话框
    void showDialog(String msg);

    //隐藏对话框
    void hideDialog();

    //显示出错信息
    void showError(String msg);

    //显示数据为空
    void showEmpty();

}
