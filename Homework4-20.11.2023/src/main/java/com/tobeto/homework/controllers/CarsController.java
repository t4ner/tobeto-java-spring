package com.tobeto.homework.controllers;


import com.tobeto.homework.entities.Car;
import com.tobeto.homework.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {
    private final CarRepository carRepository;
    public CarsController(CarRepository carRepository){
        this.carRepository=carRepository;
    }

    @GetMapping
    public List<Car> getAll(){
        return carRepository.findAll();
    }

    @GetMapping("{id}")
    public Car getById(@PathVariable int id){
        return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Car car){
        carRepository.save(car);
    }

    @PutMapping
    public void update(@RequestBody Car car){
        Car carToUpdate = carRepository.findById(car.getId()).orElseThrow();
        carToUpdate.setPlate(car.getPlate());
        carRepository.save(carToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){carRepository.deleteById(id);
    }
}
