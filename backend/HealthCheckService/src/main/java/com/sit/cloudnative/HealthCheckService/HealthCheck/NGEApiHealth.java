package com.sit.cloudnative.HealthCheckService.HealthCheck;

import com.sit.cloudnative.HealthCheckService.ServiceAPI.NGEApi;
import com.sit.cloudnative.HealthCheckService.ServiceAPI.Video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class NGEApiHealth implements HealthIndicator {

    @Autowired
    private NGEApi ngeApi;

    private int checkNum = 0;

    @Override
    public Health health() {
        int code = check();
        if (code == 0) {
            return Health.down().withDetail("Code: ", code).build();
        }
        return Health.up().withDetail("Code", code).build();
    }

    public int check() {
        Video video = ngeApi.getVideo();
        if (video != null) {
            checkNum = 1;
        }
        return checkNum;
    }
}