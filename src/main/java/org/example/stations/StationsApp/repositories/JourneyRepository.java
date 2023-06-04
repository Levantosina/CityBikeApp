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




    @Query(value = "SELECT new org.example.stations.StationsApp.models.Journey(j.departureStationName,j.returnStationName,j.coveredDistance,j.duration) from Journey j",nativeQuery = false)
    Page<Journey> findAllJouney(Pageable pageable);
    @Query(value = "select distinct new org.example.stations.StationsApp.models.Journey (j.departureStationName)  from Journey j",nativeQuery = false)
    Page<Journey> findDistinctDepartureStationName(Pageable pageable);


    @Query(value = "SELECT  new org.example.stations.StationsApp.models.Journey (j.departure,j.coveredDistance,j.duration) FROM Journey j  where j.departureStationName = ?1 ",nativeQuery = false)
    Page<Journey> oneTest(String departureStationId,Pageable pageable);


    @Query(value="SELECT t FROM Journey t  where t.departureStationName  LIKE %?1% ", nativeQuery = false)
    Page <Journey>search(@Param("keyword") String keyword, Pageable pageable);

    @Modifying
    @Query("DELETE FROM Journey j WHERE j.departureStationName = :departureStationName")
    void deleteByDepartureStationName(@Param("departureStationName") String departureStationName);


    @Query("SELECT j.returnStationId FROM Journey j WHERE j.returnStationName = :stationName")
    Integer findStationIdByDepartureStationName(@Param("stationName") String stationName);

    @Query(value = "SELECT new org.example.stations.StationsApp.models.Journey(j.departureStationName) FROM Journey j GROUP BY j.departureStationName ORDER BY COUNT(j.departureStationName)desc ",nativeQuery = false)
    List<Journey> findMostPopularDepartureStation(Pageable pageable);


}






