package com.mybatis.test.dynamic;

import java.lang.reflect.Proxy;

/**
 * Created by yinhao on 17/12/24.
 */
public class DynamicTest {
    public static void main(String[] args) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(new MyClass());
        MyInterface proxyInstance = (MyInterface)Proxy.newProxyInstance
                (MyClass.class.getClassLoader(), MyClass.class.getInterfaces(), myInvocationHandler);
        proxyInstance.doSomething();
    }
}