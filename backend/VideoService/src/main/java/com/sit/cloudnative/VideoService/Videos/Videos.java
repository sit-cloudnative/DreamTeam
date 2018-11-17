package com.sit.cloudnative.VideoService.Videos;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Videos {

    private long videoId;

    private String videoName;

    private String lecturer;

    private String videoThumbnail;

    public Videos() {
    }

    @JsonCreator
    public Videos(@JsonProperty("video_id") long videoId,
            @JsonProperty("video_name") String videoName,
            @JsonProperty("teacher") Map<String, String> lecturer,
            @JsonProperty("video_thumbnail") String videoThumbnail) {
        this.videoId = videoId;
        this.videoName = videoName;
        this.lecturer = lecturer.get("teacher_name");
        this.videoThumbnail = videoThumbnail;
    }

    @JsonProperty("video_id")
    public void setVideoId(long videoId) {
        this.videoId = videoId;
    }

    @JsonProperty("video_name")
    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    @JsonProperty("teacher")
    public void setLecturer(Map<String, String> lecturer) {
        this.lecturer = lecturer.get("teacher_name");
    }

    @JsonProperty("video_thumbnail")
    public void setVideoThumbnail(String videoThumbnail) {
        this.videoThumbnail = videoThumbnail;
    }

    @JsonProperty("videoId")
    public long getVideoId() {
        return videoId;
    }

    @JsonProperty("videoName")
    public String getVideoName() {
        return videoName;
    }

    @JsonProperty("lecturer")
    public String getLecturer() {
        return lecturer;
    }

    @JsonProperty("videoThumbnail")
    public String getVideoThumbnail() {
        return videoThumbnail;
    }
}
