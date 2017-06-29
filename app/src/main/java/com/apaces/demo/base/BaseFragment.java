package com.apaces.demo.base;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * Created by HJianFei on 2017/6/29.
 * <p>
 * 描述：
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
