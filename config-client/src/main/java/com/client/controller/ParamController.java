package com.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2020/2/8
 */

@RestController
public class ParamController {

    @Autowired
    private Environment env ;

    @Value("${custom.config.name}")
    private String name ;

    @RequestMapping("/getParam")
    public String getParam(String key){
        System.out.println("name:" + name);
        return name;
    }

}
