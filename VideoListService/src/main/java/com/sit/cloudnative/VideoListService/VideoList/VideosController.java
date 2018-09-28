package com.sit.cloudnative.VideoListService.VideoList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideosController {

    @Autowired
    VideosService videosService;

    @GetMapping("/videos/{subjectId}")
    public ResponseEntity<List<Videos>> getVideos(@PathVariable("subjectId") long subjectId) {
        List<Videos> videos = videosService.getVideosBySubjectId(subjectId);
        System.out.println("*******VidoName*******");
        System.out.println(videos.get(0).getVideoName());
        return new ResponseEntity<List<Videos>>(videos, HttpStatus.OK);
    }
}