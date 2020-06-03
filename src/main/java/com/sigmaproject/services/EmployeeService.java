package com.sigmaproject.services;

import com.sigmaproject.domain.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee getEmployee(Long employeeId);

    List<Employee> findAll();

    Employee update(Long id, Employee employee);
}
