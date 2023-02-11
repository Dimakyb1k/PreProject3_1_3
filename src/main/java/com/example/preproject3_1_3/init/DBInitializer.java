package com.example.preproject3_1_3.init;


import com.example.preproject3_1_3.dao.UserRepository;
import com.example.preproject3_1_3.model.Role;
import com.example.preproject3_1_3.model.User;
import com.example.preproject3_1_3.service.RoleService;
import com.example.preproject3_1_3.service.UserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Set;

@Service
public class DBInitializer {
    private final UserService userService;
    private final UserRepository userRepository;
    private final RoleService roleService;
    public DBInitializer(UserService userService,
                         UserRepository userRepository, RoleService roleService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.roleService = roleService;
    }
    @Transactional
    @PostConstruct
    public void initDB() {
        roleService.save(new Role("ROLE_ADMIN"));
        roleService.save(new Role("ROLE_USER"));
        userService.addUser(new User("admin", "admin@test.com", (byte) 45,
                "admin", Set.of(new Role(1L, "ROLE_ADMIN"))));
        userService.addUser(new User("user", "user@test.com", (byte) 25,
                "user", Set.of(new Role(2L, "ROLE_USER"))));
    }
}
