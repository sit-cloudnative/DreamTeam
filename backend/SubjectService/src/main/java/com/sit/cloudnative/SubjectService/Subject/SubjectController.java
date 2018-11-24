package com.sit.cloudnative.SubjectService.Subject;

import java.util.List;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.sit.cloudnative.SubjectService.TokenService;
import com.sit.cloudnative.SubjectService.exception.BadRequestException;
import com.sit.cloudnative.SubjectService.exception.NotFoundException;
import com.sit.cloudnative.SubjectService.exception.UnauthorizedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class SubjectController {

    @Autowired
    SubjectService subjectListService;
        
    @Autowired
    private TokenService tokenService;

    @Autowired
    TokenService tokenService;

    Logger logger = LoggerFactory.getLogger(SubjectController.class);

    @RequestMapping(value = "/curriculum/{curriculumId}/subjectlist", method = RequestMethod.GET)
    public ResponseEntity<List<Subject>> getSubjectListByCurriculumId(@PathVariable("curriculumId") long curriculumId, @RequestHeader("Authorization") String auth) {
        validateToken(auth);
        try {
            List<Subject> subjectList = subjectListService.getSubjectListByCurriculumId(curriculumId);
            return new ResponseEntity<>(subjectList, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            logger.warn(System.currentTimeMillis() + " | " + tokenService.getUser(auth) + " | " + "not found curriculum id (" + curriculumId + ")");
            throw new NotFoundException("curriculum " + curriculumId + " not found");
        }
    }

    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable long subjectId, @RequestHeader("Authorization") String auth) {
        validateToken(auth);
        try {
            Subject subject = subjectListService.getSubjectById(subjectId);
            return new ResponseEntity<>(subject, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            logger.warn(System.currentTimeMillis() + " | " + tokenService.getUser(auth) + " | " + "not found subject id (" + subjectId + ")");
            throw new NotFoundException("subject " + subjectId + " not found");
        }
    }

    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getSubjectList(@RequestParam String keyword, @RequestHeader("Authorization") String auth) {
        if (auth.isEmpty()) {
            throw new BadRequestException("Not have value in Authorization");
        }
        try {
            tokenService.checkToken(auth);
            List<Subject> subjectList = subjectListService.searchSubject(keyword.toLowerCase());
            logger.info("Searching for " + keyword);
            return new ResponseEntity<>(subjectList, HttpStatus.OK);
        } catch (JWTVerificationException e) {
            throw new UnauthorizedException(e.getMessage());
        } catch (Exception e) {
            throw new NotFoundException(keyword + ": Keyword is not found");
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
            logger.warn(System.currentTimeMillis() + " | " + auth + " | " + "not match token algorithm");
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
