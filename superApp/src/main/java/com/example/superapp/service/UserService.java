package com.example.superapp.service;


import com.example.superapp.repo.User;
import com.example.superapp.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> returnAllUsers() {
        return userRepo.findAll();
    }

    public User create(User user) {
        System.out.println("create user service : " + user.toString());
        return userRepo.save(user);
    }
}
