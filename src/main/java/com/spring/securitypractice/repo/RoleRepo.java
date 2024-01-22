package com.spring.securitypractice.repo;

import com.spring.securitypractice.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepo extends JpaRepository<Roles, UUID> {
}
