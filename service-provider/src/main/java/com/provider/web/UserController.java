package com.provider.web;

import com.api.UserService;
import com.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2020/1/31
 */

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService ;


    @PostMapping("/saveUser")
    public Boolean saveUser(@RequestBody User user) {
        logger.info("save user:{}", user);
        return userService.saveUser(user);
    }


    @PostMapping("/findAll")
    public List<User> findAll(){
        logger.info("find all user...");
        return userService.findAll();
    }

}
