package com.tobeto.homework.repositories;

import com.tobeto.homework.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Integer> {}
