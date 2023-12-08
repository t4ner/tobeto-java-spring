package com.tobeto.homework.repositories;

import com.tobeto.homework.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
