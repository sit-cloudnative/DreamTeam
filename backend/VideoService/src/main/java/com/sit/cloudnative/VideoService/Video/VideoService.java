package com.sit.cloudnative.VideoService.Video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    
    @Autowired
    VideoAdapter videoAdapter;
    
    public Video getVideoById(long videoId){
        return videoAdapter.getVideo(videoId);
    }
}
