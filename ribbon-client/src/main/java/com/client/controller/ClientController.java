package com.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 2020/1/29
 */

@RestController
public class ClientController {

    @Autowired
    private RestTemplate restTemplate ;
    @Value("${service-provider.host}")
    private String serviceProviderHost ;

    @Value("${service-provider.port}")
    private String serviceProviderPort ;

    @Value("${service-provider.name}")
    private String serviceProviderName ;


    @RequestMapping("/greeting")
    public String greeting(){
        // 直接使用RestTemplate 发送请求
//        return restTemplate.postForObject("http://"+ serviceProviderHost +":"+ serviceProviderPort +"/service/greeting",
//                "{\"name\":\"hello\"}", String.class);

        // ribbon 通过名称访问， ClientHttpInterceptor --> LoadBalancerInterceptor
        return restTemplate.postForObject("http://"+ serviceProviderName  +"/greeting",
                "{\"name\":\"hello\"}", String.class);
    }




}
