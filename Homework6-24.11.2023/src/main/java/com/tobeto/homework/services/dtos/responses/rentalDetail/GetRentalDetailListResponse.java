package com.tobeto.homework.services.dtos.responses.rentalDetail;

import com.tobeto.homework.entities.Employee;
import com.tobeto.homework.entities.Location;
import com.tobeto.homework.entities.Rental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalDetailListResponse {

    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Rental rental;
    private Location locationPickup;
    private Location locationDelivery;
    private Employee employee;

}
