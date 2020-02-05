package com.proxy;

import com.aop.Calculate;
import com.aop.InMemoryCalculate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 2020/2/4
 */
public class Client {

    public static void main(String[] args){
        Calculate calculate = new InMemoryCalculate();
        InvocationHandler handler = new LogInvocationHandler(calculate);

        Calculate proxy = (Calculate)(Proxy.newProxyInstance(Calculate.class.getClassLoader(),
                new Class[]{Calculate.class} ,handler));

        // 生成的proxy对象对用 add 方法会执行 super.h.invoke()
        int result = proxy.add(1,2);

        System.out.println(result);
    }
}
