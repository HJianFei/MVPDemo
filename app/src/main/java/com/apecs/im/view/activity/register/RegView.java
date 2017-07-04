package com.apecs.im.view.activity.register;


import com.apecs.im.base.BaseResponse;
import com.apecs.im.base.BaseView;
import com.apecs.im.entity.RegResult;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public interface RegView extends BaseView {

    void onRegFinished(BaseResponse<RegResult> response);
}
