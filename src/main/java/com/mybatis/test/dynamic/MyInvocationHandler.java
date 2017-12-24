package com.mybatis.test.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yinhao on 17/12/24.
 */
public class MyInvocationHandler implements InvocationHandler{

    private Object target;

    public MyInvocationHandler(Object target){
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke before");
        System.out.println(method);
        Object o = method.invoke(target, args);
        System.out.println("invoke after");
        return o;
    }
}
