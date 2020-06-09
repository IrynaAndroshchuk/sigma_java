package com.sigmaproject.services;

import com.sigmaproject.domain.Employee;
import com.sigmaproject.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class EmployeeServiceImpl implements EmployeeService {
    protected final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployee(Long employeeId) {
        return employeeRepository.getOne(employeeId);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee create(Long organizationId, Employee employee) {
        employeeRepository.addOrganization(organizationId, employee);
        return employeeRepository.insert(employee);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        return employeeRepository.update(id, employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public void addOrganization(Long organizationId, Employee employee) {
        employeeRepository.addOrganization(organizationId, employee);
    }
}