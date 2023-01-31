package com.example.scooter_kg.service;

import com.example.scooter_kg.entity.User;

import java.util.List;

public interface UserService {
    User registry(User user);

    List<User> getAll();

    User findByEmail(String username);

    User findById(Long id);

    void delete(Long id);
}
