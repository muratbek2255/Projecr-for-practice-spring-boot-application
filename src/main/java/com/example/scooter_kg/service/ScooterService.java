package com.example.scooter_kg.service;

import com.example.scooter_kg.entity.Scooter;
import com.example.scooter_kg.entity.User;

import java.util.List;
import java.util.Optional;

public interface ScooterService {
    public List<Scooter> getAllScooters();

    public void saveScooter(Scooter scooter);

    public Optional<Scooter> findById(int id);

    public void deleteScooter(int id);
}
