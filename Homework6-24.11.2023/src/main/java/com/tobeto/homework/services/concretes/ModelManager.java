package com.tobeto.homework.services.concretes;

import com.tobeto.homework.entities.Model;
import com.tobeto.homework.repositories.ModelRepository;
import com.tobeto.homework.services.abstracts.ModelService;
import com.tobeto.homework.services.dtos.requests.model.AddModelRequest;
import com.tobeto.homework.services.dtos.requests.model.UpdateModelRequest;
import com.tobeto.homework.services.dtos.responses.model.GetModelListResponse;
import com.tobeto.homework.services.dtos.responses.model.GetModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class ModelManager implements ModelService {
    private final ModelRepository modelRepository;
    @Override
    public List<GetModelListResponse> getAll() {
        List<Model> modelList = modelRepository.findAll();
        List<GetModelListResponse> modelListResponses = new ArrayList<GetModelListResponse>();
        for (Model model: modelList) {
            GetModelListResponse modelResponse = new GetModelListResponse();
            modelResponse.setId(model.getId());
            modelResponse.setName(model.getName());
            modelResponse.setYear(model.getYear());
            modelResponse.setBrand(model.getBrand());
            modelListResponses.add(modelResponse);
        }
        return modelListResponses;
    }

    @Override
    public GetModelResponse getById(int id) {
        Model model = modelRepository.findById(id).orElseThrow();
        GetModelResponse dto = new GetModelResponse();
        dto.setName(model.getName());
        dto.setYear(model.getYear());
        dto.setBrand(model.getBrand());
        return dto;
    }

    @Override
    public void add(AddModelRequest addModelRequest) {
        Model model = new Model();
        model.setName(addModelRequest.getName());
        model.setYear(addModelRequest.getYear());
        model.setBrand(addModelRequest.getBrand());
        modelRepository.save(model);
    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {
        Model modelToUpdate = modelRepository.findById(updateModelRequest.getId()).orElseThrow();
        modelToUpdate.setName(updateModelRequest.getName());
        modelToUpdate.setBrand(updateModelRequest.getBrand());
        modelToUpdate.setYear(updateModelRequest.getYear());
        //modelToUpdate.setCars(updateModelRequest.getCars());
        modelRepository.save(modelToUpdate);
    }

    @Override
    public void delete(int id) {
        modelRepository.deleteById(id);
    }
}
