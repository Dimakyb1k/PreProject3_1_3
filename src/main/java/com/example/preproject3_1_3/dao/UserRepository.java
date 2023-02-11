package com.example.preproject3_1_3.dao;

import com.example.preproject3_1_3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u JOIN FETCH u.roles where u.name = (:name)")
    User findUserByName(@Param("name") String name);
}