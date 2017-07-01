package com.apaces.demo.presenter.login;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.entity.LoginResult;
import com.apaces.demo.model.login.LoginModel;
import com.apaces.demo.model.login.LoginModelImpl;
import com.apaces.demo.view.activity.login.LoginView;

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

        loginView.onLoginFinished(loginResult);

    }

    @Override
    public void onError() {

        loginView.showError("网络出错，稍后再试");

    }

    @Override
    public void login(Map<String, Object> map) {
        loginView.showDialog("登陆中...");
        loginModel.login(map, this);

    }
}
