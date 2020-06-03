package com.sigmaproject.config;

import com.sigmaproject.repositories.EmployeeRepository;
import com.sigmaproject.repositories.OrganizationRepository;
import com.sigmaproject.services.OrganizationService;
import com.sigmaproject.services.OrganizationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public OrganizationService OrganizationService(OrganizationRepository organizationRepository, EmployeeRepository employeeRepository) {
        return new OrganizationServiceImpl(organizationRepository, employeeRepository);
    }
}
