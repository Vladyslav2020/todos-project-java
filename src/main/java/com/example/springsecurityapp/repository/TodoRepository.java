package com.example.springsecurityapp.repository;

import com.example.springsecurityapp.model.Todo;
import com.example.springsecurityapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByUser(User user);
    Optional<Todo> findById(Long id);
    void deleteById(Long id);
}
