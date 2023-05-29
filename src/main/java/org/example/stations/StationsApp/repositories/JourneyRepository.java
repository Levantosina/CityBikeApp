package org.example.stations.StationsApp.repositories;


import org.example.stations.StationsApp.models.Journey;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Levantosina
 */
@Repository
public interface JourneyRepository extends JpaRepository<Journey, Integer> {


//    @Query(value = "SELECT j.id, j.departure, j.return, j.departure_station_id, j.departure_station_name,\n" +
//            "       j.return_station_id, j.return_station_name, j.covered_distance, j.duration\n" +
//            "FROM june2021 j where duration>10\n" +
//            "UNION ALL\n" +
//            "SELECT m.id, m.departure, m.return, m.departure_station_id, m.departure_station_name,\n" +
//            "       m.return_station_id, m.return_station_name, m.covered_distance, m.duration\n" +
//            "FROM may2021 m where duration>10", nativeQuery = true)
//    Page<Test> findStation(Pageable pageable);


    @Query(value = "SELECT NEW org.example.stations.StationsApp.models.Journey(j.departureStationName, j.returnStationName, j.coveredDistance, j.duration) FROM Journey j ",nativeQuery = false)
    Page<Journey> findALLSt(Pageable pageable);

    @Query(value = "select distinct new org.example.stations.StationsApp.models.Journey (j.departureStationName)  from Journey j",nativeQuery = false)
    Page<Journey> findDistinctDepartureStationName(Pageable pageable);


    @Query(value = "SELECT  new org.example.stations.StationsApp.models.Journey (j.departure,j.coveredDistance,j.duration) FROM Journey j  where j.departureStationName = ?1 ",nativeQuery = false)
    Page<Journey> oneTest(String departureStationId,Pageable pageable);


    @Query(value="SELECT t FROM Journey t  where t.departureStationName  LIKE %?1% ", nativeQuery = false)
    Page <Journey>search(String keyword, Pageable pageable);

    @Modifying
    @Query("DELETE FROM Journey j WHERE j.departureStationName = :departureStationName")
    void deleteByDepartureStationName(@Param("departureStationName") String departureStationName);


    // JourneyRepository.java

    @Query("SELECT j.returnStationId FROM Journey j WHERE j.returnStationName = :stationName")
    Integer findStationIdByDepartureStationName(@Param("stationName") String stationName);

}





