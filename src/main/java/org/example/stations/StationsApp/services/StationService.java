package org.example.stations.StationsApp.services;

import org.example.stations.StationsApp.models.Stations;
import org.example.stations.StationsApp.repositories.JourneyRepository;
import org.example.stations.StationsApp.repositories.StationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Levantosina
 */

@Service
@Transactional(readOnly = true)
public class StationService {
   private final StationRepository stationRepository;
    private static final int PAGE_SIZE = 30;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public Page<Stations> getStations(int pageNum,String sortField, String sortDir) {

        Sort sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortField).ascending():
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNum - 1, PAGE_SIZE,sort );

        return stationRepository.findAll(pageable);
    }
}
