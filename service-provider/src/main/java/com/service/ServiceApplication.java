package com.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 2020/1/29
 */

@SpringBootApplication
public class ServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(ServiceApplication.class, args);
    }
}
