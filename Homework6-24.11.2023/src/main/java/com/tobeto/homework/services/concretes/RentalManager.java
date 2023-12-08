package com.tobeto.homework.services.concretes;

import com.tobeto.homework.entities.Rental;
import com.tobeto.homework.repositories.RentalRepository;
import com.tobeto.homework.services.abstracts.RentalService;
import com.tobeto.homework.services.dtos.requests.rental.AddRentalRequest;
import com.tobeto.homework.services.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.homework.services.dtos.responses.rental.GetRentalListResponse;
import com.tobeto.homework.services.dtos.responses.rental.GetRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class RentalManager implements RentalService {
    private final RentalRepository rentalRepository;
    @Override
    public List<GetRentalListResponse> getAll() {
        List<GetRentalListResponse> rentalListResponses = new ArrayList<GetRentalListResponse>();
        List<Rental> rentalList = rentalRepository.findAll();
        for (Rental rental: rentalList) {
            GetRentalListResponse rentalResponse = new GetRentalListResponse();
            rentalResponse.setId(rental.getId());
            rentalResponse.setCar(rental.getCar());
            rentalResponse.setUser(rental.getUser());
            rentalListResponses.add(rentalResponse);
        }
        return rentalListResponses;
    }

    @Override
    public GetRentalResponse getById(int id) {
        Rental rental = rentalRepository.findById(id).orElseThrow();
        GetRentalResponse dto = new GetRentalResponse();
        dto.setCar(rental.getCar());
        dto.setUser(rental.getUser());
        return dto;
    }

    @Override
    public void add(AddRentalRequest addRentalRequest) {
        Rental rental = new Rental();
        rental.setCar(addRentalRequest.getCar());
        rental.setUser(addRentalRequest.getUser());
        rentalRepository.save(rental);
    }

    @Override
    public void update(UpdateRentalRequest updateRentalRequest) {
        Rental rentalToUpdate = rentalRepository.findById(updateRentalRequest.getId()).orElseThrow();
        rentalToUpdate.setCar(updateRentalRequest.getCar());
        rentalToUpdate.setUser(updateRentalRequest.getUser());
        rentalRepository.save(rentalToUpdate);
    }

    @Override
    public void delete(int id) {
        rentalRepository.deleteById(id);
    }
}
