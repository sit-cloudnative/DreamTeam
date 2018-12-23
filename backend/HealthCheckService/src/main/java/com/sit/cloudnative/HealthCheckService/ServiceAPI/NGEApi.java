package com.sit.cloudnative.HealthCheckService.ServiceAPI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NGEApi {

    private final String videoIdForTest = "8960";
    private final String url = "https://ngelearning.sit.kmutt.ac.th/api/v0/video/" + videoIdForTest;

    public Video getVideo() {
        RestTemplate restTemplate = new RestTemplate();
        Video video = null;
        try {
            video = restTemplate.getForObject(url, Video.class);
        } catch (Exception ex) {
            
        }

        return video;
    }
}