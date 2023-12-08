package com.tobeto.homework.controllers;

import com.tobeto.homework.entities.Brand;
import com.tobeto.homework.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/brands")
public class BrandsController {
    //Dependency => Bağımlılık
    //Injection => Enjekte

    private final BrandRepository brandRepository;
    //final => ctor blok dışında set edemezsiniz.
    public BrandsController(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<Brand> getAll(){
        return brandRepository.findAll();
    }

    @GetMapping("{id}")
    public Brand getById(@PathVariable int id){
        //Optionel<T> =>ilgili filtreden bir veri dönmeyebilir.
        return brandRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Brand brand){
        brandRepository.save(brand);
    }

    @PutMapping
    public void update(@RequestBody Brand brand){
        Brand brandToUpdate = brandRepository.findById(brand.getId()).orElseThrow();
        brandToUpdate.setName(brand.getName());
        brandRepository.save(brandToUpdate);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        brandRepository.deleteById(id);
    }

 }
