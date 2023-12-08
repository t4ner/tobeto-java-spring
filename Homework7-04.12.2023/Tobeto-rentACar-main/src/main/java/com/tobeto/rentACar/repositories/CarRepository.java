package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.services.dtos.responses.car.GetByCarListResponse;
import com.tobeto.rentACar.services.dtos.responses.car.GetCarListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    boolean existsByPlate(String plate);


    @Query("SELECT new com.tobeto.rentACar.services.dtos.responses.car.GetByCarListResponse(c.id, c.plate, c.dailyPrice, " +
            "c.state, new com.tobeto.rentACar.services.dtos.responses.model.GetModelListResponse(m.name, m.id, m.year, " +
            "new com.tobeto.rentACar.services.dtos.responses.brand.GetBrandResponse(b.name))) FROM Car c " +
            "INNER JOIN c.model m INNER JOIN m.brand b")
    List<GetByCarListResponse> getAll();


    List<Car> findCarByDailyPriceBetween(Double min, Double max);

    List<Car> findByStateTrue();


    @Query("SELECT new com.tobeto.rentACar.services.dtos.responses.car.GetByCarListResponse(c.id, c.plate," +
            "c.dailyPrice, c.state, new com.tobeto.rentACar.services.dtos.responses.model.GetByModel" +
            "Response(c.model.name, new com.tobeto.rentACar.services.dtos.responses.brand.GetBrand" +
            "Response(c.model.brand.name))) FROM Car c WHERE c.state=:state")
    List<GetByCarListResponse> getCarByState(boolean state);


}
