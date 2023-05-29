package org.example.stations.StationsApp.DTO;


import java.sql.Timestamp;

/**
 * @author Levantosina
 */


public class stationDTO {



    private String nimi;
    private String namn;
    private String name;
    private String osoite;
    private String adress;
    private String kaupunki;
    private String stad;
    private String operaattor;
    private Integer kapasiteet;
    private Double x;
    private Double y;


    public stationDTO( String nimi, String namn, String name, String osoite, String adress, String kaupunki, String stad, String operaattor, Integer kapasiteet, Double x, Double y) {

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
