package com.provider.web;

import com.api.UserService;
import com.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 2020/1/31
 */

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    private final static Random random = new Random();

    @Autowired
    private UserService userService ;


    @PostMapping("/saveUser")
    public Boolean saveUser(@RequestBody User user) {
        logger.info("save user:{}", user);
        return userService.saveUser(user);
    }


    /**
     * hystrix 配置通过注解方式
     * @return
     */
    @HystrixCommand(
            commandProperties = {
                    // 超时时间
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="100")
            },
            // 设置 fallback 方法
            fallbackMethod = "fallbackForFindAll")
    @RequestMapping("/findAll")
    public List<User> findAll(){
        logger.info("find all user...");
        int spentTime = random.nextInt(200);
        logger.info("find all user spent time :{}", spentTime);
        try {
            TimeUnit.MILLISECONDS.sleep(spentTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userService.findAll();
    }

    public List<User> fallbackForFindAll(){
        logger.info("execute fallback for find all user");
        return Collections.emptyList() ;
    }

}
