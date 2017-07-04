package com.apecs.im.model.user_search;

import com.apecs.im.base.BaseResponse;
import com.apecs.im.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by HJF on 2017/7/3.
 * 描述：
 */

public interface UserSearchModel {

    interface onFinishListener {

        void onFinished(BaseResponse<List<User>> response);

        void onError();
    }

    //搜索好友
    void userSearch(Map<String, Object> map, onFinishListener listener);


}
