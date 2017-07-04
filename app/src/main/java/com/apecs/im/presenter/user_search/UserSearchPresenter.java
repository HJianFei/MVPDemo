package com.apecs.im.presenter.user_search;


import com.apecs.im.base.BasePresenter;
import com.apecs.im.view.activity.user_search.UserSearchView;

import java.util.Map;

/**
 * Created by HJF on 2017/7/3.
 * 描述：
 */

public interface UserSearchPresenter extends BasePresenter<UserSearchView> {

    void userSearch(Map<String, Object> map);
}
