package com.user.restuser.controller;

import com.user.restuser.model.Users;
import com.user.restuser.repo.UserRepo;
import com.user.restuser.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void getOne() {
        Users u = new Users(1L,"Alex","Aturov","loh@mail.ru","epta","123");
        System.out.println("get one test -> surname = " + u.getSurname());
        Assertions.assertEquals(u.getId(), 1L);
    }

    @Test
    void getUsers() {
        Users u = new Users(1L,"Kirill","Laptev","email@mail.ru","epta","777");
        System.out.println("get users test -> name = " + u.getName());
        Assertions.assertEquals(u.getName(),"Kirill");
    }
}