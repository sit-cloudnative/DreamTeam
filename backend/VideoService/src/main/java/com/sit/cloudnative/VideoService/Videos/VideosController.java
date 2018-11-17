package com.sit.cloudnative.VideoService.Videos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class VideosController {

    @Autowired
    private VideosService videosService;

    @GetMapping("/videos/{subjectId}")
    public ResponseEntity<List<Videos>> getVideoList(@PathVariable long subjectId) {
        List<Videos> videoList = videosService.getVideoListBySubjectId(subjectId);
        return new ResponseEntity<>(videoList, HttpStatus.OK);
    }

}
