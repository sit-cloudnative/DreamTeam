package com.sit.cloudnative.VideoService.Videos;

import java.util.Date;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Videos {

    private long videoId;

    private String videoName;

    private String lecturer;

    private String videoThumbnail;

    private String videoDate;

    public Videos() {
    }

    @JsonCreator
    public Videos(@JsonProperty("video_id") long videoId,
                  @JsonProperty("video_name") String videoName,
                  @JsonProperty("teacher") Map<String, String> lecturer,
                  @JsonProperty("video_thumbnail") String videoThumbnail,
                  @JsonProperty("video_date") String videoDate) {
        this.videoId = videoId;
        this.videoName = videoName;
        this.lecturer = lecturer.get("teacher_name");
        this.videoThumbnail = videoThumbnail;
        this.videoDate = videoDate;
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
    @JsonProperty("videoDate")
    public String getVideoDate() {
        return videoDate;
    }
    @JsonProperty("video_date")
    public void setVideoDate(String videoDate) {
        this.videoDate = videoDate;
    }
}
