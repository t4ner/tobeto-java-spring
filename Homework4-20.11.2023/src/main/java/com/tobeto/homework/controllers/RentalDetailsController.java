package com.tobeto.homework.controllers;

import com.tobeto.homework.entities.RentalDetail;
import com.tobeto.homework.repositories.RentalDetailRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("id/rentaldetails")
public class RentalDetailsController {
    private final RentalDetailRepository rentalDetailRepository;
    public RentalDetailsController(RentalDetailRepository rentalDetailRepository){
        this.rentalDetailRepository = rentalDetailRepository;
    }

    @GetMapping
    public List<RentalDetail> getAll(){
        return rentalDetailRepository.findAll();
    }

    @GetMapping("{id}")
    public RentalDetail getById(@PathVariable int id){
        return rentalDetailRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody RentalDetail rentalDetail){
         rentalDetailRepository.save(rentalDetail);
    }

    @PutMapping
    public void update(@RequestBody RentalDetail rentalDetail){
        RentalDetail rentalDetailToUpdate = rentalDetailRepository.findById(rentalDetail.getId()).orElseThrow();
        rentalDetailToUpdate.setEndDate(rentalDetail.getEndDate());
        rentalDetailRepository.save(rentalDetailToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalDetailRepository.deleteById(id);
    }
}
