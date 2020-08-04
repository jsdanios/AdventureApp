package com.tts.AdventureApp.controller;

import com.tts.AdventureApp.model.Location;
import com.tts.AdventureApp.model.LocationRequest;
import com.tts.AdventureApp.service.AdventureLocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdventureLocationController {
    @Autowired
    private AdventureLocationService adventureLocationService;

    @PostMapping(value={"/map"})
    public Location getLocationForMap(LocationRequest request) {
        Location startingLocation = adventureLocationService.getCoordinates(request.getAddress() + " " + request.getCity() + " " + request.getState());
        return startingLocation;
    }
    
}