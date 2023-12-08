package com.tobeto.homework.controllers;

import com.tobeto.homework.services.abstracts.CarService;
import com.tobeto.homework.services.dtos.requests.car.AddCarRequest;
import com.tobeto.homework.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.homework.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.homework.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("api/cars")
public class CarsController {
    private final CarService carService;

    @GetMapping
    //List<Car>
    public List<GetCarListResponse> getAll(){
       return carService.getAll();
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id){
        return carService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest addCarRequest ){
        carService.add(addCarRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateCarRequest updateCarRequest){
        carService.update(updateCarRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carService.delete(id);
    }
}
