package com.apecs.im.base;

/**
 * Created by HJianFei on 2017/6/29.
 * <p>
 * 描述：MVP框架的简单封装 P处理层
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}
