package com.sigmaproject.repositories;

import com.sigmaproject.domain.Organization;

import java.util.List;

public interface OrganizationRepository {
    List<Organization> findAll();

    Organization insert(Organization organization);

    Organization getOne(long organizationId);

    Organization update(Long id, Organization organization);

    void delete(Long id);
}
