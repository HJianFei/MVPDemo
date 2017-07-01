package com.apaces.demo.view.activity.login;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.base.BaseView;
import com.apaces.demo.entity.LoginResult;

/**
 * Created by HJF on 2017/7/1.
 * 描述：登录操作的事件接口
 */

public interface LoginView extends BaseView {

    void onLoginFinished(BaseResponse<LoginResult> loginResult);

}
