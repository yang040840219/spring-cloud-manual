package com.service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2020/1/29
 * 服务方controller
 */

@RestController
public class ServiceController {

    @PostMapping("/greeting")
    public String  greeting(@RequestBody String message){
        return "Greeting," + message ;
    }
}
