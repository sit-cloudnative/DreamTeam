package com.sit.cloudnative.CommentService.comment;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    // // Get Comment of video
    @GetMapping("/comment/{video_id}")
    public ResponseEntity<List<Comment>> getComment(@PathVariable("video_id") Long videoId) {
        List<Comment> comments;
        comments = commentService.getCommentByVideoId(videoId);
        return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
    }

    // // Get All Comment
    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comment = commentService.getAllComments();
        return new ResponseEntity<List<Comment>>(comment, HttpStatus.OK);
    }

    // // Create Comment
    @PostMapping("/comment")
    public ResponseEntity<Comment> createUser(@Valid @RequestBody Comment comment) {
        Comment comment_object = commentService.create(comment);
        return new ResponseEntity<Comment>(comment_object, HttpStatus.OK);
    }

    // // Delete a Comment
    @DeleteMapping("/comment/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable(value = "id") Long commentId) {
        Comment comment = commentService.getCommentById(commentId);
        commentService.delete(comment);
        return ResponseEntity.ok().build();
    }

}