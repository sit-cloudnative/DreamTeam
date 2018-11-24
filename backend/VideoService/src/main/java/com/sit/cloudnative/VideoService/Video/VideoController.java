package com.sit.cloudnative.VideoService.Video;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.sit.cloudnative.VideoService.TokenService;
import com.sit.cloudnative.VideoService.exception.BadRequestException;
import com.sit.cloudnative.VideoService.exception.UnauthorizedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class VideoController {
    
    @Autowired
    private VideoService videoService;
    
    @Autowired
    private TokenService tokenService;

    Logger logger = LoggerFactory.getLogger(VideoController.class);
    
    @GetMapping("/video/{videoId}")
    public ResponseEntity<Video> getVideo(@PathVariable long videoId, @RequestHeader("Authorization") String auth){
        if(auth.isEmpty()){
            logger.warn(System.currentTimeMillis() + " | " + "unknown user" + " | " + "Authorization token not found in header");
            throw new BadRequestException("Not have value in Authorization");
        }
        try {
            tokenService.checkToken(auth);
        } catch (JWTVerificationException e) {
            logger.warn(System.currentTimeMillis() + " | " + auth + " | " + "invalid token");
            throw new UnauthorizedException(e.getMessage());
        }
        return new ResponseEntity<>(videoService.getVideoById(videoId), HttpStatus.OK);
    }
}
