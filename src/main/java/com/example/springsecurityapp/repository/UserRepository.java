package com.example.springsecurityapp.repository;

import com.example.springsecurityapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    User findByEmail(String email);
    User findByName(String name);
    void deleteByEmail(String email);
}
