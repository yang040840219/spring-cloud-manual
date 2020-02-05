package com;

import com.aop.Calculate;
import com.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 2020/2/3
 */

public class ManualApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        Calculate calculate = (Calculate)ctx.getBean("calculate") ;
        System.out.println(calculate);
        int result = calculate.add(1, 2);
        System.out.println(result);
    }
}
