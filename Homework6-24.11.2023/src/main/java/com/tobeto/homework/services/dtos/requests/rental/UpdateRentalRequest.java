package com.tobeto.homework.services.dtos.requests.rental;

import com.tobeto.homework.entities.Car;
import com.tobeto.homework.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {

    private int id;
    private Car car;
    private User user;

}
