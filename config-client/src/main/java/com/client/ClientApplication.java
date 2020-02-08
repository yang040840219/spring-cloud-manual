package com.client;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Set;

/**
 * 2020/2/8
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        DruidDataSourceAutoConfigure.class})
@EnableScheduling
public class ClientApplication extends SpringBootServletInitializer {

    @Autowired
    private ContextRefresher contextRefresher ;
    /**
     * 定时更新配置
     */
    @Scheduled(fixedRate = 1000000L)
    public void updateConfig(){
        System.out.println("执行更新");
        Set<String> keys = contextRefresher.refresh();
        if(!keys.isEmpty()){
            System.out.println("更新keys:" + keys);
        }
    }

    public static void main(String[] args){
        SpringApplication.run(ClientApplication.class, args);
    }


}
