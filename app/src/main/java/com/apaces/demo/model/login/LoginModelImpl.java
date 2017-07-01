package com.apaces.demo.model.login;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.entity.ResultCode;
import com.apaces.demo.utils.XMPPLoadThread;
import com.apaces.demo.utils.xmpp.XMPPConnUtils;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：登录操作的具体实现
 */

public class LoginModelImpl implements LoginModel {

    @Override
    public void login(Map<String, Object> map, final onFinishListener listener) {
        final String username = (String) map.get("username");
        final String password = (String) map.get("password");
        new XMPPLoadThread() {

            @Override
            protected Object load() {
                return XMPPConnUtils.getInstance().login(username, password);
            }

            @Override
            protected void result(Object object) {

                boolean flag = (boolean) object;
                if (flag) {
                    BaseResponse response = new BaseResponse();
                    response.setCode(200);
                    response.setMsg("success");
                    response.setData(new ResultCode());
                    listener.onFinished(response);
                } else {
                    listener.onError();
                }

            }
        };

    }
}
