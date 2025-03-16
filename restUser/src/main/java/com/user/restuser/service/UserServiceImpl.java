package com.user.restuser.service;

import com.user.restuser.model.Users;
import com.user.restuser.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Long save(Users user) {
        userRepo.save(user);
        return user.getId();
    }

    @Override
    public Users findById(Long id) {
        //return new Users(id,"a", "b", "c", "d", "e");//userRepo.findById(id).get();
        return userRepo.findById(id).get();
    }

    @Override
    public Map<String, String> updateUser(Long id) {
        System.out.println("service / updateUser");
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
        return updateResponse;
    }
}
