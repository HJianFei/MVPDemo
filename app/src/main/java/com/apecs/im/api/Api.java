package com.apecs.im.api;


import com.apecs.im.base.BaseResponse;
import com.apecs.im.constants.Urls;
import com.apecs.im.entity.Friend;
import com.apecs.im.entity.LoginResult;
import com.apecs.im.entity.ResultCode;
import com.apecs.im.entity.User;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.POST;

/**
 * Created by HJF on 2017/6/30.
 * 描述：
 */

public interface Api {

    //用户注册
    @POST(Urls.REG_USER)
    Observable<BaseResponse<ResultCode>> regUser(@FieldMap Map<String, Object> map);

    //用户登录
    @POST(Urls.LOGIN_USER)
    Observable<BaseResponse<LoginResult>> loginser(@FieldMap Map<String, Object> map);

    //获取好友列表
    @POST(Urls.USER_FRIENDS)
    Observable<BaseResponse<Friend>> getUserFriends(@FieldMap Map<String, Object> map);

    //用户详情
    @POST(Urls.USER_DETAIL)
    Observable<BaseResponse<User>> getUserDetail(@FieldMap Map<String, Object> map);

    //删除好友
    @POST(Urls.DEL_FRIEND)
    Observable<ResultCode> delFriend(@FieldMap Map<String, Object> map);

    //搜索用户
    @POST(Urls.USER_SEARCH)
    Observable<BaseResponse<List<User>>> userSearch(@FieldMap Map<String, Object> map);
}
