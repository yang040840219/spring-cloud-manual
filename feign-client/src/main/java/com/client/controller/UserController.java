package com.client.controller;

import com.api.UserService;
import com.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2020/2/9
 */

@RestController
public class UserController implements UserService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService ;


    @Override
    public Boolean saveUser(User user) {
        return userService.saveUser(user);
    }

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

}
