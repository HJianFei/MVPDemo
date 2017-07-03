package com.apaces.demo.view.activity.user_search;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.apaces.demo.R;
import com.apaces.demo.adapter.common.CommonAdapter;
import com.apaces.demo.adapter.common.ViewHolder;
import com.apaces.demo.base.BaseActivity;
import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.entity.User;
import com.apaces.demo.presenter.user_search.UserSearchPresenterImpl;
import com.apaces.demo.utils.ImgConfig;
import com.apaces.demo.utils.LogUtils;
import com.apaces.demo.utils.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserSearchActivity extends BaseActivity<UserSearchPresenterImpl> implements UserSearchView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.search_tip)
    EditText searchTip;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.re_search_result)
    RecyclerView reSearchResult;
    private CommonAdapter<User> adapter;
    private List<User> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_search);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {

        setToolBar(toolbar, "添加好友");
        //设配器
        adapter = new CommonAdapter<User>(this, R.layout.search_user_item_layout, list) {
            @Override
            public void setData(ViewHolder holder, User user) {

                holder.setText(R.id.user_name, user.username);
                holder.setText(R.id.user_nickname, user.nickname);
                Bitmap bitmap = ImgConfig.showHeadImg(user.username);
                if (bitmap == null) {
                    holder.setImageResource(R.id.user_avatar, R.drawable.default_avatar);
                } else {
                    holder.setImageBitmap(R.id.user_avatar, bitmap);
                }
            }
        };

        reSearchResult.setLayoutManager(new LinearLayoutManager(this));
        reSearchResult.setAdapter(adapter);

    }

    @Override
    protected void createPresenter() {
        mPresenter = new UserSearchPresenterImpl();

    }

    @Override
    public void onSearchFinished(BaseResponse<List<User>> responses) {
        LogUtils.d("onResponse", responses.toString());
        if (responses.getCode() == 200) {
            list.clear();
            list.addAll(responses.getData());
            adapter.notifyDataSetChanged();
        }

    }

    @OnClick(R.id.btn_search)
    public void onViewClicked() {

        if (TextUtils.isEmpty(searchTip.getText().toString())) {
            ToastUtil.showToast(this, "名称不能为空");
            return;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("tip", searchTip.getText().toString());
        mPresenter.userSearch(map);
    }
}
