package org.example.stations.StationsApp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Levantosina
 */

@Entity
@Table(name = "stations")
public class Stations   {


    @Id
    @Column(name = "FID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fid;
    @Column(name = "id")
    private Integer id ;
    @Column(name = "nimi")
    private String  nimi ;
    @Column(name = "namn")
    private String  namn ;
    @Column(name = "name")
    private String  name ;
    @Column(name = "osoite")
    private String  osoite;
    @Column(name = "adress")
    private String adress ;
    @Column(name = "kaupunki")
    private String kaupunki;
    @Column(name = "stad")
    private String stad;
    @Column(name = "operaattor")
    private String operaattor ;
    @Column(name = "kapasiteet")
    private Integer kapasiteet;
    @Column(name = "x")
    private Double  x ;
    @Column(name = "y")
    private Double y ;




    public Stations() {

    }


//    @OneToMany(mappedBy = "departureStation", cascade = CascadeType.ALL)
//    private List<Journey> departureJourneys;
//
//    public Stations(List<Journey> departureJourneys) {
//        this.departureJourneys = departureJourneys;
//    }
//
//    public List<Journey> getDepartureJourneys() {
//        return departureJourneys;
//    }
//
//    public void setDepartureJourneys(List<Journey> departureJourneys) {
//        this.departureJourneys = departureJourneys;
//    }

    public Stations(Integer fid, String name, Double x, Double y) {
        this.fid = fid;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public Stations(Integer fid, Integer id, String nimi, String namn, String name, String osoite, String adress, String kaupunki, String stad, String operaattor, Integer kapasiteet, Double x, Double y) {
        this.fid = fid;
        this.id = id;
        this.nimi = nimi;
        this.namn = namn;
        this.name = name;
        this.osoite = osoite;
        this.adress = adress;
        this.kaupunki = kaupunki;
        this.stad = stad;
        this.operaattor = operaattor;
        this.kapasiteet = kapasiteet;
        this.x = x;
        this.y = y;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOsoite() {
        return osoite;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getKaupunki() {
        return kaupunki;
    }

    public void setKaupunki(String kaupunki) {
        this.kaupunki = kaupunki;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getOperaattor() {
        return operaattor;
    }

    public void setOperaattor(String operaattor) {
        this.operaattor = operaattor;
    }

    public Integer getKapasiteet() {
        return kapasiteet;
    }

    public void setKapasiteet(Integer kapasiteet) {
        this.kapasiteet = kapasiteet;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
}
