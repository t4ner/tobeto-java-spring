package com.tobeto.homework.dtos.responses.rental;

import com.tobeto.homework.entities.Car;
import com.tobeto.homework.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalResponse {

    private Car car;
    private User user;

}
