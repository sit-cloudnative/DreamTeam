package com.sit.cloudnative.VideoListService.Video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VideoController {
    
    @Autowired
    VideoService videoService;
    
    @GetMapping("/video/{videoId}")
    public ResponseEntity<Video> getVideo(@PathVariable Long videoId){
        return new ResponseEntity<>(videoService.getVideoById(videoId), HttpStatus.OK);
    }
}
