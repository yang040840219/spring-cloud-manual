package com.api;

import com.domain.User;

import java.util.List;

/**
 * 2020/1/31
 */
public interface UserService {

    boolean saveUser(User user);

    List<User> findAll();
}
