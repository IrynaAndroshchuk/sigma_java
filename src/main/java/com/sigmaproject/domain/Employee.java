package com.sigmaproject.domain;

import java.util.Objects;

public class Employee {
    private Long id;
    private String name;
    private String surname;
    private String position;
    private Boolean isMarried;
    //    experience in month
    private Integer experience;

    public Employee(String name, String surname, Boolean isMarried, Integer experience, String position) {
        this.name = name;
        this.surname = surname;
        this.isMarried = isMarried;
        this.experience = experience;
        this.position = position;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(Boolean married) {
        isMarried = married;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(surname, employee.surname) &&
                Objects.equals(isMarried, employee.isMarried) &&
                Objects.equals(experience, employee.experience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, isMarried, experience);
    }
}
