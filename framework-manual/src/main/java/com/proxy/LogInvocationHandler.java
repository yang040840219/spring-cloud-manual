package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 2020/2/4
 */
public class LogInvocationHandler implements InvocationHandler {

    private Object  subject ;

    public LogInvocationHandler(Object subject) {
        this.subject = subject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        System.out.println("execute : " + method.getName());
        Object result = method.invoke(subject, args);
        System.out.println("after");
        return result ;
    }
}
