package com.codelsoft.userservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthCheck") // http://localhost:8080/healthCheck
public class HealthCheckController {
    @GetMapping("")
    public String healthCheck() {
        return "OK";
    }
}
