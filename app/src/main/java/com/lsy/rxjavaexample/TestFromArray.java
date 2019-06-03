package com.lsy.rxjavaexample;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class TestFromArray {

    /**
     * 创建一个被观察者，与just不同的是可以传入超过10个变量，并且可以传入一个数组
     */
    static void FromArray() {
        int array[] = {1, 2, 3, 4};
        Observable.fromArray(array)
                .subscribe(new Observer<int[]>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(int[] ints) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
