package com.lsy.rxjavaexample;

import android.annotation.SuppressLint;
import android.util.Log;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class TestFromCallable {
    private final static String TAG = "TestFromCallable";

    /**
     * 这里的Callable就是java中的Callable，和Runnable用法基本一致，只是它会
     * 返回一个结果值，发送给观察者
     */
    @SuppressLint("CheckResult")
    static void fromCallable() {
        Observable.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "=====accept " + integer);
            }
        });
    }
}
