package com.demo.myapplication;

import dagger.Module;
import dagger.Provides;

//第一步 添加@Module 注解
@Module
public class MainModule {
    //第二步 使用Provider 注解 实例化对象
    /***
     * 构造方法需要其他参数时候
     *
     * @return
     */
    @Provides
    B providerB() {
        return new B();
    }
    @Provides
    A providerA(B b) {
        return new A(b);
    }

}
