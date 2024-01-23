package com.eshop.user.controller;

import com.eshop.user.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{userId}")
    public User getUseById(@PathVariable Long userId){
        User user=new User();
        user.setId(1L);
        user.setAddress("到家");
        user.setUsername("用户001");
        return user;
    }
}
