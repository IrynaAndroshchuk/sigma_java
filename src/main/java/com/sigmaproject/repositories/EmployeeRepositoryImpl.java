package com.sigmaproject.repositories;

import com.sigmaproject.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employees;", ROW_MAPPER);
    }

    @Override
    public Employee insert(Employee employee) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps =
                    connection.prepareStatement("insert into employees(name, surname, is_married, experience) values (?, ?, ?, ?)",
                            new String[]{"id"});
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setBoolean(3, employee.getIsMarried());
            ps.setInt(4, employee.getExperience());
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
        jdbcTemplate.update("update employees set name = ?, surname = ?, is_married = ?, experience = ? where id = ?",
                employee.getName(), employee.getSurname(), employee.getIsMarried(), employee.getExperience(), id);
        return getOne(id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM employees where id = ?", id);
    }
}
