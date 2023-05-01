package com.example.lab5.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private int employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hire_date", nullable = false)
    private String hireDate;

    @Column(name = "salary")
    private double salary;

    @Column(name = "commission_pct", nullable = true)
    private Double commissionPct;

    @Column(name = "enabled")
    private int enabled;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs job;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = true)
    private Employees manager;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departaments departmentId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public Double getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(Double commissionPct) {
        this.commissionPct = commissionPct;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }

    public Employees getManager() {
        return manager;
    }

    public void setManager(Employees manager) {
        this.manager = manager;
    }

    public Departaments getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Departaments departmentId) {
        this.departmentId = departmentId;
    }
}

