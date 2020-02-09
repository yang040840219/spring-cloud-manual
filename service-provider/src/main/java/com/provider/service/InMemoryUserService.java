package com.provider.service;

import com.api.UserService;
import com.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 2020/1/31
 */

@Service(value = "inMemoryUserService")
public class InMemoryUserService implements UserService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private Map<Integer, User> users = new ConcurrentHashMap<Integer, User>();

    public Boolean saveUser(User user) {
        return users.put(user.getId(), user) == null ;
    }

    public List<User> findAll() {
        return new ArrayList<User>(users.values());
    }
}
