package com.admin.controller;

import com.admin.config.ConfigInfo;
import com.admin.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2020/1/24
 */

@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Value("${custom.name}")
    private String name ;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ConfigInfo configInfo;

    @RequestMapping("/hello")
    public String index(){
        return "Hello World" ;
    }

    @RequestMapping("/variable")
    public String variable(){
        logger.info("custom.name: {}", new Object[]{name});
        // 通过配置类读取数据
        logger.info("custom info name: {}", new Object[]{configInfo.getName()}  ) ;
        // 读取单独配置文件的数据
        logger.info("custom info age: {}", new Object[]{configInfo.getAge()});
        return "variables" ;
    }


    @Autowired
    private StudentService studentService;

    @RequestMapping("/selectVersion")
    public String selectVersion(){
        String version = studentService.selectVersion();
        logger.info("version:{}", new Object[]{version});
        return version;
    }

    @RequestMapping("/serviceInstance")
    public List<ServiceInstance> serviceInstance(){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("admin");
        return serviceInstances ;
    }

}
