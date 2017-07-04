package com.apecs.im.presenter.user_detail;


import com.apecs.im.base.BaseResponse;
import com.apecs.im.entity.ResultCode;
import com.apecs.im.entity.UserDetailResult;
import com.apecs.im.model.user_detail.UserDetailModel;
import com.apecs.im.model.user_detail.UserDetailModelImpl;
import com.apecs.im.view.activity.user_detail.UserDetailView;

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
    public void onIsFriendFinished(ResultCode resultCode) {
        mView.onIsFriendFinished(resultCode);
    }

    @Override
    public void onAddFriendFinished(ResultCode resultCode) {
        mView.onAddFriendFinished(resultCode);

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

    @Override
    public void addFriend(Map<String, Object> map) {
        mModel.addFriend(map, this);

    }

    @Override
    public void isFriend(Map<String, Object> map) {
        mModel.isFriend(map, this);

    }
}
