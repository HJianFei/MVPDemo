package com.apaces.demo.view.activity.test;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.apaces.demo.R;
import com.apaces.demo.base.BaseActivity;
import com.apaces.demo.presenter.TestPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends BaseActivity<TestPresenterImpl> implements TestView {

    @BindView(R.id.hello)
    TextView hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

        //login
        mPresenter.getData();
    }

    @Override
    protected void createPresenter() {

        mPresenter = new TestPresenterImpl();
    }

    @Override
    public void showDialog(String msg) {
        super.showDialog(msg);
        Log.d("onResponse", msg);
    }

    @Override
    public void showUpdateDialog() {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void DissProgressDialog() {

    }

    @Override
    public void ShowToast(String message) {

    }
}
