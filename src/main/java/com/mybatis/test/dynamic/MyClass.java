package com.mybatis.test.dynamic;

/**
 * Created by yinhao on 17/12/24.
 */
public class MyClass implements MyInterface2,MyInterface{

    public void doSomething() {
        System.out.println("MyClass doSomething!");
    }

    public void doSomething2() {
        System.out.println("MyClass doSomething2!");
    }
}
