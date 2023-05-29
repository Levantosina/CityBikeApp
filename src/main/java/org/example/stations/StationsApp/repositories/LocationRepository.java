package org.example.stations.StationsApp.repositories;

import org.example.stations.StationsApp.models.Stations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Levantosina
 */
@Repository
public interface LocationRepository extends JpaRepository<Stations,Integer> {

    @Query(value = "SELECT NEW org.example.stations.StationsApp.models.Stations(l.fid,l.name,l.x,l.y) FROM Stations l ",nativeQuery = false)
    List<Stations>getAllLoc();
}
