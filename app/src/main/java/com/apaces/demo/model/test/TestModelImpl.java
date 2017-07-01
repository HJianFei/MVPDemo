package com.apaces.demo.model.test;

import android.util.Log;

import com.apaces.demo.base.BaseResponse;
import com.apaces.demo.entity.ResultCode;
import com.apaces.demo.utils.RetrofitUtil;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by HJianFei on 2017/6/29.
 * <p>
 * 描述：
 */

public class TestModelImpl implements TestModel {

    @Override
    public void getData(final onFinishListener listener) {

        Map<String, Object> map = new HashMap<>();

        RetrofitUtil.getApi().regUser(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponse<ResultCode>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                        Log.d("onResponse", d.isDisposed() + ":Disposable");
                        //dispose方法取消被观察者和观察者的订阅关系
                        d.dispose();
                        Log.d("onResponse", d.isDisposed() + ":Disposable");

                    }

                    @Override
                    public void onNext(@NonNull BaseResponse<ResultCode> resultCodeBaseResponse) {
                        Log.d("onResponse", "here:resultCodeBaseResponse");

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                        Log.d("onResponse", "here:onComplete");

                    }
                });


    }
}
