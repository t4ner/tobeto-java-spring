package com.tobeto.homework.dtos.responses.employee;

import com.tobeto.homework.entities.Location;
import com.tobeto.homework.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeListResponse {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private LocalDate birthDate;
    private String gender;
    private String identificationNumber;
    private Location location;
    private Role role;

}
