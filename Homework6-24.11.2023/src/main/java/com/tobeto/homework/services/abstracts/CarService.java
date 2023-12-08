package com.tobeto.homework.services.abstracts;

import com.tobeto.homework.services.dtos.requests.car.AddCarRequest;
import com.tobeto.homework.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.homework.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.homework.services.dtos.responses.car.GetCarResponse;

import java.util.List;

public interface CarService {
    List<GetCarListResponse> getAll();
    GetCarResponse getById(int id);
    void add(AddCarRequest addCarRequest);
    void update(UpdateCarRequest updateCarRequest);
    void delete(int id);
}
