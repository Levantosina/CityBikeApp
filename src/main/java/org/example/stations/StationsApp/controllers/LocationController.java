package org.example.stations.StationsApp.controllers;

import org.example.stations.StationsApp.models.Stations;
import org.example.stations.StationsApp.services.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Levantosina
 */

@Controller
@RequestMapping("/markers")
public class LocationController {

    private final LocationService locationService;


    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Stations > getAllMarkers() {
        return locationService.getLocations();
    }
}
