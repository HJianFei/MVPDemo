package com.apecs.im.view.fragment.dialogue.content;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apecs.im.R;
import com.apecs.im.adapter.common.CommonAdapter;
import com.apecs.im.adapter.common.OnItemClickListener;
import com.apecs.im.adapter.common.ViewHolder;
import com.apecs.im.anyevent.UserEvent;
import com.apecs.im.base.BaseFragment;
import com.apecs.im.base.BaseResponse;
import com.apecs.im.entity.Friend;
import com.apecs.im.presenter.dialogue.content.ContentPresenterImpl;
import com.apecs.im.utils.ImgConfig;
import com.apecs.im.utils.LogUtils;
import com.apecs.im.view.activity.user_detail.UserDetailActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class ContentFragment extends BaseFragment<ContentPresenterImpl> implements ContentView {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.rv_content)
    RecyclerView rvContent;
    Unbinder unbinder;
    private CommonAdapter<Friend> adapter;
    private List<Friend> friendList = new ArrayList<>();


    private String mParam1;
    private String mParam2;


    public ContentFragment() {

    }


    public static ContentFragment newInstance(String param1, String param2) {
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        //注册事件总线
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initView() {
        adapter = new CommonAdapter<Friend>(mActivity, R.layout.search_user_item_layout, friendList) {
            @Override
            public void setData(ViewHolder holder, final Friend friend) {
                holder.setText(R.id.user_name, friend.username);
                Bitmap bitmap = ImgConfig.showHeadImg(friend.username);
                if (bitmap == null) {
                    holder.setImageResource(R.id.user_avatar, R.drawable.default_avatar);
                } else {
                    holder.setImageBitmap(R.id.user_avatar, bitmap);
                }
                holder.setOnClickListener(R.id.user_avatar, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mActivity, UserDetailActivity.class);
                        intent.putExtra("username", friend.username);
                        intent.putExtra("type", "user_friend");//用户好友进入
                        startActivity(intent);

                    }
                });

            }
        };
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, Object o, int position) {

            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, Object o, int position) {
                return false;
            }
        });
        rvContent.setLayoutManager(new LinearLayoutManager(mActivity));
        rvContent.setAdapter(adapter);
    }

    private void initData() {
        Map<String, Object> map = new HashMap<>();
        mPresenter.getUserFriends(map);

    }

    @Subscribe
    public void eventMessage(UserEvent userEvent) {
        LogUtils.d("onResponse", userEvent.flag + ":" + userEvent.msg);

        if (userEvent.flag == 1 || userEvent.flag == 2) {
            initData();
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void createPresenter() {
        mPresenter = new ContentPresenterImpl();
    }

    @Override
    public void onFinished(BaseResponse<List<Friend>> response) {
        LogUtils.d("onResponse", response.toString());
        if (response.getCode() == 200) {
            friendList.clear();
            friendList.addAll(response.getData());
            adapter.notifyDataSetChanged();
        }


    }
}
