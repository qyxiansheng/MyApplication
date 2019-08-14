package com.demo.myapplication;

import android.util.Log;

public class A {
    private B b;

    public A(B b) {
        this.b = b;
    }

    public void eatA() {
        b.eatB();
        Log.d("A", "----------eatA--------");
    }
}
