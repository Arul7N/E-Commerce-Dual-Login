package com.example.AuthService.Service;

import com.example.AuthService.Dto.UserDto;
import com.example.AuthService.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

//    For All
    public User addUser(User user);

    //Admin Only
    public List<User> getAllUsers();

    //Users Only
    public Optional<User> getById(Long id);

    public Optional<User> getByUsername(String username);
}
