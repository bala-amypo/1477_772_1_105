package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Create User
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // Get All Users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get User By Id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Update User
    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    // Delete User
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
        return "User deleted successfully";
    }
}
