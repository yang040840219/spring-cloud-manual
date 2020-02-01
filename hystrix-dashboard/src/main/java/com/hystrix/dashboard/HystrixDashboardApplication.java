package com.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 2020/2/1
 */

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }
}
