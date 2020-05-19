package com.sigmaproject.repositories;

import com.sigmaproject.domain.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();

    Employee insert(Employee employee);

    Employee getOne(long employee);

    Employee update(Long id, Employee employee);

    void delete(Long id);
}
