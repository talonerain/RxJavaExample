package com.lsy.rxjavaexample;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

class Test1 {
    private static final String TAG = "Test1";

    static void test1() {
        //创建被观察者
        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "=====currentThread Name: " + Thread.currentThread());
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });

        //创建观察者
        Observer observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "=====onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "=====onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "=====onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "=====onComplete");
            }
        };

        observable.subscribe(observer);
    }

    /**
     * 链式调用写法
     */
    static void test1Charin() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "=====currentThread Name: " + Thread.currentThread());
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);

                //发送该事件后，其他事件将不会继续发送
                emitter.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "=====onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "=====onNext" + integer);
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
