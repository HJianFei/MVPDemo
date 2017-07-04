package com.apecs.im.view.fragment.dialogue.content;


import com.apecs.im.base.BaseResponse;
import com.apecs.im.base.BaseView;
import com.apecs.im.entity.Friend;

import java.util.List;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public interface ContentView extends BaseView {

    void onFinished(BaseResponse<List<Friend>> response);
}
