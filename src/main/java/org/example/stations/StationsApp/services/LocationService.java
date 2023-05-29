package org.example.stations.StationsApp.services;

import org.example.stations.StationsApp.models.Stations;
import org.example.stations.StationsApp.repositories.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Levantosina
 */
@Service
@Transactional(readOnly = true)
public class LocationService {

    private static LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Stations>getLocations(){
        return locationRepository.getAllLoc();
    }
}
