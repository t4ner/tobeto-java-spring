package com.tobeto.homework.controllers;

import com.tobeto.homework.dtos.requests.brand.AddBrandRequest;
import com.tobeto.homework.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.homework.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.homework.dtos.responses.brand.GetBrandResponse;
import com.tobeto.homework.entities.Brand;
import com.tobeto.homework.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/brands")
public class BrandsController {
    //Dependency => Bağımlılık
    //Injection => Enjekte

    private final BrandRepository brandRepository;
    //final => ctor blok dışında set edemezsiniz.
    public BrandsController(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<GetBrandListResponse> getAll(){
        List<Brand> brandList = brandRepository.findAll();
        List<GetBrandListResponse> brandListResponses = new ArrayList<GetBrandListResponse>();
        for (Brand brand: brandList) {
            GetBrandListResponse brandResponse = new GetBrandListResponse();
            brandResponse.setId(brand.getId());
            brandResponse.setName(brand.getName());
            brandListResponses.add(brandResponse);
        }
        return brandListResponses;
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id){
        //Optionel<T> =>ilgili filtreden bir veri dönmeyebilir.
        Brand brand = brandRepository.findById(id).orElseThrow();
        GetBrandResponse dto = new GetBrandResponse();
        dto.setName(brand.getName());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddBrandRequest request){
        Brand brand = new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        Brand brandToUpdate = brandRepository.findById(updateBrandRequest.getId()).orElseThrow();
        brandToUpdate.setName(updateBrandRequest.getName());
        brandRepository.save(brandToUpdate);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        brandRepository.deleteById(id);
    }

 }
