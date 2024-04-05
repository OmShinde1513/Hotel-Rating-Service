package com.hotelservice.feignclient;

import com.hotelservice.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("USER-SERVICE")
public interface UserService {
    @GetMapping("/user/{id}")
    User getUser(@PathVariable String id);
}
