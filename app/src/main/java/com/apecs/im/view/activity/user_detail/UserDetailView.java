package com.apecs.im.view.activity.user_detail;

import com.apecs.im.base.BaseResponse;
import com.apecs.im.base.BaseView;
import com.apecs.im.entity.ResultCode;
import com.apecs.im.entity.UserDetailResult;

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
