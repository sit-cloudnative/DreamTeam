package com.sit.cloudnative.VideoListService.VideoList;

import java.util.Arrays;
import java.util.List;
import com.sit.cloudnative.VideoListService.adapter.VideoAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideosService{
    @Autowired 
    VideoAdapter videoAdapter;

    List<Videos> getVideosBySubjectId(long subjectId){
        return Arrays.asList(videoAdapter.getVideosBySubjectId(subjectId));
    }
}