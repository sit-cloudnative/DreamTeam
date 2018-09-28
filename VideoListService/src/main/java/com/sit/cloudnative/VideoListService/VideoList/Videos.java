package com.sit.cloudnative.VideoListService.VideoList;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Videos implements Serializable {
    private int videoId;
    private String videoName;
    private String lecturer;
    private String videoThumbnail;

    public Videos(){}

    @JsonCreator //test
    public Videos(@JsonProperty("video_id") int videoId, 
                  @JsonProperty("video_name")  String videoName, 
                  @JsonProperty("teacher")  Map<String, String> lecturer, 
                  @JsonProperty("video_thumbnail")  String videoThumbnail){
        this.videoId = videoId;
        this.videoName = videoName;
        this.lecturer = lecturer.get("teacher_name");
        this.videoThumbnail = videoThumbnail;
    }

    public void setVideoId(int videoId){
        this.videoId = videoId;
    }
    public void setVideoName(String videoName){
        this.videoName = videoName;
    }
    public void setLecturer(String lecturer){
        this.lecturer = lecturer;
    }
    public void setVideoThumbnail(String videoThumbnail){
        this.videoThumbnail = videoThumbnail;
    }
    
    public int getVideoId(){
        return videoId;
    }
    public String getVideoName(){
        return videoName;
    }
    public String getLecturer(){
        return lecturer;
    }
    public String getVideoThumbnail(){
        return videoThumbnail;
    }
}