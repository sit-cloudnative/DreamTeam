package com.sit.cloudnative.VideoService.Videos;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.sit.cloudnative.VideoService.TokenService;
import com.sit.cloudnative.VideoService.exception.BadRequestException;
import com.sit.cloudnative.VideoService.exception.NotFoundException;
import com.sit.cloudnative.VideoService.exception.UnauthorizedException;
import java.util.List;

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
public class VideosController {

    @Autowired
    private VideosService videosService;
    
    @Autowired
    private TokenService tokenService;

    Logger logger = LoggerFactory.getLogger(VideosController.class);

    @GetMapping("/videos/{subjectId}")
    public ResponseEntity<List<Videos>> getVideoList(@PathVariable long subjectId, @RequestHeader("Authorization") String auth) {
        validateToken(auth);
        try {
            List<Videos> videoList = videosService.getVideoListBySubjectId(subjectId);
            return new ResponseEntity<>(videoList, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            logger.warn(System.currentTimeMillis() + " | " + tokenService.getUser(auth) + " | " + "invalid subject id (" + subjectId + ")");
            throw new NotFoundException("subject " + subjectId + " not found");
        }
    }

    private void validateToken (String auth) {
        if(auth.trim().isEmpty()){
            logger.warn(System.currentTimeMillis() + " | " + "unknown user" + " | " + "Authorization token not found in header");
            throw new BadRequestException("Not have value in Authorization");
        }
        try {
            tokenService.checkToken(auth);
        } catch (AlgorithmMismatchException e) { // not match
            logger.warn(System.currentTimeMillis() + " | " + auth + " | " + "not match algorithm");
            throw new UnauthorizedException(e.getMessage());
        } catch (SignatureVerificationException e) { // secret key bad
            logger.warn(System.currentTimeMillis() + " | " + auth + " | " + "secret key is not valid");
            throw new UnauthorizedException(e.getMessage());
        } catch (TokenExpiredException e) { // expired
            logger.warn(System.currentTimeMillis() + " | " + auth + " | " + "token is expired");
            throw new UnauthorizedException(e.getMessage());
        } catch (InvalidClaimException e) { // invalid claim
            logger.warn(System.currentTimeMillis() + " | " + auth + " | " + "invalid claim value");
            throw new UnauthorizedException(e.getMessage());
        } catch (Exception e) {
            logger.warn(System.currentTimeMillis() + " | " + auth + " | " + "unknow error");
        }
    }

}
