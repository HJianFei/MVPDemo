package com.apecs.im.presenter.dialogue.content;


import com.apecs.im.base.BasePresenter;
import com.apecs.im.view.fragment.dialogue.content.ContentView;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public interface ContentPresenter extends BasePresenter<ContentView> {

    void getUserFriends(Map<String, Object> map);
}
