package com.sit.cloudnative.CommentService.comment;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "content")
    private String content;

    @Column(name = "postUserId")
    private Long postUserId;

    @Column(name = "videoId")
    private Long videoId;

    public Comment() {
    }

    public Comment(Long commentId, String content, long postUserId) {
        this.id = commentId;
        this.content = content;
        this.postUserId = postUserId;

    }

    /**
     * @return int return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return long return the postUserId
     */
    public long getPostUserId() {
        return postUserId;
    }

    /**
     * @param postUserId the postUserId to set
     */
    public void setPostUserId(long postUserId) {
        this.postUserId = postUserId;
    }

    /**
     * @return int return the videoId
     */
    public Long getVideoId() {
        return videoId;
    }

    /**
     * @param videoId the videoId to set
     */
    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

}
