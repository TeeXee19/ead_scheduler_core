package com.interra.ead_scheduler_core.repository;

import java.util.List;

import com.interra.ead_scheduler_core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUserName(String userName);
    List<User> findAll(); 
}