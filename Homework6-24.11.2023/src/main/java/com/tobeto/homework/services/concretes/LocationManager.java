package com.tobeto.homework.services.concretes;

import com.tobeto.homework.entities.Location;
import com.tobeto.homework.repositories.LocationRepository;
import com.tobeto.homework.services.abstracts.LocationService;
import com.tobeto.homework.services.dtos.requests.location.AddLocationRequest;
import com.tobeto.homework.services.dtos.requests.location.UpdateLocationRequest;
import com.tobeto.homework.services.dtos.responses.location.GetLocationListResponse;
import com.tobeto.homework.services.dtos.responses.location.GetLocationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class LocationManager implements LocationService {
    private final LocationRepository locationRepository;
    @Override
    public List<GetLocationListResponse> getAll() {
        List<Location> locationList = locationRepository.findAll();
        List<GetLocationListResponse> locationListResponses = new ArrayList<GetLocationListResponse>();
        for (Location location: locationList) {
            GetLocationListResponse locationResponse = new GetLocationListResponse();
            locationResponse.setId(location.getId());
            locationResponse.setCity(location.getCity());
            locationResponse.setBranchOffice(location.getBranchOffice());
            locationResponse.setOfficePhone(location.getOfficePhone());
            locationListResponses.add(locationResponse);
        }
        return locationListResponses;
    }

    @Override
    public GetLocationResponse getById(int id) {
        Location location = locationRepository.findById(id).orElseThrow();
        GetLocationResponse dto = new GetLocationResponse();
        dto.setCity(location.getCity());
        dto.setBranchOffice(location.getBranchOffice());
        dto.setOfficePhone(location.getOfficePhone());
        return dto;
    }

    @Override
    public void add(AddLocationRequest addLocationRequest) {
        Location location = new Location();
        location.setCity(addLocationRequest.getCity());
        location.setBranchOffice(addLocationRequest.getBranchOffice());
        location.setOfficePhone(addLocationRequest.getOfficePhone());
        locationRepository.save(location);
    }

    @Override
    public void update(UpdateLocationRequest updateLocationRequest) {
        Location locationToUpdate = locationRepository.findById(updateLocationRequest.getId()).orElseThrow();
        locationToUpdate.setCity(updateLocationRequest.getCity());
        locationToUpdate.setBranchOffice(updateLocationRequest.getBranchOffice());
        locationToUpdate.setOfficePhone(updateLocationRequest.getOfficePhone());
        locationRepository.save(locationToUpdate);
    }

    @Override
    public void delete(int id) {
        locationRepository.deleteById(id);
    }
}
