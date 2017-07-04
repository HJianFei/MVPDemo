package com.apecs.im.view.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.apecs.im.R;
import com.apecs.im.base.BaseActivity;
import com.apecs.im.base.BaseResponse;
import com.apecs.im.entity.LoginResult;
import com.apecs.im.presenter.login.LoginPresenterImpl;
import com.apecs.im.utils.LogUtils;
import com.apecs.im.utils.ToastUtil;
import com.apecs.im.view.activity.main.MainActivity;
import com.apecs.im.view.activity.register.RegisterActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

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
    private SweetAlertDialog dialog;

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
        hideDialog();
        dialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        dialog.setTitleText(msg);
        dialog.show();

    }

    @Override
    public void hideDialog() {
        super.hideDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override
    public void showError(String msg) {
        super.showError(msg);

        hideDialog();
        dialog = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
        dialog.setTitleText(msg);
        dialog.show();
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

                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);

                break;
        }
    }
}
