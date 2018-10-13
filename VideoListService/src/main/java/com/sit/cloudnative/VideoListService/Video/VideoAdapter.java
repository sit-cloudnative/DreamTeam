/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.cloudnative.VideoListService.Video;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VideoAdapter {
    
    public Video getVideo(Long videoId){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://ngelearning.sit.kmutt.ac.th/api/v0/video/"+videoId;
        Video video = restTemplate.getForObject(url, Video.class);
        return video;
    }
}
