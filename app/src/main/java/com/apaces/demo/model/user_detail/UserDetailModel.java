package com.apaces.demo.model.user_detail;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.entity.ResultCode;
import com.apaces.demo.entity.UserDetailResult;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public interface UserDetailModel {

    interface onFinishListener {

        void onFinished(BaseResponse<UserDetailResult> response);

        void onIsFriendFinished(ResultCode resultCode);

        void onAddFriendFinished(ResultCode resultCode);

        void onDelFinished(ResultCode resultCode);

        void onError();
    }

    //用户详情
    void getUserDetail(Map<String, Object> map, onFinishListener listener);

    //删除好友
    void delFriend(Map<String, Object> map, onFinishListener listener);

    //添加好友
    void addFriend(Map<String, Object> map, onFinishListener listener);

    //判断是否为好友关系
    void isFriend(Map<String, Object> map, onFinishListener listener);
}
