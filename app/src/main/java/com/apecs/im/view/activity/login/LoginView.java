package com.apecs.im.view.activity.login;


import com.apecs.im.base.BaseResponse;
import com.apecs.im.base.BaseView;
import com.apecs.im.entity.LoginResult;

/**
 * Created by HJF on 2017/7/1.
 * 描述：登录操作的事件接口
 */

public interface LoginView extends BaseView {

    void onLoginFinished(BaseResponse<LoginResult> loginResult);

}
