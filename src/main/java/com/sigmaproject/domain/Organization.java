package com.sigmaproject.domain;

import java.util.List;
import java.util.Objects;

public class Organization {
    private Long id;
    private String name;
    private String phoneNumber;
    private String address;
    private String region;
    private String country;
    private String city;
    private Boolean isActive;
    private String direction;
    private Integer numberOfOffices;
    private List<Employee> employees;

    public Organization(String name, String phoneNumber, String address, String region, String country, String city, Boolean isActive, String direction, Integer numberOfOffices) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.region = region;
        this.country = country;
        this.city = city;
        this.isActive = isActive;
        this.direction = direction;
        this.numberOfOffices = numberOfOffices;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getIsActivective() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getNumberOfOffices() {
        return numberOfOffices;
    }

    public void setNumberOfOffices(Integer numberOfOffices) {
        this.numberOfOffices = numberOfOffices;
    }

    public List<Employee> getEmployee() {
        return employees;
    }

    public void setEmployee(List<Employee> employee) {
        this.employees = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(address, that.address) &&
                Objects.equals(region, that.region) &&
                Objects.equals(country, that.country) &&
                Objects.equals(city, that.city) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(direction, that.direction) &&
                Objects.equals(numberOfOffices, that.numberOfOffices) &&
                Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, address, region, country, city, isActive, direction, numberOfOffices, employees);
    }
}
