package com.tobeto.homework.controllers;

import com.tobeto.homework.entities.Brand;
import com.tobeto.homework.entities.Model;
import com.tobeto.homework.repositories.ModelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/models")
public class ModelsController {
    private final ModelRepository modelRepository;
    public ModelsController(ModelRepository modelRepository){
        this.modelRepository = modelRepository;
    }
    @GetMapping
    public List<Model> getAll(){
        return modelRepository.findAll();
    }

    @GetMapping("{id}")
    public Model getById(@PathVariable int id){
        return modelRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Model model){
        modelRepository.save(model);
    }

    @PutMapping
    public void update(@RequestBody Model model){
        Model modelToUpdate = modelRepository.findById(model.getId()).orElseThrow();
        modelToUpdate.setName(model.getName());
        modelRepository.save(modelToUpdate);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        modelRepository.deleteById(id);
    }


}
