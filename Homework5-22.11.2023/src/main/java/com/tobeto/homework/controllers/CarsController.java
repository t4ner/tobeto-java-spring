package com.tobeto.homework.controllers;


import com.tobeto.homework.dtos.requests.car.AddCarRequest;
import com.tobeto.homework.dtos.requests.car.UpdateCarRequest;
import com.tobeto.homework.dtos.responses.car.GetCarListResponse;
import com.tobeto.homework.dtos.responses.car.GetCarResponse;
import com.tobeto.homework.entities.Car;
import com.tobeto.homework.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {
    private final CarRepository carRepository;
    public CarsController(CarRepository carRepository){
        this.carRepository=carRepository;
    }

    @GetMapping
    //List<Car>
    public List<GetCarListResponse> getAll(){
        List<Car> carList = carRepository.findAll();
        List<GetCarListResponse> carListResponses = new ArrayList<GetCarListResponse>();
        for (Car car: carList) {
            GetCarListResponse carResponse = new GetCarListResponse();
            carResponse.setId(car.getId());
            carResponse.setPlate(car.getPlate());
            carResponse.setDailyPrice(car.getDailyPrice());
            carResponse.setState(car.isState());
            carResponse.setModel(car.getModel());
            carListResponses.add(carResponse);
        }
        return carListResponses;
        //return carRepository.findAll();
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id){
        Car car = carRepository.findById(id).orElseThrow();
        GetCarResponse dto = new GetCarResponse();
        dto.setPlate(car.getPlate());
        dto.setDailyPrice(car.getDailyPrice());
        dto.setState(car.isState());
        dto.setModel(car.getModel());
        return dto;
        //return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest addCarRequest ){
        Car car = new Car();
        car.setPlate(addCarRequest.getPlate());
        car.setDailyPrice(addCarRequest.getDailyPrice());
        car.setState(addCarRequest.isState());
        car.setModel(addCarRequest.getModel());
        carRepository.save(car);
        //carRepository.save(car);
    }

    @PutMapping
    public void update(@RequestBody UpdateCarRequest updateCarRequest){
        Car carToUpdate = carRepository.findById(updateCarRequest.getId()).orElseThrow();
        carToUpdate.setModel(updateCarRequest.getModel());
        carToUpdate.setState(updateCarRequest.isState());
        carToUpdate.setPlate(updateCarRequest.getPlate());
        carToUpdate.setDailyPrice(updateCarRequest.getDailyPrice());
        carRepository.save(carToUpdate);
        //Car carToUpdate = carRepository.findById(car.getId()).orElseThrow();
        //carToUpdate.setPlate(car.getPlate());
        //carRepository.save(carToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carRepository.deleteById(id);
    }
}
