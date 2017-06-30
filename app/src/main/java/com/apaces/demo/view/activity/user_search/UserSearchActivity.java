package com.apaces.demo.view.activity.user_search;

import android.os.Bundle;

import com.apaces.demo.R;
import com.apaces.demo.base.BaseActivity;

public class UserSearchActivity extends BaseActivity implements UserSearchView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_search);
    }

    @Override
    protected void createPresenter() {

    }
}
