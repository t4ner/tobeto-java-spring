package com.tobeto.homework.services.dtos.requests.rentalDetail;

import com.tobeto.homework.entities.Employee;
import com.tobeto.homework.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalDetailRequest {

    private LocalDate startDate;
    private LocalDate endDate;
    private Location locationPickup;
    private Location locationDelivery;
    private Employee employee;

}
