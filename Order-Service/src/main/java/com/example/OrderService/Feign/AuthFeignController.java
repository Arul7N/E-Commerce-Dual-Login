package com.example.OrderService.Feign;

import com.example.OrderService.Model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "Auth-Service", url = "http://localhost:8008/auth")
public interface AuthFeignController {


    @GetMapping("/token/{username}/{password}")
    public String generateToken(@PathVariable("username") String username,
                                @PathVariable("password") String password);

    @GetMapping("/user/name/{username}")
    public Optional<User> searchByName(@PathVariable("username") String username);

    @GetMapping("/loggedUser")
    public String loggedUsername(String token);
}
