package com.example.scooter_kg.repository;


import com.example.scooter_kg.entity.User;
import com.example.scooter_kg.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByRole(Role role);
}
