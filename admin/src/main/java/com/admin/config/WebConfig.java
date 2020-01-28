package com.admin.config;

import com.admin.interceptor.CustomInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 2020/1/24
 */


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 需要通过 registry 注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(new CustomInterceptor());
        // 添加拦截请求
        ir.addPathPatterns("/*");
        // 添加不拦截请求
        ir.excludePathPatterns("/login");

    }
}
