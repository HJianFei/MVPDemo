package com.apaces.demo.presenter;

import com.apaces.demo.model.TestModel;
import com.apaces.demo.model.TestModelImpl;
import com.apaces.demo.view.activity.test.TestView;

/**
 * Created by HJianFei on 2017/6/29.
 * <p>
 * 描述：
 */

public class TestPresenterImpl implements TestModel.onFinishListener, TestPresenter {

    private TestModel testModel;
    private TestView testView;

    public TestPresenterImpl() {

        testModel = new TestModelImpl();
    }

    @Override
    public void attachView(TestView view) {
        testView = view;

    }

    @Override
    public void detachView() {
        testView = null;

    }

    @Override
    public void onFinished() {

        testView.showDialog("输出");


    }

    @Override
    public void onError() {

    }

    @Override
    public void getData() {
        testModel.getData(this);

    }
}
