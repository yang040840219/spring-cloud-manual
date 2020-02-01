package com.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 2020/1/29
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class ServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(ServiceApplication.class, args);
    }
}
