package com.config;

import com.aop.Calculate;
import com.aop.InMemoryCalculate;
import com.aop.LogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 2020/2/3
 */

@Configuration
@EnableAspectJAutoProxy
public class Config {

    @Bean
    public Calculate calculate(){
        return new InMemoryCalculate();
    }

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }
}
