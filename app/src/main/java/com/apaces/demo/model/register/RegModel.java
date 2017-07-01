package com.apaces.demo.model.register;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.entity.RegResult;

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
