package com.tobeto.homework.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "branch_office")
    private String branchOffice;

    @Column(name = "office_phone")
    private String officePhone;

    @OneToMany(mappedBy = "locationPickup")
    @JsonIgnore
    private List<RentalDetail> rentalDetailsLocationPickup;

    @OneToMany(mappedBy = "locationDelivery")
    @JsonIgnore
    private List<RentalDetail> rentalDetailsLocationDelivery;

    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private List<Employee> employees;

}
