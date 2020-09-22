package com.interra.ead_scheduler_core.repository;

import com.interra.ead_scheduler_core.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}