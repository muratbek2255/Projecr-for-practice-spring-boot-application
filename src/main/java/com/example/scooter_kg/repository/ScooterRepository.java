package com.example.scooter_kg.repository;

import com.example.scooter_kg.entity.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScooterRepository extends JpaRepository<Scooter, Integer> {
    Scooter findByTitle(String title);

    Scooter findByPrice(Integer price);
}
