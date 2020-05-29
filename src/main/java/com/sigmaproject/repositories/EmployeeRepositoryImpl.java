package com.sigmaproject.repositories;

import com.sigmaproject.domain.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final BeanPropertyRowMapper<Employee> ROW_MAPPER =
            new BeanPropertyRowMapper<>(Employee.class);

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employees;", ROW_MAPPER);
    }

    @Override
    public List<Employee> findByOrganization(long organizationId) {
        return jdbcTemplate.query("SELECT * FROM employees WHERE organization_id = ?;", ROW_MAPPER, organizationId);
    }

    @Override
    public Employee insert(Employee employee) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps =
                    connection.prepareStatement("insert into employees(name, surname, position, is_married, experience) values (?, ?, ?, ?, ?)",
                            new String[]{"id"});
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setString(3, employee.getPosition());
            ps.setBoolean(4, employee.getIsMarried());
            ps.setInt(5, employee.getExperience());
            return ps;
        }, keyHolder);
        long employeeId = keyHolder.getKey().longValue();
        return getOne(employeeId);
    }

    @Override
    public Employee getOne(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM organizations WHERE id = ?", ROW_MAPPER, id);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        jdbcTemplate.update("update employees set name = ?, surname = ?, position = ?, is_married = ?, experience = ? where id = ?",
                employee.getName(), employee.getSurname(), employee.getPosition(), employee.getIsMarried(), employee.getExperience(), id);
        return getOne(id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM employees where id = ?", id);
    }

    @Override
    public void addOrganization(long organizationId, Employee employee) {
        jdbcTemplate.update("update employees set organization_id = ? where id = ?",
                organizationId, employee.getId());
    }
}

