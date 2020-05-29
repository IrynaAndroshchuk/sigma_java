package com.sigmaproject.services;

import com.sigmaproject.domain.Employee;
import com.sigmaproject.domain.Organization;

import java.util.List;

public interface EmployeeService {
    Organization getEntry(long organizationId);

    List<Employee> findAll();

    Employee update(Long id, Employee employee);

}
