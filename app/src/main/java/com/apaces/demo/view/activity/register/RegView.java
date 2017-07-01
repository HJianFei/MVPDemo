package com.apaces.demo.view.activity.register;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.base.BaseView;
import com.apaces.demo.entity.RegResult;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public interface RegView extends BaseView {

    void onRegFinished(BaseResponse<RegResult> response);
}
