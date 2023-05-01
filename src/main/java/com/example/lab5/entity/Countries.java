package com.example.lab5.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private String countryId;

    @Column(name = "country_name")
    private String countryName;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Regions regions;

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Regions getRegions() {
        return regions;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
    }
}
