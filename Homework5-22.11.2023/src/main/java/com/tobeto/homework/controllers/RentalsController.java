package com.tobeto.homework.controllers;

import com.tobeto.homework.dtos.requests.rental.AddRentalRequest;
import com.tobeto.homework.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.homework.dtos.responses.rental.GetRentalListResponse;
import com.tobeto.homework.dtos.responses.rental.GetRentalResponse;
import com.tobeto.homework.entities.Rental;

import com.tobeto.homework.repositories.RentalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {
    private final RentalRepository rentalRepository;
    public RentalsController(RentalRepository rentalRepository){
        this.rentalRepository = rentalRepository;
    }

    @GetMapping
    public List<GetRentalListResponse> getAll(){
        List<GetRentalListResponse> rentalListResponses = new ArrayList<GetRentalListResponse>();
        List<Rental> rentalList = rentalRepository.findAll();
        for (Rental rental: rentalList) {
            GetRentalListResponse rentalResponse = new GetRentalListResponse();
            rentalResponse.setId(rental.getId());
            rentalResponse.setCar(rental.getCar());
            rentalResponse.setUser(rental.getUser());
            rentalListResponses.add(rentalResponse);
        }
        return rentalListResponses;
    }

    @GetMapping("{id}")
    public GetRentalResponse getById(@PathVariable int id){
        Rental rental = rentalRepository.findById(id).orElseThrow();
        GetRentalResponse dto = new GetRentalResponse();
        dto.setCar(rental.getCar());
        dto.setUser(rental.getUser());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddRentalRequest addRentalRequest){
        Rental rental = new Rental();
        rental.setCar(addRentalRequest.getCar());
        rental.setUser(addRentalRequest.getUser());
        rentalRepository.save(rental);
    }

    @PutMapping
    public void update(@RequestBody UpdateRentalRequest updateRentalRequest){
        Rental rentalToUpdate = rentalRepository.findById(updateRentalRequest.getId()).orElseThrow();
        rentalToUpdate.setCar(updateRentalRequest.getCar());
        rentalToUpdate.setUser(updateRentalRequest.getUser());
        rentalRepository.save(rentalToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalRepository.deleteById(id);
    }

}
