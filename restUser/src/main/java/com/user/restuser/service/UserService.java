package com.user.restuser.service;

import com.user.restuser.model.Users;
import com.user.restuser.response.ResponseHandler;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    ResponseEntity<Object> save(Users user);
    ResponseEntity<Object> findById(Long id);
    ResponseEntity<Object> updateUser(Long id);
}
