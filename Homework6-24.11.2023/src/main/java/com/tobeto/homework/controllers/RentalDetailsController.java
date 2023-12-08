package com.tobeto.homework.controllers;

import com.tobeto.homework.services.abstracts.RentalDetailService;
import com.tobeto.homework.services.dtos.requests.rentalDetail.AddRentalDetailRequest;
import com.tobeto.homework.services.dtos.requests.rentalDetail.UpdateRentalDetailRequest;
import com.tobeto.homework.services.dtos.responses.rentalDetail.GetRentalDetailListResponse;
import com.tobeto.homework.services.dtos.responses.rentalDetail.GetRentalDetailResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("id/rentaldetails")
@AllArgsConstructor
public class RentalDetailsController {
    private final RentalDetailService rentalDetailService;

    @GetMapping
    public List<GetRentalDetailListResponse> getAll(){
        return rentalDetailService.getAll();
    }

    @GetMapping("{id}")
    public GetRentalDetailResponse getById(@PathVariable int id){
       return rentalDetailService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddRentalDetailRequest addRentalDetailRequest){
        rentalDetailService.add(addRentalDetailRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateRentalDetailRequest updateRentalDetailRequest){
        rentalDetailService.update(updateRentalDetailRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalDetailService.delete(id);
    }

}
