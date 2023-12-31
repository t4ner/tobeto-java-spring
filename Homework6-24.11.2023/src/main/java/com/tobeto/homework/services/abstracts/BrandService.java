package com.tobeto.homework.services.abstracts;

import com.tobeto.homework.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.homework.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.homework.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.homework.services.dtos.responses.brand.GetBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetBrandListResponse> getAll();
    GetBrandResponse getById(int id);
    void add(AddBrandRequest addBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
