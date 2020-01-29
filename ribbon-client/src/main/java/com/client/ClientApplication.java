package com.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 2020/1/29
 */

@SpringBootApplication
public class ClientApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    // 创建 RestTemplate
    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }

}
