package com.lsy.rxjavaexample;


import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class TestJust {
    private static final String TAG = "TestJust";

    /**
     * just操作符会创建被观察者，并按照参数依次发送onNext事件，最后发送onComplete事件，发送的事件
     * 不得超过10个。
     */
    static void just() {
        Observable.just(1, 2, 3)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "=====onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "=====onNext " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "=====onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "=====onComplete");
                    }
                });
    }
}
