package com.apaces.demo.presenter.register;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.entity.RegResult;
import com.apaces.demo.model.register.RegModel;
import com.apaces.demo.model.register.RegModelImpl;
import com.apaces.demo.view.activity.register.RegView;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public class RegPresenterImpl implements RegModel.onFinishListener, RegPresenter {

    private RegView regView;
    private RegModel regModel;

    public RegPresenterImpl() {
        regModel = new RegModelImpl();
    }

    @Override
    public void attachView(RegView view) {
        regView = view;

    }

    @Override
    public void detachView() {
        regView = null;
    }

    @Override
    public void onFinished(BaseResponse<RegResult> regResult) {
        regView.onRegFinished(regResult);


    }

    @Override
    public void onError() {

    }

    @Override
    public void register(Map<String, Object> map) {

        regModel.register(map, this);

    }
}
