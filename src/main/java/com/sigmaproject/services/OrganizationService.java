package com.sigmaproject.services;

import com.sigmaproject.domain.Employee;
import com.sigmaproject.domain.Organization;

import java.util.List;

public interface OrganizationService {
    Organization getOrganization(long organizationId);

    List<Organization> findAll();

    public void addEmployee(long organizationId, Employee employee);

    Organization update(Long id, Organization employee);

    public List<String> getCountriesList(String region, Integer numberOfDoctors);
}
