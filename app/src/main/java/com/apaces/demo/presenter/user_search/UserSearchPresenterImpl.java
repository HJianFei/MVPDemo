package com.apaces.demo.presenter.user_search;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.entity.User;
import com.apaces.demo.model.user_search.UserSearchModel;
import com.apaces.demo.model.user_search.UserSearchModelImpl;
import com.apaces.demo.view.activity.user_search.UserSearchView;

import java.util.List;
import java.util.Map;

/**
 * Created by HJF on 2017/7/3.
 * 描述：
 */

public class UserSearchPresenterImpl implements UserSearchPresenter, UserSearchModel.onFinishListener {


    private UserSearchView mView;
    private UserSearchModel model;

    public UserSearchPresenterImpl() {

        model = new UserSearchModelImpl();
    }

    @Override
    public void attachView(UserSearchView view) {

        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;

    }

    @Override
    public void onFinished(BaseResponse<List<User>> response) {

        mView.onSearchFinished(response);

    }

    @Override
    public void onError() {

    }

    @Override
    public void userSearch(Map<String, Object> map) {

        model.userSearch(map, this);

    }
}
