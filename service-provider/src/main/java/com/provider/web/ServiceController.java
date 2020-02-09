package com.provider.web;

import com.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 2020/1/29
 * 服务方controller
 */

@RestController
public class ServiceController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

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

    /**
     * hystrix 配置通过注解方式
     * 方法执行超过 100ms 后执行 fallback
     * @return
     */
    @HystrixCommand(
            commandProperties = {
                    // 超时时间
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="100")
            },
            // 设置 fallback 方法
            fallbackMethod = "fallbackForFindAll")
    @RequestMapping("/timeout")
    public String timeout(){
        int spentTime = random.nextInt(200);
        logger.info("timeout method spent:{}", spentTime);
        try {
            TimeUnit.MILLISECONDS.sleep(spentTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }

    public String fallbackForTimeout(){
        logger.info("execute fallback for timeout");
        return "fallback" ;
    }

}
