package com.apaces.demo.view.activity.user_detail;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.apaces.demo.R;
import com.apaces.demo.base.BaseActivity;
import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.entity.ResultCode;
import com.apaces.demo.entity.UserDetailResult;
import com.apaces.demo.presenter.user_detail.UserDetailPresenterImpl;
import com.apaces.demo.utils.ImageUtil;
import com.apaces.demo.utils.LogUtils;
import com.apaces.demo.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserDetailActivity extends BaseActivity<UserDetailPresenterImpl> implements UserDetailView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.user_avatar)
    ImageView userAvatar;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.user_nickname)
    TextView userNickname;
    @BindView(R.id.user_phone)
    TextView userPhone;
    @BindView(R.id.user_email)
    TextView userEmail;
    @BindView(R.id.btn_del)
    Button btnDel;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        username = getIntent().getStringExtra("username");
        ButterKnife.bind(this);
        userName.setText(username);
        setToolBar(toolbar, "好友详情");
        initData();
    }

    private void initData() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        mPresenter.getUserDetail(map);
    }

    @Override
    protected void createPresenter() {
        mPresenter = new UserDetailPresenterImpl();

    }

    @Override
    public void onFinished(BaseResponse<UserDetailResult> response) {
        LogUtils.d("onResponse", response.toString());
        if (response.getCode() == 200) {
            userNickname.setText(response.getData().getNickname());
            userPhone.setText(response.getData().getPhone());
            userEmail.setText(response.getData().getEmail());
            Bitmap bitmap = ImageUtil.getBitmapFromBase64String(response.getData().getAvatar());
            if (bitmap != null) {
                userAvatar.setImageBitmap(bitmap);
            } else {
                userAvatar.setImageResource(R.drawable.default_avatar);
            }

        }

    }

    @Override
    public void onDelFinished(ResultCode resultCode) {
        LogUtils.d("onResponse", resultCode.toString());
        if (resultCode.code == 200) {
            ToastUtil.showToast(this, "删除成功");
            this.finish();
        } else {
            ToastUtil.showToast(this, "删除失败，稍后再试");
        }

    }

    @OnClick(R.id.btn_del)
    public void onViewClicked() {

        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        mPresenter.delFriend(map);

    }
}
