package com.example.lab5.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int countryId;

    @Column(name = "contry_name")
    private String countryName;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Regions regions;


}
