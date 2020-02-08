package com.aop;

import com.server.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 2020/2/7
 */
public class AopApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        Calculate calculate = (Calculate)ctx.getBean("calculate") ;
        System.out.println(calculate);
        int result = calculate.add(1, 2);
        System.out.println(result);
    }
}
