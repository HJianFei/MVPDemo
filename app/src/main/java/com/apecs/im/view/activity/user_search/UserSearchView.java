package com.apecs.im.view.activity.user_search;


import com.apecs.im.base.BaseResponse;
import com.apecs.im.base.BaseView;
import com.apecs.im.entity.User;

import java.util.List;

/**
 * Created by HJF on 2017/6/30.
 * 描述：
 */

public interface UserSearchView extends BaseView {

    void onSearchFinished(BaseResponse<List<User>> responses);
}
