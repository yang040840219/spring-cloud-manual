package com.provider.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeoutException;

/**
 * 2020/1/29
 * 服务方controller
 */

@RestController
public class ServiceController {

    private final static Random random = new Random();

    @Value("${server.port}")
    private  Integer port ;

    @PostMapping("/greeting")
    public String  greeting(@RequestBody String message){
        return "Greeting," + message  + " port:" + port;
    }

    /**
     * 方法执行时间超过一定时间时触发异常, 通过 CustomRestControllerAdvice
     * @return
     */
    @RequestMapping("")
    public String index() throws Exception{

        int spentTime = random.nextInt(200);

        if(spentTime > 100){
            throw new TimeoutException("exeucte is timeout");
        }
        return "hello world" ;
    }
}
