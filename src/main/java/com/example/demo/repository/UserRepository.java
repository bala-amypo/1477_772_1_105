package com.example.demo.repository;

import com.example.demo.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findByUsername(String username);

    List<User> findAll();
}
