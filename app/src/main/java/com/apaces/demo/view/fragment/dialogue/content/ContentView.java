package com.apaces.demo.view.fragment.dialogue.content;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.base.BaseView;
import com.apaces.demo.entity.Friend;

import java.util.List;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public interface ContentView extends BaseView {

    void onFinished(BaseResponse<List<Friend>> response);
}
