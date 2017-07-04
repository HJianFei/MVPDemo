package com.apecs.im.view.activity.user_detail;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.apecs.im.R;
import com.apecs.im.base.BaseActivity;
import com.apecs.im.base.BaseResponse;
import com.apecs.im.entity.ResultCode;
import com.apecs.im.entity.UserDetailResult;
import com.apecs.im.presenter.user_detail.UserDetailPresenterImpl;
import com.apecs.im.utils.ImageUtil;
import com.apecs.im.utils.LogUtils;
import com.apecs.im.utils.ToastUtil;

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
    private String enter_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        username = getIntent().getStringExtra("username");
        enter_type = getIntent().getStringExtra("type");
        ButterKnife.bind(this);
        userName.setText(username);
        setToolBar(toolbar, "好友详情");
        initData();
    }

    private void initData() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        mPresenter.getUserDetail(map);

        mPresenter.isFriend(map);
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
    public void onIsFriendFinished(ResultCode resultCode) {
        if (resultCode.code == 200) {

            if (enter_type.equals("user_friend")) {
                btnDel.setText("发送消息");
            } else {
                btnDel.setText("删除好友");
            }
        } else {
            btnDel.setText("添加好友");
        }

    }

    @Override
    public void onAddFriendFinished(ResultCode resultCode) {

        LogUtils.d("onResponse", resultCode.toString());
        if (resultCode.code == 200) {
            ToastUtil.showToast(this, "添加成功");
            this.finish();
        } else {
            ToastUtil.showToast(this, "添加失败，稍后再试");
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

        if (btnDel.getText().toString().equals("添加好友")) {
            Map<String, Object> map = new HashMap<>();
            map.put("username", username);
            mPresenter.addFriend(map);

        } else if (btnDel.getText().toString().equals("删除好友")) {
            Map<String, Object> map = new HashMap<>();
            map.put("username", username);
            mPresenter.delFriend(map);
        }

    }
}
