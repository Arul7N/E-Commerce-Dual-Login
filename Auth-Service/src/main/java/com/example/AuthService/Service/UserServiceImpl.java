package com.example.AuthService.Service;

import com.example.AuthService.Dto.UserDto;
import com.example.AuthService.Model.User;
import com.example.AuthService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User addUser(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return repository.save(entity);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> all = repository.findAll();
        List<User> allUsers = all.stream()
                .filter(users -> users.getRole().equals("ROLE_USER"))
                .collect(Collectors.toList());
        return allUsers;
    }

    @Override
    public Optional<User> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return repository.findByUsername(username);
    }
}
