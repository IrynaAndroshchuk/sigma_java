package com.sigmaproject.services;

import com.sigmaproject.domain.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee getEmployee(Long employeeId);

    List<Employee> findAll();

    public Employee create(Employee employee);

    Employee update(Long id, Employee employee);

    public void delete(Long id);
}
