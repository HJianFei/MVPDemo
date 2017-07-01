package com.apaces.demo.view.fragment.dialogue.content;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apaces.demo.R;
import com.apaces.demo.adapter.common.CommonAdapter;
import com.apaces.demo.adapter.common.OnItemClickListener;
import com.apaces.demo.adapter.common.ViewHolder;
import com.apaces.demo.base.BaseFragment;
import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.entity.Friend;
import com.apaces.demo.presenter.dialogue.content.ContentPresenterImpl;
import com.apaces.demo.utils.ImgConfig;
import com.apaces.demo.utils.LogUtils;

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
//                        Intent intent = new Intent(mActivity, FriendActivity.class);
//                        intent.putExtra("user_name", friend.username);
//                        startActivity(intent);

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
