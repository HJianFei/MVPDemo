package com.apaces.demo.view.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.apaces.demo.R;
import com.apaces.demo.base.BaseActivity;
import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.entity.LoginResult;
import com.apaces.demo.presenter.login.LoginPresenterImpl;
import com.apaces.demo.utils.LogUtils;
import com.apaces.demo.utils.ToastUtil;
import com.apaces.demo.view.activity.main.MainActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenterImpl> implements LoginView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.user_name)
    EditText userName;
    @BindView(R.id.user_pwd)
    EditText userPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_reg)
    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {

        toolbar.setTitle("用户登录");
        setSupportActionBar(toolbar);

    }

    @Override
    public void showDialog(String msg) {
        super.showDialog(msg);
        ToastUtil.showToast(this, msg);
    }

    @Override
    protected void createPresenter() {
        mPresenter = new LoginPresenterImpl();

    }

    @Override
    public void onLoginFinished(BaseResponse<LoginResult> loginResult) {
        LogUtils.d("onResponse", loginResult.toString());
        if (loginResult.getCode() == 200) {
            ToastUtil.showToast(this, "登录成功");
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        } else {
            ToastUtil.showToast(this, "登录失败，稍后再试");
        }

    }

    @OnClick({R.id.btn_login, R.id.btn_reg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login://登录
                String username = userName.getText().toString();
                String password = userPwd.getText().toString();
                if (TextUtils.isEmpty(username)) {
                    ToastUtil.showToast(this, "用户名不能为空");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    ToastUtil.showToast(this, "密码不能为空");
                    return;
                }
                Map<String, Object> map = new HashMap<>();
                map.put("username", username);
                map.put("password", password);
                mPresenter.login(map);
                break;
            case R.id.btn_reg://注册

                break;
        }
    }
}
