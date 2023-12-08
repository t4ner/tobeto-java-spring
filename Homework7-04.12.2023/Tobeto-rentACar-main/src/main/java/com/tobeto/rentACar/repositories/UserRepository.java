package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.User;
import com.tobeto.rentACar.services.dtos.responses.user.GetByUserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByEmail(String email);

    List<User> findByPhoneIsNotNull();


    List<User> findByPhoneIsNull();


    @Query("SELECT new com.tobeto.rentACar.services.dtos.responses.user.GetByUserResponse(u.firstName," +
            "u.lastName, new com.tobeto.rentACar.services.dtos.responses.car.GetByCarResponse(c.plate)) FROM " +
            "Rental r INNER JOIN r.user u INNER JOIN r.car c WHERE r.car.id=:carId")
    List<GetByUserResponse> getUserByCar(int carId);


    @Query("SELECT new com.tobeto.rentACar.services.dtos.responses.user.GetByUserResponse(u.firstName," +
            "u.lastName, new com.tobeto.rentACar.services.dtos.responses.car.GetByCarResponse(c.plate))" +
            " FROM Rental r INNER JOIN r.car c INNER JOIN r.user u WHERE c.state=:state")
    List<GetByUserResponse> getUserByState(boolean state);


}
