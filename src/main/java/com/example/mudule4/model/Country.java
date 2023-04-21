package com.example.mudule4.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
public class Country implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String countryCode;

    private String countryName;

    private List<City> cityList;

    public Country()
    {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    public Long getId()
    {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Column(name = "countryName")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @OneToMany(mappedBy = "country")
    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
