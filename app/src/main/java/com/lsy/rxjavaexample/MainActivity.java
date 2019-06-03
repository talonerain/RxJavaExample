package com.lsy.rxjavaexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //常规操作
        Test1.test1();
        Test1.test1Charin();

        //just操作符
        TestJust.just();

        //fromArray操作符
        TestFromArray.FromArray();

        //fromCallable操作符
        TestFromCallable.fromCallable();
    }


}
