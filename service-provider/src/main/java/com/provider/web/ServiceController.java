package com.provider.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2020/1/29
 * 服务方controller
 */

@RestController
public class ServiceController {

    @Value("${server.port}")
    private  Integer port ;

    @PostMapping("/greeting")
    public String  greeting(@RequestBody String message){
        return "Greeting," + message  + " port:" + port;
    }
}
