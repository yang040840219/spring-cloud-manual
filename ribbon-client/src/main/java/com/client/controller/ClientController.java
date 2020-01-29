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


    @Value("${service.provider.host}")
    private String serviceProviderHost ;

    @Value("${service.provider.port}")
    private String serviceProviderPort ;

    @RequestMapping("/greeting")
    public String greeting(){

        return restTemplate.postForObject("http://"+ serviceProviderHost +":"+ serviceProviderPort +"/service/greeting",
                "{\"name\":\"hello\"}", String.class);

    }

}
