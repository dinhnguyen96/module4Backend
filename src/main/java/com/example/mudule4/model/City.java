package com.example.mudule4.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
public class City implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String cityName;

    private Country country;

    private double cityArea;

    private double cityPopulation;

    private double cityGDP;

    private String cityDescribe;


    public City()
    {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id", unique = true, nullable = false)
    public Long getId()
    {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "cityName")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @ManyToOne
    @JoinColumn(name = "countryID", nullable = false)
    public Country getCountry() {
        return country;
    }


    public void setCountry(Country country) {
        this.country = country;
    }

    @Column(name = "cityArea")
    public double getCityArea() {
        return cityArea;
    }

    public void setCityArea(double cityArea) {
        this.cityArea = cityArea;
    }

    @Column(name = "cityPopulation")
    public double getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(double cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    @Column(name="cityGDP")
    public double getCityGDP() {
        return cityGDP;
    }

    public void setCityGDP(double cityGDP) {
        this.cityGDP = cityGDP;
    }

    @Column(name="cityDescribe")
    public String getCityDescribe() {
        return cityDescribe;
    }

    public void setCityDescribe(String cityDescribe) {
        this.cityDescribe = cityDescribe;
    }
}
