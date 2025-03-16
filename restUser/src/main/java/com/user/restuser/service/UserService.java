package com.user.restuser.service;

import com.user.restuser.model.Users;

import java.util.Map;

public interface UserService {
    Long save(Users user);
    Users findById(Long id);
    Map<String, String> updateUser(Long id);
}
