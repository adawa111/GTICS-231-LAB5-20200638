package com.example.lab5.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "departaments")
public class Departaments {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "departament_id")
    private int jobId;

    @Column(name = "departament_name",nullable = false)
    private String departamentName;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employees manager;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations location;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getDepartamentName() {
        return departamentName;
    }

    public void setDepartamentName(String departamentName) {
        this.departamentName = departamentName;
    }

    public Employees getManager() {
        return manager;
    }

    public void setManager(Employees manager) {
        this.manager = manager;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }
}
