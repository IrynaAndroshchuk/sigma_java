package com.sigmaproject.services;

import com.sigmaproject.domain.Employee;
import com.sigmaproject.domain.Organization;
import com.sigmaproject.repositories.EmployeeRepository;
import com.sigmaproject.repositories.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    protected final OrganizationRepository organizationRepository;
    protected final EmployeeRepository employeeRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository, EmployeeRepository employeeRepository) {
        this.organizationRepository = organizationRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Organization getOrganization(long organizationId) {
        Organization organization = organizationRepository.getOne(organizationId);

        List<Employee> employees = employeeRepository.findByOrganization(organizationId);

        organization.setEmployee(employees);

        return organization;
    }

    @Override
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }

    @Override
    public void addEmployee(long organizationId, Employee employee) {
        organizationRepository.getOne(organizationId);
        employeeRepository.addOrganization(organizationId, employee);
    }

    @Override
    public Organization update(Long id, Organization organization) {
        return organizationRepository.update(id, organization);
    }

    @Override
    public List<String> getCountriesList(String region, Integer numberOfDoctors) {
        return organizationRepository.getCountriesList(region, numberOfDoctors);
    }
}
