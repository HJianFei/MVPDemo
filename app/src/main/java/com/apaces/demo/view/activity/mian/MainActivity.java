package com.apaces.demo.view.activity.mian;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.apaces.demo.R;
import com.apaces.demo.base.BaseActivity;
import com.apaces.demo.presenter.MainPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenterImpl> implements MainView {

    @BindView(R.id.hello)
    TextView hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPresenter.getData();
    }

    @Override
    protected void createPresenter() {

        mPresenter = new MainPresenterImpl();
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
