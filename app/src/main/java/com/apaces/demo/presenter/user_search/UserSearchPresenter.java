package com.apaces.demo.presenter.user_search;

import com.apaces.demo.base.BasePresenter;
import com.apaces.demo.view.activity.user_search.UserSearchView;

import java.util.Map;

/**
 * Created by HJF on 2017/7/3.
 * 描述：
 */

public interface UserSearchPresenter extends BasePresenter<UserSearchView> {

    void userSearch(Map<String, Object> map);
}
