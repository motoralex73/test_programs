package com.example.superapp.controller;

import com.example.superapp.repo.User;
import com.example.superapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String hello() {
        return "Start page";
    }

    @GetMapping("/get")
    List<User> getUsers() {
        System.out.println("get mapping");
        return userService.returnAllUsers();
    }

    @PostMapping("/post")
    public User createUsers(@RequestBody User user) {
        System.out.println("post mapping : " + user.toString());
        return userService.create(user);
    }

}
