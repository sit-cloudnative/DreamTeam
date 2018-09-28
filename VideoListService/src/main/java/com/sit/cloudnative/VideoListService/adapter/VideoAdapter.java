package com.sit.cloudnative.VideoListService.adapter;

import com.sit.cloudnative.VideoListService.VideoList.Videos;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VideoAdapter {
    public Videos[] getVideosBySubjectId(long subjectId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://ngelearning.sit.kmutt.ac.th/api/v0/subject/" + subjectId + "/videos";
        Videos videos[] = restTemplate.getForObject(url, Videos[].class);
        return videos;
    }

}