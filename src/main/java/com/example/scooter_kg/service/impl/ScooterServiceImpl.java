package com.example.scooter_kg.service.impl;

import com.example.scooter_kg.entity.Scooter;
import com.example.scooter_kg.entity.User;
import com.example.scooter_kg.entity.enums.Role;
import com.example.scooter_kg.repository.ScooterRepository;
import com.example.scooter_kg.service.ScooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ScooterServiceImpl implements ScooterService {

    @Autowired
    ScooterRepository scooterRepository;

    @Override
    public List<Scooter> getAllScooters() {
        return scooterRepository.findAll();
    }

    @Override
    public void saveScooter(Scooter scooter) {
        scooterRepository.save(scooter);
    }

    @Override
    public Optional<Scooter> findById(int id) {
        return scooterRepository.findById(id);
    }

    @Override
    public void deleteScooter(int id) {
        scooterRepository.deleteById(id);
    }
}
