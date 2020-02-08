package com;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 2020/2/3
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
                                    DruidDataSourceAutoConfigure.class})
public class ManualApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ManualApplication.class) ;
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
