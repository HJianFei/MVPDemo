package com.apaces.demo.presenter.user_detail;

import com.apaces.demo.base.BasePresenter;
import com.apaces.demo.view.activity.user_detail.UserDetailView;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public interface UserDetailPresenter extends BasePresenter<UserDetailView> {

    void getUserDetail(Map<String, Object> map);

    void delFriend(Map<String, Object> map);

    void addFriend(Map<String, Object> map);

    void isFriend(Map<String, Object> map);
}
