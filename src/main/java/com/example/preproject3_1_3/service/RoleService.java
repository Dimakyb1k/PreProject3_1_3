package com.example.preproject3_1_3.service;



import com.example.preproject3_1_3.model.Role;

import java.util.List;


public interface RoleService {
    void save(Role role);
    List<Role> getAllRole();

}