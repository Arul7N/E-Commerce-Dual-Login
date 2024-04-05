package com.example.OrderService.Config;

import com.example.OrderService.Feign.AuthFeignController;
import com.example.OrderService.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderUserDS implements UserDetailsService {

    @Autowired
    private AuthFeignController authFeignController;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = authFeignController.searchByName(username);
        return user.map(com.example.OrderService.Config.UserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " is not found..!"));
    }
}
