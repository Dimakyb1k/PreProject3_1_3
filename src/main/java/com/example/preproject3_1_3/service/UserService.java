package com.example.preproject3_1_3.service;

import com.example.preproject3_1_3.model.User;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.List;


public interface UserService {
    List<User> getAllUser();
    void updateUser(User user);
    void addUser(User user);
    User findUserById(Long id);
    UserDetails loadUserByUsername(String username);
    void deleteUserById(Long id);
}