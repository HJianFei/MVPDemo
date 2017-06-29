package com.apaces.demo.presenter;

import com.apaces.demo.base.BasePresenter;
import com.apaces.demo.view.activity.mian.MainView;

/**
 * Created by HJianFei on 2017/6/29.
 * <p>
 * 描述：
 */

public interface MainPresenter extends BasePresenter<MainView> {

    void getData();
}
