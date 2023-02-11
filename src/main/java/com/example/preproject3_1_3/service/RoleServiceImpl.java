package com.example.preproject3_1_3.service;

import com.example.preproject3_1_3.dao.RoleRepository;
import com.example.preproject3_1_3.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    @Transactional(readOnly = true)
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }
    @Override
    @Transactional
    public void save(Role role) {
        roleRepository.save(role);
    }
}
