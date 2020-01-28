package com.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 2020/1/24
 */

@SpringBootApplication // 包含其他三个注解 @ComponentScan 扫描bean、
                        // @EnableAutoConfiguration 启动自动配置、
                        // @SpringBootConfiguration --> @Configuration 解析 @Bean 注解
@ComponentScan({"com.admin.controller",
                "com.admin.config",
                "com.admin.mapper",
                "com.admin.service"}) // 默认情况下扫描同级、子目录下的类 @Component 、@Service
@EnableTransactionManagement // 开启事物
@ServletComponentScan({"com.admin.filter"}) // 扫描 servlet 相关的注解 @WebFilter @WebServlet @WebListener
@EnableDiscoveryClient
public class AdminApplication extends SpringBootServletInitializer {

        public static void main(String[] args) {
            SpringApplication.run(AdminApplication.class, args);
        }
}

// @EnableAutoConfiguration
/**
 * 1. spring boot 根据依赖判断是否使用某个技术
 * 2. spring boot 加载依赖技术的 auto config  mybatis-spring-boot-autoconfigure-2.1.1.jar
 * 3. spring boot 加载配置类 MybatisAutoConfiguration
 **/