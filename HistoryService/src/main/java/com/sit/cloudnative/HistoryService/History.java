package com.sit.cloudnative.HistoryService;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "histories")
class History implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long historyId;

    @NotBlank
    private long studentId;
     
    @NotBlank
    private long videoId;

    @NotBlank
    private String videoName;

    private String lecturer;

    private String videoThumbnail;

    private int checkpoint;

    public History() {
    }

    public long getHistoryId() {
        return historyId;
    }

    public int getCheckpoint() {
        return checkpoint;
    }

    public String getVideoThumbnail() {
        return videoThumbnail;
    }

    public String getLecturer() {
        return lecturer;
    }

    public String getVideoName() {
        return videoName;
    }

    public long getVideoId() {
        return videoId;
    }

    public void setCheckpoint(int checkpoint) {
        this.checkpoint = checkpoint;
    }

    public void setVideoThumbnail(String videoThumbnail) {
        this.videoThumbnail = videoThumbnail;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public void setVideoId(long videoId) {
        this.videoId = videoId;
    }

    public void setHistoryId(long historyId) {
        this.historyId = historyId;
    }
}
