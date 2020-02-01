package com.client;

import com.client.config.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 2020/1/29
 */

@SpringBootApplication
// 多个Ribbon 定义
@RibbonClients({
        @RibbonClient(name = "service-provider", configuration = {RibbonConfiguration.class})
})
@EnableDiscoveryClient
@EnableCircuitBreaker // 使用服务短路
public class ClientApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    // 创建 RestTemplate
    @LoadBalanced  // RestTemplate 增加 ClientHttpInterceptor 行为发生变化
    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}
