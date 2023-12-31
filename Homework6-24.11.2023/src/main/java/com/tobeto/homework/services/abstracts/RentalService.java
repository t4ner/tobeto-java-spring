package com.tobeto.homework.services.abstracts;

import com.tobeto.homework.services.dtos.requests.rental.AddRentalRequest;
import com.tobeto.homework.services.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.homework.services.dtos.responses.rental.GetRentalListResponse;
import com.tobeto.homework.services.dtos.responses.rental.GetRentalResponse;

import java.util.List;

public interface RentalService {
    List<GetRentalListResponse> getAll();
    GetRentalResponse getById(int id);
    void add(AddRentalRequest addRentalRequest);
    void update(UpdateRentalRequest updateRentalRequest);
    void delete(int id);
}
