package com.nur.librarymanagement.user;


import org.springframework.security.core.userdetails.UserDetailsService;

    public interface UserService extends UserDetailsService {
    User save(User user);
    }

