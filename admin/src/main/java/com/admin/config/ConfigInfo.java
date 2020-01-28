package com.admin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 配置文件类
 */
@PropertySource(value="classpath:variable.properties") // 读取 variable.properties
@Component
@ConfigurationProperties(prefix = "custom") // 读取 application.properties
public class ConfigInfo {

    private  String name ;

    private Integer age ;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
