package com.apaces.demo.model;

/**
 * Created by HJianFei on 2017/6/29.
 * <p>
 * 描述：
 */

public interface TestModel {

    interface onFinishListener {

        void onFinished();

        void onError();
    }

    void getData(onFinishListener listener);
}
