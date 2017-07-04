package com.apecs.im.presenter.login;


import com.apecs.im.base.BaseResponse;
import com.apecs.im.entity.LoginResult;
import com.apecs.im.model.login.LoginModel;
import com.apecs.im.model.login.LoginModelImpl;
import com.apecs.im.view.activity.login.LoginView;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public class LoginPresenterImpl implements LoginModel.onFinishListener, LoginPresenter {

    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenterImpl() {

        loginModel = new LoginModelImpl();
    }

    @Override
    public void attachView(LoginView view) {
        loginView = view;

    }

    @Override
    public void detachView() {
        loginView = null;

    }

    @Override
    public void onFinished(BaseResponse<LoginResult> loginResult) {

        if (loginView != null) {
            loginView.hideDialog();
            loginView.onLoginFinished(loginResult);
        }


    }

    @Override
    public void onError() {

        if (loginView != null) {
            loginView.hideDialog();
            loginView.showError("网络出错，稍后再试");
        }


    }

    @Override
    public void login(Map<String, Object> map) {

        if (loginView != null) {
            loginView.showDialog("登陆中");
            loginModel.login(map, this);
        }


    }
}
