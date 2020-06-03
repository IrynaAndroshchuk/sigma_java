package com.sigmaproject.repositories;

import com.sigmaproject.domain.Employee;

        import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();

    List<Employee> findByOrganizationId(Long organizationId);

    Employee insert(Employee employee);

    Employee getOne(Long employee);

    Employee update(Long id, Employee employee);

    public void delete(Long id);

    public void addOrganization(Long organizationId, Employee employee);
}
