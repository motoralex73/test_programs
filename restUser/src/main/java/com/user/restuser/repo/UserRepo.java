package com.user.restuser.repo;

import com.user.restuser.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Long> {
    @Override
    Optional<Users> findById(Long id);
    Optional<Users> findByEmail(String email);
}
