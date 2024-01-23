package com.eshop.order.clients;

import com.eshop.order.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="userservice")
public interface UserClient {
    @GetMapping("/user/{userId}")
    User getUserById(@PathVariable  Long userId);
}
