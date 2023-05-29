package org.example.stations.StationsApp.DTO;

import org.example.stations.StationsApp.models.Journey;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Levantosina
 */
public class JourneyDTO {

    private Timestamp departure;
    private Timestamp returnTime;

    private String departureStationName;
    private Integer returnStationId;
    private String returnStationName;
    private Double coveredDistance;
    private Long duration;

    public JourneyDTO(Timestamp departure, Timestamp returnTime, String departureStationName, Integer returnStationId, String returnStationName, Double coveredDistance, Long duration) {

        this.departure = departure;
        this.returnTime = returnTime;
        this.departureStationName = departureStationName;
        this.returnStationId = returnStationId;
        this.returnStationName = returnStationName;
        this.coveredDistance = coveredDistance;
        this.duration = duration;
    }

    public JourneyDTO() {

    }




    public Timestamp getDeparture() {
        return departure;
    }

    public void setDeparture(Timestamp departure) {
        this.departure = departure;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public String getDepartureStationName() {
        return departureStationName;
    }

    public void setDepartureStationName(String departureStationName) {
        this.departureStationName = departureStationName;
    }

    public Integer getReturnStationId() {
        return returnStationId;
    }

    public void setReturnStationId(Integer returnStationId) {
        this.returnStationId = returnStationId;
    }

    public String getReturnStationName() {
        return returnStationName;
    }

    public void setReturnStationName(String returnStationName) {
        this.returnStationName = returnStationName;
    }

    public Double getCoveredDistance() {
        return coveredDistance;
    }

    public void setCoveredDistance(Double coveredDistance) {
        this.coveredDistance = coveredDistance;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
