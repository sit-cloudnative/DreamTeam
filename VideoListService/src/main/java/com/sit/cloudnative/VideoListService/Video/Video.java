/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.cloudnative.VideoListService.Video;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "videos")
public class Video implements Serializable{
    
    @Id
    private Long videoId;
    
    private int avgTime;
    
    private int watched;
    
    @NotBlank
    private String lecturer;
    
    @NotBlank
    private String videoName;
    
    @NotBlank
    private String room;
    
    @NotBlank
    private String period;
    
    @NotBlank
    private String videoPath;

    public Video() {
    }

    @JsonCreator
    public Video(@JsonProperty("video_id") Long videoId,
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
    
    public Long getId() {
        return videoId;
    }

    public void setId(Long videoId) {
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

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getVideoName() {
        return videoName;
    }

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

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

}
