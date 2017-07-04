package com.apecs.im.view.activity.register;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.apecs.im.R;
import com.apecs.im.base.BaseActivity;
import com.apecs.im.base.BaseResponse;
import com.apecs.im.entity.RegResult;
import com.apecs.im.presenter.register.RegPresenterImpl;
import com.apecs.im.utils.LogUtils;
import com.apecs.im.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<RegPresenterImpl> implements RegView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.reg_username)
    EditText regUsername;
    @BindView(R.id.reg_password)
    EditText regPassword;
    @BindView(R.id.btn_reg)
    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        setToolBar(toolbar, "用户注册");
    }

    @Override
    protected void createPresenter() {
        mPresenter = new RegPresenterImpl();

    }

    @Override
    public void onRegFinished(BaseResponse<RegResult> response) {

        LogUtils.d("onResponse", response.toString());
        if (response.getCode() == 200) {
            ToastUtil.showToast(this, "注册成功");
            this.finish();
        } else {
            ToastUtil.showToast(this, "注册失败，稍后再试");
        }

    }

    @OnClick(R.id.btn_reg)
    public void onViewClicked() {

        String username = regUsername.getText().toString();
        String password = regPassword.getText().toString();
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
        mPresenter.register(map);

    }
}
