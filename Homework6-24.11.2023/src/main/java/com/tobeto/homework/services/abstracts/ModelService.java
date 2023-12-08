package com.tobeto.homework.services.abstracts;

import com.tobeto.homework.services.dtos.requests.model.AddModelRequest;
import com.tobeto.homework.services.dtos.requests.model.UpdateModelRequest;
import com.tobeto.homework.services.dtos.responses.model.GetModelListResponse;
import com.tobeto.homework.services.dtos.responses.model.GetModelResponse;

import java.util.List;

public interface ModelService {
    List<GetModelListResponse> getAll();
    GetModelResponse getById(int id);
    void add(AddModelRequest addModelRequest);
    void update(UpdateModelRequest updateModelRequest);
    void delete(int id);
}
