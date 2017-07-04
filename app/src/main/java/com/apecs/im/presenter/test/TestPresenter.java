package com.apecs.im.presenter.test;


import com.apecs.im.base.BasePresenter;
import com.apecs.im.view.activity.test.TestView;

/**
 * Created by HJianFei on 2017/6/29.
 * <p>
 * 描述：
 */

public interface TestPresenter extends BasePresenter<TestView> {

    void getData();
}
