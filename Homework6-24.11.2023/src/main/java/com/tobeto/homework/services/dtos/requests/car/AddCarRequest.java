package com.tobeto.homework.services.dtos.requests.car;

import com.tobeto.homework.entities.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {

    private String plate;
    private double dailyPrice;
    private boolean state;
    private Model model;

}