package com.user.restuser.service;

import com.user.restuser.exception.UserExistEmailException;
import com.user.restuser.exception.UserNotFoundException;
import com.user.restuser.model.Users;
import com.user.restuser.repo.UserRepo;
import com.user.restuser.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public ResponseEntity<Object> save(Users user) {
        Long id = userRepo.save(user).getId();
        return ResponseHandler.responseBuilder("user was saved", HttpStatus.OK, id);
    }

    @Override
    public ResponseEntity<Object> findById(Long id) {
        if (!userRepo.findById(id).isPresent()) throw new UserNotFoundException("User does not exist");
        return ResponseHandler.responseBuilder("user find", HttpStatus.OK, userRepo.findById(id).get());
    }

    @Override
    public ResponseEntity<Object> updateUser(Long id) {
        System.out.println("service / updateUser");
        if (!userRepo.findById(id).isPresent()) throw new UserNotFoundException("User EPTA does not exist");
        Users user = userRepo.findById(id).get();
        Map<String, String> updateResponse = new HashMap<>();
        updateResponse.put("id", user.getId().toString());
        updateResponse.put("previous status", user.getStatus());
        if (user.getStatus().equalsIgnoreCase("offline")) {
            user.setStatus("online");
        }
        else {
            user.setStatus("offline");
        }
        updateResponse.put("current status", user.getStatus());
        userRepo.save(user);
        return ResponseHandler.responseBuilder("user was update", HttpStatus.OK, updateResponse);
    }
}
