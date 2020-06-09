package com.sigmaproject.services;

import com.sigmaproject.domain.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee getEmployee(Long employeeId);

    List<Employee> findAll();

    public Employee create(Long organizationId, Employee employee);

    Employee update(Long id, Employee employee);

    public void delete(Long id);

    public void addOrganization(Long organizationId, Employee employee);
}
