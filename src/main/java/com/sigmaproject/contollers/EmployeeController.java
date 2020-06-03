package com.sigmaproject.contollers;

import com.sigmaproject.domain.Employee;
import com.sigmaproject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
    private final EmployeeService EmployeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.EmployeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee) {
        return EmployeeService.create(employee);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id) {
        EmployeeService.delete(id);
    }

    @GetMapping(value = "/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return EmployeeService.getEmployee(id);
    }

    @PutMapping(value = "{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return EmployeeService.update(id, employee);
    }
}