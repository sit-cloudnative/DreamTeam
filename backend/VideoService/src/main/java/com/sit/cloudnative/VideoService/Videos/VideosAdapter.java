package com.sit.cloudnative.VideoService.Videos;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VideosAdapter {

    public Videos[] getVideo(long subjectId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://ngelearning.sit.kmutt.ac.th/api/v0/subject/" + subjectId + "/videos";
        return restTemplate.getForObject(url, Videos[].class);
    }

}
