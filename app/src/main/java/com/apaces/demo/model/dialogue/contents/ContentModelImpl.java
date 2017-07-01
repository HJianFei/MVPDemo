package com.apaces.demo.model.dialogue.contents;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.entity.Friend;
import com.apaces.demo.utils.XMPPLoadThread;
import com.apaces.demo.utils.xmpp.XMPPConnUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public class ContentModelImpl implements ContentModel {
    @Override
    public void getUserFriends(Map<String, Object> map, final onFinishListener listener) {
        new XMPPLoadThread() {

            @Override
            protected Object load() {
                return XMPPConnUtils.getInstance().getFriends();
            }

            @Override
            protected void result(Object object) {
                List<Friend> friendList = new ArrayList<>();
                friendList.clear();
                friendList.addAll((List<Friend>) object);
                BaseResponse<List<Friend>> response = new BaseResponse<>();
                response.setCode(200);
                response.setMsg("success");
                response.setData(friendList);
                listener.onFinished(response);
            }
        };
    }
}
