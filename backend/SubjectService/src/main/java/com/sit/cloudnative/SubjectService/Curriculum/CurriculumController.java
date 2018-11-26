package com.sit.cloudnative.SubjectService.Curriculum;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.sit.cloudnative.SubjectService.TokenService;
import com.sit.cloudnative.SubjectService.exception.BadRequestException;
import com.sit.cloudnative.SubjectService.exception.NotFoundException;
import com.sit.cloudnative.SubjectService.exception.UnauthorizedException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
public class CurriculumController {

    @Autowired
    CurriculumService curriculumService;
    
    @Autowired
    private TokenService tokenService;
    
    Logger logger = LoggerFactory.getLogger(CurriculumController.class);

    @GetMapping(value = "/curriculum/{curriculumId}")
    public ResponseEntity<Curriculum> getCurriculum(@PathVariable("curriculumId") long curriculumId, 
                                                    @RequestHeader("Authorization") String auth, 
                                                    HttpServletRequest request) {
        validateToken(auth, request);
        try {
            Curriculum curriculum = curriculumService.getCurriculumById(curriculumId);
            return new ResponseEntity<>(curriculum, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            logger.warn(System.currentTimeMillis() + " | " + tokenService.getUser(auth) + " | " + "not found curriculum id (" + curriculumId + ")");
            throw new NotFoundException("curriculum " + curriculumId + " not found");
        }
    }

    @GetMapping(value = "/curriculums")
    public ResponseEntity<List<Curriculum>> getCurriculumList(@RequestHeader("Authorization") String auth,
                                                              HttpServletRequest request) {
        validateToken(auth, request);
        try {
            List<Curriculum> curriculum = curriculumService.getAllCurriculum();
            return new ResponseEntity<>(curriculum, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            logger.warn(System.currentTimeMillis() + " | " + tokenService.getUser(auth) + " | " + "empty curriculum in database");
            throw new NotFoundException("database does not have any curriculum");
        }
    }

    private void validateToken (String auth, HttpServletRequest request) {
        if(auth.trim().isEmpty()){
            logger.warn(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "Authorization token not found in header");
            throw new BadRequestException("Not have value in Authorization");
        }
        try {
            tokenService.checkToken(auth);
        } catch (AlgorithmMismatchException e) { // not match
            logger.warn(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "not match token algorithm (" + auth + ")");
            throw new UnauthorizedException(e.getMessage());
        } catch (SignatureVerificationException e) { // secret key bad
            logger.warn(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "secret key is not valid (" + auth + ")");
            throw new UnauthorizedException(e.getMessage());
        } catch (TokenExpiredException e) { // expired
            logger.warn(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "token is expired (" + auth + ")");
            throw new UnauthorizedException(e.getMessage());
        } catch (InvalidClaimException e) { // invalid claim
            logger.warn(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "invalid claim value (" + auth + ")");
            throw new UnauthorizedException(e.getMessage());
        } catch (JWTDecodeException e) {
            logger.warn(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "token does not contain 3 parts (" + auth + ")");
            throw new UnauthorizedException(e.getMessage());
        } catch (Exception e) {
            logger.warn(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "unknown error (" + auth + ")");
        }
    }
}
