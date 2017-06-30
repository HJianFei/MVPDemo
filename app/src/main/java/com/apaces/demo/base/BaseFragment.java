package com.apaces.demo.base;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * Created by HJianFei on 2017/6/29.
 * <p>
 * 描述：基类Fragment的封装
 * 在BaseFragment中进行P和V的初始化绑定
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {

    protected BaseActivity mActivity;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (BaseActivity) activity;
    }

    @Override
    public void showDialog(String msg) {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showEmpty() {

    }
}
