package com.sigmaproject.domain.contollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SigmaProjectController {

    @GetMapping(value = "/sigma")
    public String hello() {
        return "Hello from Sigma Project";
    }
}
