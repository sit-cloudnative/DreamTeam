/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.cloudnative.VideoListService.Video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    
    @Autowired
    VideoAdapter videoAdapter;
    
    public Video getVideoById(Long videoId){
        Video video = videoAdapter.getVideo(videoId);
        return video;
    }
}
