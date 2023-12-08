package com.tobeto.homework.dtos.requests.model;

import com.tobeto.homework.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelRequest {

    private int id;
    private String name;
    private int year;
    private Brand brand;
}