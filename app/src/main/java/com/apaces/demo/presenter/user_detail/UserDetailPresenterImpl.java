package com.apaces.demo.presenter.user_detail;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.entity.ResultCode;
import com.apaces.demo.entity.UserDetailResult;
import com.apaces.demo.model.user_detail.UserDetailModel;
import com.apaces.demo.model.user_detail.UserDetailModelImpl;
import com.apaces.demo.view.activity.user_detail.UserDetailView;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public class UserDetailPresenterImpl implements UserDetailPresenter, UserDetailModel.onFinishListener {

    private UserDetailModel mModel;
    private UserDetailView mView;

    public UserDetailPresenterImpl() {

        mModel = new UserDetailModelImpl();
    }

    @Override
    public void attachView(UserDetailView view) {
        mView = view;


    }

    @Override
    public void detachView() {
        mView = null;

    }

    @Override
    public void onFinished(BaseResponse<UserDetailResult> response) {
        mView.onFinished(response);

    }

    @Override
    public void onDelFinished(ResultCode resultCode) {
        mView.onDelFinished(resultCode);

    }

    @Override
    public void onError() {

    }

    @Override
    public void getUserDetail(Map<String, Object> map) {
        mModel.getUserDetail(map, this);

    }

    @Override
    public void delFriend(Map<String, Object> map) {
        mModel.delFriend(map, this);
    }
}
