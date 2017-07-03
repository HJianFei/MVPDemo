package com.apaces.demo.view.activity.user_search;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.base.BaseView;
import com.apaces.demo.entity.User;

import java.util.List;

/**
 * Created by HJF on 2017/6/30.
 * 描述：
 */

public interface UserSearchView extends BaseView {

    void onSearchFinished(BaseResponse<List<User>> responses);
}
