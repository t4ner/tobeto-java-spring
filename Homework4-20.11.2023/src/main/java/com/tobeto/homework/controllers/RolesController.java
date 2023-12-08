package com.tobeto.homework.controllers;

import com.tobeto.homework.entities.Role;
import com.tobeto.homework.repositories.RoleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/roles")
public class RolesController {
    private final RoleRepository roleRepository;
    public RolesController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping
    public List<Role> getAll(){
        return roleRepository.findAll();
    }

    @GetMapping("{id}")
    public Role getById(@PathVariable int id){
        return roleRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Role role){
        roleRepository.save(role);
    }

    @PutMapping
    public void update(@RequestBody Role role){
        Role roleToUpdate = roleRepository.findById(role.getId()).orElseThrow();
        roleToUpdate.setName(role.getName());
        roleRepository.save(roleToUpdate);
    }
    @DeleteMapping
    public void delete(@PathVariable int id){
        roleRepository.deleteById(id);
    }
}
