package com.tobeto.homework.controllers;

import com.tobeto.homework.services.abstracts.RentalService;
import com.tobeto.homework.services.dtos.requests.rental.AddRentalRequest;
import com.tobeto.homework.services.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.homework.services.dtos.responses.rental.GetRentalListResponse;
import com.tobeto.homework.services.dtos.responses.rental.GetRentalResponse;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
@AllArgsConstructor
public class RentalsController {

   private final RentalService rentalService;

    @GetMapping
    public List<GetRentalListResponse> getAll(){
        return rentalService.getAll();
    }

    @GetMapping("{id}")
    public GetRentalResponse getById(@PathVariable int id){
        return rentalService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddRentalRequest addRentalRequest){
        rentalService.add(addRentalRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateRentalRequest updateRentalRequest){
       rentalService.update(updateRentalRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalService.delete(id);
    }

}
