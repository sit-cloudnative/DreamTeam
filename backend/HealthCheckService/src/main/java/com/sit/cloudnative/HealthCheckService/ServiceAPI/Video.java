package com.sit.cloudnative.HealthCheckService.ServiceAPI;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Map;

public class Video {

    private long videoId;

    private int avgTime;

    private int watched;

    private String lecturer;

    private String videoName;

    private String room;

    private String period;

    private String videoPath;

    public Video() {
    }

    @JsonCreator
    public Video(@JsonProperty("video_id") long videoId,
            @JsonProperty("teacher") Map<String, String> lecturer,
            @JsonProperty("video_name") String videoName,
            @JsonProperty("room") Map<String, String> room,
            @JsonProperty("video_starttime") String startTime,
            @JsonProperty("video_endtime") String endTime,
            @JsonProperty("player") Map<String, String> videoPath) {
        this.videoId = videoId;
        this.lecturer = lecturer.get("teacher_name");
        this.videoName = videoName;
        this.room = room.get("room_name");
        this.period = startTime + " - " + endTime;
        this.videoPath = videoPath.get("hls_url");
    }

    @JsonGetter("videoId")
    public long getVideoId() {
        return videoId;
    }
    @JsonSetter("video_id")
    public void setVideoId(long videoId) {
        this.videoId = videoId;
    }

    public int getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(int avgTime) {
        this.avgTime = avgTime;
    }

    public int getWatched() {
        return watched;
    }

    public void setWatched(int watched) {
        this.watched = watched;
    }

    @JsonGetter("lecturer")
    public String getLecturer() {
        return lecturer;
    }
    @JsonSetter("teacher")
    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }
    @JsonGetter("videoName")
    public String getVideoName() {
        return videoName;
    }
    @JsonSetter("video_name")
    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
    @JsonGetter("videoPath")
    public String getVideoPath() {
        return videoPath;
    }
    @JsonSetter("player")
    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
}