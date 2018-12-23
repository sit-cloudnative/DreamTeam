package com.sit.cloudnative.VideoService.Video;

import javax.servlet.http.HttpServletRequest;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.sit.cloudnative.VideoService.TokenService;
import com.sit.cloudnative.VideoService.exception.BadRequestException;
import com.sit.cloudnative.VideoService.exception.NotFoundException;
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
import org.springframework.web.client.HttpClientErrorException;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class VideoController {
    
    @Autowired
    private VideoService videoService;
    
    @Autowired
    private TokenService tokenService;

    Logger logger = LoggerFactory.getLogger(VideoController.class);
    
	@GetMapping("/")
    public ResponseEntity<String> welcome() {
        return new ResponseEntity<String>("Welcome to Video Service", HttpStatus.OK);
    }
	
    @GetMapping("/video/{videoId}")
    public ResponseEntity<Video> getVideo(@PathVariable long videoId, 
                                          @RequestHeader("Authorization") String auth,
                                          HttpServletRequest request){
        tokenService.validateToken(auth, request, logger);
        try {
            Video video = videoService.getVideoById(videoId);
            logger.info(System.currentTimeMillis() + " | " + tokenService.getUser(auth) + " | " + "watch video id (" + videoId + ")");
            return new ResponseEntity<>(video, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            logger.warn(System.currentTimeMillis() + " | " + tokenService.getUser(auth) + " | " + "not found video id (" + videoId + ")");
            throw new NotFoundException("video " + videoId + " not found");
        }
    }

}
