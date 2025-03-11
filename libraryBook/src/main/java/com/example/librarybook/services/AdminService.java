package com.example.librarybook.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_OTHER')")
    public void doAdminStuff() {
        System.out.println("Only admin here");
    }
}
