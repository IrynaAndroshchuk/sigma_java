package com.sigmaproject.repositories;

import com.sigmaproject.domain.Employee;

        import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();

    List<Employee> findByOrganization(long organizationId);

    Employee insert(Employee employee);

    Employee getOne(long employee);

    Employee update(Long id, Employee employee);

    public void delete(Long id);

    public void addOrganization(long organizationId, Employee employee);
}
