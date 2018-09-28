/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.cloudnative.VideoListService.Video;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "videos")
public class Video implements Serializable{
    
    @Id
    private Long id;
    
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
    public Video(@JsonProperty("teacher") String lecturer,
            @JsonProperty("video_name") String videoName, 
            @JsonProperty("room") String room, 
            @JsonProperty("video_starttime") String startTime,
            @JsonProperty("video_endtime") String endTime,
            @JsonProperty("player") String videoPath) {
        this.lecturer = lecturer;
        this.videoName = videoName;
        this.room = room;
        this.period = startTime + endTime;
        this.videoPath = videoPath;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
