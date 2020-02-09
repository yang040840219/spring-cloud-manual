package com.client;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.api.UserService;
import com.client.config.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 2020/2/9
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        DruidDataSourceAutoConfigure.class})
// 多个Ribbon 定义
@RibbonClients({
        @RibbonClient(name = "service-provider", configuration = {RibbonConfiguration.class})
})
@EnableDiscoveryClient
@EnableCircuitBreaker // 使用服务短路
@EnableFeignClients(clients = {UserService.class}) // 声明 UserService 接口作为Feign的client 调用
public class FeignClientApplication extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(FeignClientApplication.class, args);
    }
}
