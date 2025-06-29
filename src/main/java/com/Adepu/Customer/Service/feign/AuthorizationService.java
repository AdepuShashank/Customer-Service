package com.Adepu.Customer.Service.feign;

import com.Adepu.Customer.Service.Model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("AUTHORIZATION-SERVICE")
public interface AuthorizationService {
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) ;

    @PostMapping("/login")
    public String login(@RequestBody User user);
    @PostMapping("/validate")
    public Boolean validateToken(@RequestHeader("Authorization") String authHeader);
}
