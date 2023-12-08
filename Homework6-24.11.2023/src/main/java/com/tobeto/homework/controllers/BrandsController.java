package com.tobeto.homework.controllers;

import com.tobeto.homework.services.abstracts.BrandService;
import com.tobeto.homework.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.homework.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.homework.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.homework.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandService brandService;

    @GetMapping
    public List<GetBrandListResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddBrandRequest request){
        brandService.add(request);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        brandService.update(updateBrandRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        brandService.delete(id);
    }

 }
