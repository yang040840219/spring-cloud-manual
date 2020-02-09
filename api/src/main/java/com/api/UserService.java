package com.api;

import com.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 2020/1/31
 */


@FeignClient(name="${user.service.name}")
public interface UserService {

    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping("/user/saveUser")
    Boolean saveUser(User user);

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/user/findAll")
    List<User> findAll();
}
