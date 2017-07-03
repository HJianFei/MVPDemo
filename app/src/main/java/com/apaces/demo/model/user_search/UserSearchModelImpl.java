package com.apaces.demo.model.user_search;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.entity.User;
import com.apaces.demo.utils.XMPPLoadThread;
import com.apaces.demo.utils.xmpp.XMPPConnUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by HJF on 2017/7/3.
 * 描述：
 */

public class UserSearchModelImpl implements UserSearchModel {
    @Override
    public void userSearch(Map<String, Object> map, final onFinishListener listener) {

        final String tip = (String) map.get("tip");
        new XMPPLoadThread() {

            @Override
            protected Object load() {//查询用户
                return XMPPConnUtils.getInstance().searchUser(tip);
            }

            @Override
            protected void result(Object object) {
                List<User> listUser = (List<User>) object;
                BaseResponse<List<User>> response = new BaseResponse<>();
                response.setData(listUser);
                response.setMsg("success");
                response.setCode(200);
                listener.onFinished(response);
            }
        };

    }
}
