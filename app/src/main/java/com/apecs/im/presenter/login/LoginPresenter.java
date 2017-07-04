package com.apecs.im.presenter.login;


import com.apecs.im.base.BasePresenter;
import com.apecs.im.view.activity.login.LoginView;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public interface LoginPresenter extends BasePresenter<LoginView> {

    void login(Map<String, Object> map);
}
