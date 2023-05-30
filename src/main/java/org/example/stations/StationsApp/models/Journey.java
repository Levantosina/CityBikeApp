package org.example.stations.StationsApp.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Levantosina
 */
@Entity
@Table(name = "may")
//@SequenceGenerator(name="seq")

public class Journey {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "departure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departure;

    @Column(name = "return")
   @Temporal(TemporalType.TIMESTAMP)
    private Date returnTime;

    @Column(name = "departure_station_id")
    private Integer departureStationId;
    @Column(name = "departure_station_name")
    private String departureStationName;
    @Column(name = "return_station_id")
    private Integer returnStationId;
    @Column(name = "return_station_name")
    private String returnStationName;


    @Column(name = "covered_distance")
    private Double coveredDistance;

    @Column(name = "duration")
    private Long duration;



    public Journey() {

    }

    public Journey(Integer id, Timestamp departure, Timestamp returnTime, Integer departureStationId, String departureStationName, Integer returnStationId, String returnStationName, Double coveredDistance, Long duration) {
        this.id = id;
        this.departure = departure;
        this.returnTime = returnTime;
        this.departureStationId = departureStationId;
        this.departureStationName = departureStationName;
        this.returnStationId = returnStationId;
        this.returnStationName = returnStationName;
        this.coveredDistance = coveredDistance;
        this.duration = duration;
    }


    public Journey( String departureStationName, String returnStationName, Double coveredDistance, Long duration) {
        this.departureStationName = departureStationName;
        this.returnStationName = returnStationName;
        this.coveredDistance = coveredDistance;
        this.duration = duration;
    }

    public Journey(Date departure, Double coveredDistance, Long duration) {
        this.departure = departure;
        this.coveredDistance = coveredDistance;
        this.duration = duration;
    }

    public Journey(String departureStationName) {
        this.departureStationName = departureStationName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Integer getDepartureStationId() {
        return departureStationId;
    }

    public void setDepartureStationId(Integer departureStationId) {
        this.departureStationId = departureStationId;
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
