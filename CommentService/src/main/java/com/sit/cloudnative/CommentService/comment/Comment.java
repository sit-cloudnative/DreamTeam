package com.sit.cloudnative.CommentService.comment;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Comments")
public class Comment  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "content")
    private String content;

    @NotBlank
    @Column(name = "postUserId")
    private long postUserId;

    @Column(name = "videoId")
    private int videoId;



    

    public Comment() {
    }

    public Comment(int commentId, String content, long postUserId) {
        this.id = commentId;
        this.content = content;
        this.postUserId = postUserId;
      
       
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
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
    public int getVideoId() {
        return videoId;
    }

    /**
     * @param videoId the videoId to set
     */
    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

}

  
  
   