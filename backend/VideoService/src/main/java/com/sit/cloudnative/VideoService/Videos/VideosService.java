package com.sit.cloudnative.VideoService.Videos;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideosService {

    @Autowired
    private VideosAdapter videosAdapter;

    public List<Videos> getVideoListBySubjectId(long subjectId) {
        List<Videos> videos = Arrays.asList(videosAdapter.getVideo(subjectId));
        orderVideoByVideoIdDescending(videos);
        return videos;
    }

    private void orderVideoByVideoIdDescending(List<Videos> videos) {
        Collections.sort(videos, new Comparator<Videos>() {
            @Override
            public int compare(Videos first, Videos second) {
                if (first.getVideoId() > second.getVideoId())
                    return -1;
                if (first.getVideoId() < second.getVideoId())
                    return 1;
                return 0;
            }
        });
    }
}
