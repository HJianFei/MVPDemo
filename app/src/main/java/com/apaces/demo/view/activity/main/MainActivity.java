package com.apaces.demo.view.activity.main;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.apaces.demo.R;
import com.apaces.demo.base.App;
import com.apaces.demo.utils.ToastUtil;
import com.apaces.demo.view.fragment.business.BusinessFragment;
import com.apaces.demo.view.fragment.car.CarFragment;
import com.apaces.demo.view.fragment.dialogue.DialogueFragment;
import com.apaces.demo.view.fragment.me.MeFragment;
import com.apaces.demo.view.fragment.nearby.NearByFragment;
import com.apaces.demo.widget.CustomPopWindow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_global_search)
    ImageView btnGlobalSearch;
    @BindView(R.id.btn_global_menu)
    ImageView btnGlobalMenu;
    @BindView(R.id.home_chart)
    TextView homeChart;
    @BindView(R.id.home_nearby)
    TextView homeNearby;
    @BindView(R.id.home_car)
    TextView homeCar;
    @BindView(R.id.home_business)
    TextView homeBusiness;
    @BindView(R.id.home_me)
    TextView homeMe;
    private DialogueFragment dialogueFragment;
    private NearByFragment nearByFragment;
    private CarFragment carFragment;
    private BusinessFragment businessFragment;
    private MeFragment meFragment;
    private int curIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //默认加载第一个Fragment
        setDefaultFragment();

    }


    /**
     * 默认加载第一个Fragment
     */
    private void setDefaultFragment() {
        switchFragment(0);
        setTabState(homeChart, R.drawable.home_fill, getResources().getColor(R.color.colorPrimary));
    }


    /**
     * fragment之间切换
     *
     * @param i
     */
    private void switchFragment(int i) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (i) {
            case 0:
                if (dialogueFragment == null) {
                    dialogueFragment = DialogueFragment.newInstance("", "");
                }
                transaction.replace(R.id.container, dialogueFragment);
                curIndex = 0;
                break;
            case 1:
                if (nearByFragment == null) {
                    nearByFragment = NearByFragment.newInstance("", "");
                }
                transaction.replace(R.id.container, nearByFragment);
                curIndex = 1;
                break;
            case 2:
                if (carFragment == null) {
                    carFragment = CarFragment.newInstance("", "");
                }
                transaction.replace(R.id.container, carFragment);
                curIndex = 2;
                break;
            case 3:
                if (businessFragment == null) {
                    businessFragment = BusinessFragment.newInstance("", "");
                }
                transaction.replace(R.id.container, businessFragment);
                curIndex = 3;
                break;
            case 4:
                if (meFragment == null) {
                    meFragment = MeFragment.newInstance("", "");
                }
                transaction.replace(R.id.container, meFragment);
                curIndex = 4;
                break;
        }
        transaction.commit();
    }


    /**
     * 改变底部菜单按钮的状态
     *
     * @param textView
     * @param image
     * @param color
     */
    private void setTabState(TextView textView, int image, int color) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, image, 0, 0);
        textView.setTextColor(color);
    }


    /**
     * 重置底部按钮菜单
     */
    private void resetTabState() {
        setTabState(homeChart, R.drawable.home, getResources().getColor(R.color.black_1));
        setTabState(homeNearby, R.drawable.location, getResources().getColor(R.color.black_1));
        setTabState(homeCar, R.drawable.like, getResources().getColor(R.color.black_1));
        setTabState(homeBusiness, R.drawable.like, getResources().getColor(R.color.black_1));
        setTabState(homeMe, R.drawable.person, getResources().getColor(R.color.black_1));

    }


    //点击事件
    @OnClick({R.id.btn_global_search, R.id.btn_global_menu, R.id.home_chart, R.id.home_nearby, R.id.home_car, R.id.home_business, R.id.home_me})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_chart:
                resetTabState();
                setTabState(homeChart, R.drawable.home_fill, getResources().getColor(R.color.colorPrimary));
                switchFragment(0);
                break;
            case R.id.home_nearby:
                resetTabState();
                setTabState(homeNearby, R.drawable.location_fill, getResources().getColor(R.color.colorPrimary));
                switchFragment(1);
                break;
            case R.id.home_car:
                resetTabState();
                setTabState(homeCar, R.drawable.like_fill, getResources().getColor(R.color.colorPrimary));
                switchFragment(2);
                break;
            case R.id.home_business:
                resetTabState();
                setTabState(homeBusiness, R.drawable.like_fill, getResources().getColor(R.color.colorPrimary));
                switchFragment(3);
                break;
            case R.id.home_me:
                resetTabState();
                setTabState(homeMe, R.drawable.person_fill, getResources().getColor(R.color.colorPrimary));
                switchFragment(4);
                break;
            case R.id.btn_global_search:
                ToastUtil.showToast(this, "搜索");
                break;
            case R.id.btn_global_menu:
                if (curIndex == 0) {
                    CustomPopWindow customPopWindow = new CustomPopWindow(this);
                    customPopWindow.show(btnGlobalMenu);
                } else {
                    ToastUtil.showToast(this, "全局菜单");
                }
                break;
        }
    }


    //记录用户首次点击返回键的时间
    private long firstTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - firstTime > 2000) {
                Toast.makeText(MainActivity.this, "再按一次退出云电猫", Toast.LENGTH_SHORT).show();
                firstTime = System.currentTimeMillis();
            } else {
                App.getInstance().exitApp();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
