package com.apecs.im.model.login;


import com.apecs.im.base.BaseResponse;
import com.apecs.im.entity.LoginResult;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：登录操作接口
 */

public interface LoginModel {


    interface onFinishListener {

        void onFinished(BaseResponse<LoginResult> loginResult);

        void onError();
    }

    //登录方法
    void login(Map<String, Object> map, onFinishListener listener);
}
