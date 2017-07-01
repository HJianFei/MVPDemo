package com.apaces.demo.presenter.dialogue.content;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.entity.Friend;
import com.apaces.demo.model.dialogue.contents.ContentModel;
import com.apaces.demo.model.dialogue.contents.ContentModelImpl;
import com.apaces.demo.view.fragment.dialogue.content.ContentView;

import java.util.List;
import java.util.Map;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public class ContentPresenterImpl implements ContentPresenter, ContentModel.onFinishListener {

    private ContentView contentView;
    private ContentModel contentModel;

    public ContentPresenterImpl() {
        contentModel = new ContentModelImpl();
    }

    @Override
    public void attachView(ContentView view) {
        contentView = view;

    }

    @Override
    public void detachView() {
        contentView = null;

    }

    @Override
    public void onFinished(BaseResponse<List<Friend>> friends) {
        contentView.onFinished(friends);

    }

    @Override
    public void onError() {
        contentView.showError("网络出错，稍后再试");

    }

    @Override
    public void getUserFriends(Map<String, Object> map) {
        contentModel.getUserFriends(map, this);

    }
}
