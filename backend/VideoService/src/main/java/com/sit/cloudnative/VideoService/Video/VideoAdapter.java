package com.sit.cloudnative.VideoService.Video;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VideoAdapter {

    public Video getVideo(long videoId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://ngelearning.sit.kmutt.ac.th/api/v0/video/" + videoId;
        Video video = restTemplate.getForObject(url, Video.class);
        return video;
    }
}
