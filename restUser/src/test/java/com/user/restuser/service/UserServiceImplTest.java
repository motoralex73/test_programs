package com.user.restuser.service;

import com.user.restuser.model.Users;
import com.user.restuser.repo.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepo userRepo;

    @Test
    void findById() {
        Users u1 = new Users(1L,"Alex","Aturov","loh@mail.ru","epta","123");
        Users u2 = new Users(1L,"Kirill","Laptev","email@mail.ru","epta","777");

        List<Users> list = List.of(u1,u2);//userRepo.findAll();
        System.out.println(list);
//        Mockito.when(list).thenReturn(List.of(u1,u2));
//        String name = u1.getName();
//        Assertions.assertEquals("Alex", name);
    }
}