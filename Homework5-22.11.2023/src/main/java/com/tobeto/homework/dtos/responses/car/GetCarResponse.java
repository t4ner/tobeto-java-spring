package com.tobeto.homework.dtos.responses.car;

import com.tobeto.homework.entities.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {

    private String plate;
    private double dailyPrice;
    private boolean state;
    private Model model;

}