package com.apaces.demo.presenter.dialogue.content;

import com.apaces.demo.base.BasePresenter;
import com.apaces.demo.view.fragment.dialogue.content.ContentView;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public interface ContentPresenter extends BasePresenter<ContentView> {

    void getUserFriends(Map<String, Object> map);
}
