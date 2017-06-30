package com.apaces.demo.api;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.constants.Urls;
import com.apaces.demo.entity.ResultCode;

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
}
