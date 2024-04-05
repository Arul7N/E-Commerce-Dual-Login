package com.example.AuthService.Controller;

import com.example.AuthService.Model.User;
import com.example.AuthService.Request.LoginReqDto;
import com.example.AuthService.Service.JwtService;
import com.example.AuthService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private LoginReqDto loginReqDto;

    @PostMapping("/register")
    public User newUser(@RequestBody User user){
        return service.addUser(user);
    }

    @GetMapping("/home")
    public String home(){
        return "Welcome Home...!";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin/all")
    public List<User> viewAll(){
        return service.getAllUsers();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/user/id/{id}")
    public Optional<User> searchById(@PathVariable("id") long id){
        return service.getById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/user/name/{username}")
    public Optional<User> searchByName(@PathVariable("username") String username){
        return service.getByUsername(username);
    }

    @PostMapping("/token/login")
    public String generateToken(@RequestBody LoginReqDto loginReqDto){
        String username = loginReqDto.getUsername();
        String password = loginReqDto.getPassword();

        Authentication authenticate = authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        if(authenticate.isAuthenticated()){
            String token = jwtService.geenrateToken(username);
            return token;
        }
        else {
            throw  new UsernameNotFoundException(username + " is not found");
        }
    }

    @GetMapping("/loggedUser")
    public String loggedUsername(String token){
        return jwtService.extractUsername(token);
    }
}
