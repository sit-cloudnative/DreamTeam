package com.sit.cloudnative.VideoListService.VideoList;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideosService {

    @Autowired
    private VideosAdapter videosAdapter;

	public List<Videos> getVideoListBySubjectId(int subjectId) {
        return Arrays.asList(videosAdapter.getVideo(subjectId)); 
    }
}