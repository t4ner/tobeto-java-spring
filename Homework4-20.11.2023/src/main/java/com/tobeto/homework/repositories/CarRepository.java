package com.tobeto.homework.repositories;

import com.tobeto.homework.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer>{ }
