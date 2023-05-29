package org.example.stations.StationsApp.repositories;

import org.example.stations.StationsApp.models.Stations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Levantosina
 */
public interface StationRepository  extends JpaRepository<Stations, Integer>{

    Page<Stations> findAll(Pageable pageable);
}
