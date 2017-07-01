package com.apaces.demo.presenter.login;

import com.apaces.demo.base.BasePresenter;
import com.apaces.demo.view.activity.login.LoginView;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public interface LoginPresenter extends BasePresenter<LoginView> {

    void login(Map<String, Object> map);
}
