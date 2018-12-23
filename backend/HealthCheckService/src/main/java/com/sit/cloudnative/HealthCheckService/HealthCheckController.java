package com.sit.cloudnative.HealthCheckService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController{

    @GetMapping("/")
    public ResponseEntity<String> welcome(){
        return new ResponseEntity<>("Welcome to HealthCheck Service",HttpStatus.OK);
    }
}