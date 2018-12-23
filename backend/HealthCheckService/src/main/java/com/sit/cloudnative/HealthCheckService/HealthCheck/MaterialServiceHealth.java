package com.sit.cloudnative.HealthCheckService.HealthCheck;

import com.sit.cloudnative.HealthCheckService.ServiceAPI.MaterialApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MaterialServiceHealth implements HealthIndicator {

    @Autowired
    private MaterialApi materialApi;
    
    private int checkNum = 0;

    @Override
    public Health health() {
        int code = check();
        if (code == 0) {
            return Health.down().withDetail("Code: ", code).build();
        }
        return Health.up().withDetail("Code: ", code).build();
    }

    private int check() {
        String message = materialApi.getMessage();
        if (message != null) {
            checkNum = 1;
        }
        return checkNum;
    }

}