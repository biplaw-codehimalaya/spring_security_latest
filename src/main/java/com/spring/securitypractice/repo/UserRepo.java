package com.spring.securitypractice.repo;


import com.spring.securitypractice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}
