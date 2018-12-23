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
        int errorCode = check();
        if (errorCode == 0) {
            return Health.down().withDetail("Code: ", errorCode).build();
        }
        return Health.up().withDetail("Code", errorCode).build();
    }

    public int check() {
        Video video = ngeApi.getVideo();
        if (video != null) {
            checkNum = 1;
        }
        System.out.println("----------------------");
        System.out.println("VideoName: " + video.getVideoName());
        System.out.println("checkNum: " + checkNum);
        return checkNum;
    }
}