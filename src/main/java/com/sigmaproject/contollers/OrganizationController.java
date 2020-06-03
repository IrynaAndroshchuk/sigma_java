package com.sigmaproject.contollers;

import com.sigmaproject.domain.Organization;
import com.sigmaproject.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/organizations", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizationController {
    private final OrganizationService OrganizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.OrganizationService = organizationService;
    }

    @GetMapping(value = "/{id}")
    public Organization getOrganization(@PathVariable Long id) {
        return OrganizationService.getOrganization(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Organization createOrganization(@RequestBody Organization organization) {
        return OrganizationService.create(organization);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable Long id) {
        OrganizationService.delete(id);
    }

    @GetMapping
    public List<Organization> getOrganizations() {
        return OrganizationService.findAll();
    }

    @PutMapping(value = "{id}")
    public Organization updateOrganization(@PathVariable Long id, @RequestBody Organization organization) {
        return OrganizationService.update(id, organization);
    }
}
