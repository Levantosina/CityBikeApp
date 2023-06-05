package org.example.stations.StationsApp.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;


/**
 * @author Levantosina
 */
@Entity
@Table(name = "may")


public class Journey {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "departure_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departure;
    @Column(name = "return_time")
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

    private Integer duration;



    public Journey() {

    }

    public Journey(Integer id, Timestamp departure, Timestamp returnTime, Integer departureStationId, String departureStationName, Integer returnStationId, String returnStationName, Double coveredDistance, Integer duration) {
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


    public Journey( String departureStationName, String returnStationName, Double coveredDistance, Integer duration) {
        this.departureStationName = departureStationName;
        this.returnStationName = returnStationName;
        this.coveredDistance = coveredDistance;
        this.duration = duration;
    }

    public Journey(Date departure, Double coveredDistance, Integer duration) {
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

}
