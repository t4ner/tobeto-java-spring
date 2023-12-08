package com.tobeto.homework.controllers;


import com.tobeto.homework.entities.Location;
import com.tobeto.homework.repositories.LocationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/locations")
public class LocationsController {
    private final LocationRepository locationRepository;
    public LocationsController(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }
    @GetMapping
    public List<Location> getAll(){
        return locationRepository.findAll();
    }
    @GetMapping("{id}")
    public Location getById(@PathVariable  int id){
        return locationRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Location location){locationRepository.save(location);}

    @PutMapping
    public void update(@RequestBody Location location){
        Location locationToUpdate = locationRepository.findById(location.getId()).orElseThrow();
        locationToUpdate.setCity(location.getCity());
        locationRepository.save(locationToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        locationRepository.deleteById(id);
    }

}
