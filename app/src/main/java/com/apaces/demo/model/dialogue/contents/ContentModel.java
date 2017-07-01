package com.apaces.demo.model.dialogue.contents;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.entity.Friend;

import java.util.List;
import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public interface ContentModel {

    interface onFinishListener {

        void onFinished(BaseResponse<List<Friend>> friends);

        void onError();
    }

    //获取用户好友
    void getUserFriends(Map<String, Object> map, onFinishListener listener);
}
