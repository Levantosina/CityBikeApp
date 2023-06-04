package org.example.stations.StationsApp.services;


import org.example.stations.StationsApp.models.Journey;

import org.example.stations.StationsApp.repositories.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Levantosina
 */

@Service
@Transactional(readOnly = true)
public class JourneyService {

    private static final int PAGE_SIZE = 30;
    private static final int DEFAULT_PAGE = 1;

    private final JourneyRepository journeyRepository;


    public JourneyService(JourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;

    }


    private boolean isValidDirection(String dir) {
        return dir.equals("asc") || dir.equals("desc");
    }

    private boolean isValidField(String field) {
        return field.equals("id") || field.equals("departureStationName") || field.equals("returnStationName") ||
                field.equals("departure") || field.equals("returnTime");
    }



    public Page<Journey> getListOfStations(int pageNum, String sortField, String sortDir, String keyword) {

        //validate page number
        if(pageNum<0)
        {
            throw new IllegalArgumentException("Page number can not be less than 1");
        }


        //validate sort direction and sort field

        if(!isValidDirection(sortDir))
        {
            throw new IllegalArgumentException("Sort direction is invalid");
        }

        if(!isValidField(sortField))
        {
            throw new IllegalArgumentException("Sort field is invalid");
        }


        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNum - 1, PAGE_SIZE, sort);
        if(keyword==null||keyword.isEmpty())
            return journeyRepository.findAllJouney(pageable);
        else
            return journeyRepository.search(keyword, pageable);
    }

    public Page<Journey> findTest(String id) {
        Pageable pageable = PageRequest.of(DEFAULT_PAGE, PAGE_SIZE);
        return journeyRepository.oneTest(id,pageable);
    }
    public Page<Journey> findOneStation(int pageNum) {
        Pageable pageable = PageRequest.of(pageNum - 1, PAGE_SIZE);
        return journeyRepository.findDistinctDepartureStationName(pageable);
    }
    @Transactional
    public void deleteJourneyById( String departureStationName) {
        journeyRepository.deleteByDepartureStationName(departureStationName);
    }
    @Transactional
    public void addJourney(Journey journey) {
        // Set the departure and return time automatically
        journey.setDeparture(new Date());
        journey.setReturnTime(new Date());

        // Assign IDs based on the station names
        String departureStationName = journey.getDepartureStationName();
        String returnStationName = journey.getReturnStationName();

        // Retrieve the corresponding station IDs
        Integer departureStationId = journeyRepository.findStationIdByDepartureStationName(departureStationName);
        Integer returnStationId = journeyRepository.findStationIdByDepartureStationName(returnStationName);

        // Set the station IDs
        journey.setDepartureStationId(departureStationId);
        journey.setReturnStationId(returnStationId);

        // Save the journey
        journeyRepository.save(journey);
    }

    public List<Journey> getMostPopularDepartureStations() {
        List<Journey> popularDepartureStations = journeyRepository.findMostPopularDepartureStation(PageRequest.of(0, 5));
        return popularDepartureStations;
    }



}






