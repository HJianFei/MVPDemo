package com.apecs.im.model.register;


import com.apecs.im.base.BaseResponse;
import com.apecs.im.entity.RegResult;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public interface RegModel {

    interface onFinishListener {

        void onFinished(BaseResponse<RegResult> regResult);

        void onError();
    }

    //注册
    void register(Map<String, Object> map, onFinishListener listener);
}
