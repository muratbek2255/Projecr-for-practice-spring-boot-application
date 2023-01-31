package com.example.scooter_kg.service.impl;

import com.example.scooter_kg.entity.User;
import com.example.scooter_kg.entity.enums.Role;
import com.example.scooter_kg.repository.UserRepository;
import com.example.scooter_kg.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registry(User user) {
        Role role = userRepository.findByRole(Role.USER).getRole();

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(role);

        User registeredUser = userRepository.save(user);

        log.info("IN Register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        log.info("IN Get ALL - user: {} successfully", result);
        return result;
    }

    @Override
    public User findByEmail(String email) {
        User result = userRepository.findByEmail(email);
        log.info("IN Get username - user: {} successfully", result);
        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);

        if(result == null) {
            log.info("Find by Id: User Not Found: {}", result);
            return null;
        }
        log.info("IN Get id - user: {} successfully", result);
        return result;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN Get id - user: {} successfully deleted");
    }
}
