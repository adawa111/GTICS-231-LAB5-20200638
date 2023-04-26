package com.example.lab5.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "regions")
public class Regions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private int regionId;

    @Column(name = "region_name")
    private String regionName;

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
