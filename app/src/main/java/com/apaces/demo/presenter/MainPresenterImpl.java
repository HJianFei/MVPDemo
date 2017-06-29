package com.apaces.demo.presenter;

import com.apaces.demo.model.MainModel;
import com.apaces.demo.model.MainModelImpl;
import com.apaces.demo.view.activity.mian.MainView;

/**
 * Created by HJianFei on 2017/6/29.
 * <p>
 * 描述：
 */

public class MainPresenterImpl implements MainModel.onFinishListener, MainPresenter {

    private MainModel mainModel;
    private MainView mainView;

    public MainPresenterImpl() {
        mainModel = new MainModelImpl();
    }

    @Override
    public void attachView(MainView view) {
        mainView = view;

    }

    @Override
    public void detachView() {
        mainView = null;

    }

    @Override
    public void onFinished() {

        mainView.showDialog("输出");


    }

    @Override
    public void onError() {

    }

    @Override
    public void getData() {
        mainModel.getData(this);

    }
}
