package com.tobeto.homework.controllers;

import com.tobeto.homework.entities.User;
import com.tobeto.homework.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("id/users")
public class UsersController {
    private final UserRepository userRepository;
    public UsersController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable int id){
        return userRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody User user){
        userRepository.save(user);
    }

    @PutMapping
    public void update(@RequestBody User user){
        User userToUpdate = userRepository.findById(user.getId()).orElseThrow();
        userToUpdate.setEmail(user.getEmail());
        userRepository.save(userToUpdate);
    }
    @DeleteMapping
    public void delete(@PathVariable int id){
        userRepository.deleteById(id);
    }
}
