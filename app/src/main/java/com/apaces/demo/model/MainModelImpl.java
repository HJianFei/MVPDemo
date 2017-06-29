package com.apaces.demo.model;

/**
 * Created by HJianFei on 2017/6/29.
 * <p>
 * 描述：
 */

public class MainModelImpl implements MainModel {

    @Override
    public void getData(final onFinishListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    listener.onFinished();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
