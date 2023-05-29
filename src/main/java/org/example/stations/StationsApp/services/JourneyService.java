package org.example.stations.StationsApp.services;


import org.example.stations.StationsApp.models.Journey;
import org.example.stations.StationsApp.repositories.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Provider;
import java.util.Date;

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
    public Page<Journey> getListOfStations(int pageNum, String sortField, String sortDir, String keyword) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNum - 1, PAGE_SIZE, sort);
        if(keyword!=null)
            return journeyRepository.search(keyword, pageable);
        else
            return journeyRepository.findALLSt(pageable);
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


//    public Page<Journey> findByKeyword(String keyword, int currentPage, String sortField, String sortDir) {
//        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
//        Pageable pageable = PageRequest.of(currentPage - 1, PAGE_SIZE, sort);
//        return journeyRepository.findByDepartureStationName(keyword, pageable);
//    }
//    public Page<Test> findstationMayByPage(int pageNumber) {
//        Pageable pageable = PageRequest.of(pageNumber - 1, PAGE_SIZE);
//        return stationsRepository.findStation(pageable);
//
//
//    }



}



//    public Page<? extends JourneySuperclass> getListOfStations(int pageNum, String sortField, String sortDir, String keyword) {
//        Sort sort = Sort.by(sortField).descending(); // Default sorting in descending order
//        if (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())) {
//            sort = Sort.by(sortField).ascending();
//        }
//        Pageable pageable = PageRequest.of(pageNum - 1, PAGE_SIZE, sort);
//
//        Page<Journey> page1 = journeyRepository.findALLSt(pageable);
//        Page<JourneyJ> page2 = journeyJJ.findALLStJ(pageable);
//
//        List<JourneySuperclass> combinedList = new ArrayList<>();
//        combinedList.addAll(page1.getContent());
//        combinedList.addAll(page2.getContent());
//
//        if (keyword != null && !keyword.isEmpty()) {
//            // Assuming search method is implemented in journeyRepository
//            return journeyRepository.search(keyword, pageable);
//        } else {
//            return new PageImpl<>(combinedList, pageable, combinedList.size());
//        }
//    }


