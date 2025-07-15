package com.user.restuser.controller;

import com.user.restuser.model.Users;
import com.user.restuser.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class Controller {

    UserService userService;

    @GetMapping("/one")
    public Users getOne() {
        System.out.println("Get mapping one");
        return new Users(1L,"Aturov","Alex","loh@mail.ru","epta","123");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUsers(@PathVariable String userId) {
        Long id = Long.parseLong(userId);
        System.out.println("get mapping getUser = " + id);
        return userService.findById(id);
    }

    //добавить нового пользователя, id не нужен
    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody Users user) {
        System.out.println("postMapping addUser");
        return userService.save(user);
    }

    //изменить статус пользователя
    @PutMapping("/{userId}")
    public ResponseEntity<Object> updateUserStatus(@PathVariable String userId) {
        System.out.println("PUT MAPPING");
        return userService.updateUser(Long.parseLong(userId));
    }
}
