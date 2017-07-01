package com.apaces.demo.presenter.register;

import com.apaces.demo.base.BasePresenter;
import com.apaces.demo.view.activity.register.RegView;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public interface RegPresenter extends BasePresenter<RegView> {

    void register(Map<String, Object> map);
}
