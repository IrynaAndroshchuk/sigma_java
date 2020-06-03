package com.sigmaproject.services;

import com.sigmaproject.domain.Employee;
import com.sigmaproject.domain.Organization;
import com.sigmaproject.repositories.EmployeeRepository;
import com.sigmaproject.repositories.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImplStreamAPI extends OrganizationServiceImpl {

    public OrganizationServiceImplStreamAPI(OrganizationRepository organizationRepository, EmployeeRepository employeeRepository) {
        super(organizationRepository, employeeRepository);
    }

    @Override
    public List<String> getCountriesList(String region, Integer numberOfDoctors) {
        List<Organization> organizations = organizationRepository.findAll();

        return organizations.stream()
                .filter(organization -> {
                    List<Employee> employees = employeeRepository.findByOrganizationId(organization.getId());

                    return numberOfDoctors > employees.size();
                })
                .filter(organization -> "Europe".equals(organization.getCountry()))
                .map(organization -> organization.getCountry())
                .sorted()
                .collect(Collectors.toList());
    }
}
