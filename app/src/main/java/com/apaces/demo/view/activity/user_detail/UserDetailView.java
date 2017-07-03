package com.apaces.demo.view.activity.user_detail;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.base.BaseView;
import com.apaces.demo.entity.ResultCode;
import com.apaces.demo.entity.UserDetailResult;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public interface UserDetailView extends BaseView {

    void onFinished(BaseResponse<UserDetailResult> response);

    void onIsFriendFinished(ResultCode resultCode);

    void onAddFriendFinished(ResultCode resultCode);

    void onDelFinished(ResultCode resultCode);
}
