package com.sigmaproject.repositories;


import com.sigmaproject.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class OrganizationRepositoryImpl implements OrganizationRepository {

    private static final BeanPropertyRowMapper<Organization> ROW_MAPPER =
            new BeanPropertyRowMapper<>(Organization.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrganizationRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Organization> findAll() {
        return jdbcTemplate.query("SELECT * FROM organizations;", ROW_MAPPER);
    }

    @Override
    public Organization insert(Organization organization) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps =
                    connection.prepareStatement("insert into organizations(name, phone_number, address, region, country, city, is_active, direction, number_of_Offices) values (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                            new String[]{"id"});
            ps.setString(1, organization.getName());
            ps.setString(2, organization.getPhoneNumber());
            ps.setString(3, organization.getAddress());
            ps.setString(4, organization.getRegion());
            ps.setString(5, organization.getCountry());
            ps.setString(6, organization.getCity());
            ps.setBoolean(7, organization.getIsActivective());
            ps.setString(8, organization.getDirection());
            ps.setInt(9, organization.getNumberOfOffices());
            return ps;
        }, keyHolder);
        long organizationId = keyHolder.getKey().longValue();
        return getOne(organizationId);
    }

    @Override
    public Organization getOne(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM organizations WHERE id = ?", ROW_MAPPER, id);
    }

    @Override
    public Organization update(Long id, Organization organization) {
        jdbcTemplate.update("update organizations set name = ?, phone_number = ?, address = ?, region = ?, country = ?, city = ?, is_active = ?, direction = ?, number_of_offices = ? where id = ?",
                organization.getName(), organization.getPhoneNumber(), organization.getRegion(), organization.getCountry(), organization.getCity(), organization.getIsActivective(), organization.getDirection(), organization.getNumberOfOffices(), id);
        return getOne(id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM organizations where id = ?", id);
    }

    @Override
    public List<String> getCountriesList(String region, Integer numberOfDoctors) {
        return jdbcTemplate.query(
                "SELECT organizations.country FROM organizations INNER JOIN employees e ON organizations.id = e.organization_id AND e.position = ? WHERE region = '?' GROUP BY  organizations.id having count(organizations.id ORDER BY country) > ?",
                (rs, rowNum) -> rs.getString("country"),
                "doctor",
                region,
                numberOfDoctors
        );
    }

}

