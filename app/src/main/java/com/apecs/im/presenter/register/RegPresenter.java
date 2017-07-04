package com.apecs.im.presenter.register;


import com.apecs.im.base.BasePresenter;
import com.apecs.im.view.activity.register.RegView;

import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public interface RegPresenter extends BasePresenter<RegView> {

    void register(Map<String, Object> map);
}
